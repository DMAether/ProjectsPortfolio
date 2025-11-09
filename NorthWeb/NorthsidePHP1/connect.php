<?php
$dsn = 'mysql:host=localhost;dbname=NorthsideDB';
$username = 'readonly';
$password = 'p*sJ?wHs!ijfJAJ&';
$db;
try {
    $db = new PDO($dsn, $username, $password);
    echo 'success';
    $db -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $ex) {
    echo 'failed: ' . $ex->getMessage();
}
