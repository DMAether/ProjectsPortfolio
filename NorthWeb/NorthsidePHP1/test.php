<?php
$servername = "mysql:host=localhost";
$dbname = "NorthsideDB";
$username = "readonly";
$password = "p*sJ?wHs!ijfJAJ&";

$conn = mysqli_connect($servername, $username, $password, $dbname);

$prodID = htmlspecialchars($_GET['data']);
$sql = "SELECT * FROM catalogue WHERE prodID = '" + $prodID + "';";
$result = mysqli_query($conn, $sql);

while($row = mysqli_fetch_assoc($result)){
                    echo $row['title'];
}

$statement = $db->prepare('INSERT INTO clients (name, email, phone, password) VALUES (:name, :email, :phone, :password)');
$statement->execute([
    'name' => $_GET['name'],
    'email' => $_GET['email'],
    'phone' => $_GET['phone'],
    'password' => $_GET['pass'],
]);