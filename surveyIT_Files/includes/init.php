<?php

$host = "localhost";
$user = "root";
$password = "shishi";
$dbname = "surveyitdb";

$con = mysqli_connect($host,$user,$password,$dbname);

if(!$con){
	die("Error in databasr connection". mysqli_connect_error()); 
}


?>