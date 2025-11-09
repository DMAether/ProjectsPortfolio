<?php
    include_once 'connect.php';
    try {
        if ($_SERVER["REQUEST_METHOD"] == "POST") {
            
            $name = htmlspecialchars($_POST['name']);
            $email = htmlspecialchars($_POST['email']);
            $pass = htmlspecialchars($_POST['pass']);
            $phone = htmlspecialchars($_POST['phone']);

            $statement = $db->prepare('INSERT INTO clients (name, email, phone, password) VALUES (:name, :email, :phone, :password)');
            $statement->execute([
                'name' => $name,
                'email' => $email,
                'phone' => $phone,
                'password' => $pass,
            ]);
            echo "Created account for: $email";
        } else {
            echo 'failed';
        }
        
        if ($_SERVER["REQUEST_METHOD"] == "POST" && $_POST['action'] == "login") {
            $email = htmlspecialchars($_POST['email']);
            $pass = htmlspecialchars($_POST['pass']);
            $stmt = $db->query("SELECT * FROM clients WHERE email = '" . $email . "' AND password = '" . $pass . "';");
            $row = $stmt->fetch();
            
            if (!empty($row)) {
                //copy from here when you get back!!!!
                $stmt = $db->query("SELECT orderID FROM orders WHERE clientID = '" . $row['clientID'] . "';");
                $order = $stmt->fetch();
                if(empty($order)){
                    $stmt = $db->prepare("INSERT INTO orders (clientID) VALUES ('" . $row['clientID'] . "');");
                    $stmt->execute();
                    $stmt = $db->query("SELECT orderID FROM orders WHERE clientID = '" . $row['clientID'] . "';");
                    $order = $stmt->fetch();
                }
                //when continuing, fetch assigned orderid using query, with WHERE as clientID, and insert entry into order_items
                $prodID = htmlspecialchars($_POST['data']);
                $stmt = $db->prepare("INSERT INTO order_items (orderID, prodID, clientID) VALUES ('" . $order['orderID'] . "', '" . $prodID . "', '" . $row['clientID']."');");
                $stmt->execute();
                //stop copy here
                $stmtfinal = $db->query("SELECT catalogue.title FROM catalogue JOIN order_items ON catalogue.prodID = order_items.prodID WHERE order_items.orderID = ".$order['orderID'].";");
                $titles = $stmtfinal->fetch();
                echo $titles;
            } else {
                echo "fail";
            }
            


        }
    } catch (Exception $ex) {
        echo 'failed '. $ex;
    }
    

