<?php
$mysqli = new mysqli("localhost", "root", "your_password", "kosmewiki");


if (mysqli_connect_errno()) {
    printf("Connect failed: %s\n", mysqli_connect_error());
    exit();
}
else{
    $mysqli->select_db("logowanie");
}