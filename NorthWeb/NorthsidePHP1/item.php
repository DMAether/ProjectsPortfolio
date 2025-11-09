<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Item</title>
        <link rel="stylesheet" href="styles//itemStyle.css">
        <link rel="stylesheet" href="styles//globalStyles.css">
    </head>
    <body>
        <?php
            include_once 'db/connect.php';
            
            $prodID = htmlspecialchars($_GET['data']);
            $stmt = $db->query("SELECT * FROM catalogue WHERE prodID = '" . $prodID . "';");
            $title;
            $descr;
            $prodImg;
            $qnty;
            $price;
            while ($row = $stmt->fetch()){
                $title = $row['title'];
                $descr = $row['description'];
                $prodImg = $row['prodImg'];
                $qnty = $row['qnty'];
                $price = $row['avgPrice'];
            }
        ?>
        <header>
            <img class="logo" src="images//logo.png" alt="company logo">
            <div class="menu">
                <button class="menItem">Home</button>
                <button class="menItem" onclick="redirect('about')">About</button>
                <button class="menItem" onclick="redirect('contact')">Contact</button>
                <div class="dropdown">
                    <button class="cat" onclick="redirect('catalogue')">Catalogue</button>
                    <div class="catalogue">
                        <a class="catSelect" onclick="window.location.href='catalogue.html#dops'">Dops</a>
                        <a class="catSelect" onclick="window.location.href='catalogue.html#polishing'">Polishing</a>
                        <a class="catSelect" onclick="window.location.href='catalogue.html#liquids'">Liquids</a>
                    </div>
                </div>
            </div>
        </header>
        <h1>
            <?php
            echo $title;
            ?>
        </h1>
        <div class="item_display">
            <img class="prod" src="<?php
            echo $prodImg;
            ?>" alt="item">
            <div class="info">
                <p class="desc">
                    <?php
                    echo $descr;
                    ?>
                </p>
                <div class="info_bottom">
                    <p class="stock">
                        <?php
                        echo $qnty;
                        ?>
                    </p><p class="remaining">remaining</p>
                    <p class="price">
                        <?php
                        echo $price;
                        ?>
                    </p>
                    <button class="add">Add</button>
                </div>     
            </div>  
        </div>
        <footer>
            <div class="block">
                <div class="so_block">
                    <a href="https://www.facebook.com/northsidediamondtools.co.za/"><img class="socials" src="images//facebook.png" alt="facebook.png"></a>
                </div>
            </div>
            <p class="contacts">sales@northsidediamondtools.co.za</p>
        </footer>
    </body>
    <script>
        function redirect(page) {
            window.location.replace('./'+ page + '.html');
        }
        
        function show3(data){
            
            document.getElementById('cart').classList.remove('hidden');
            var count = 1;
            var cart = document.getElementById('cart');
            while (count <= 5){
                count++;
                cart.innerHTML += 'penis'
            }
        }
    </script>
</html>
