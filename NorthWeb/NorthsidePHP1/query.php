<?php
    include_once 'connect.php';
?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
        $stmt = $db->query("select * FROM catalogue WHERE prodID='D124';");
        $titleArr = [];
        while ($titles = $stmtfinal->fetch()){
            $titleArr = $titles['title'];
        }
        ?>
    </body>
</html>
