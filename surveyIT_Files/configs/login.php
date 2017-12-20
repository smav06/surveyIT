<?php

require_once '../includes/init.php';

$email = $_POST["email"];
$pass = $_POST["password"];

//$email = "shiela";
//$pass="shiela";


$query = "SELECT * FROM userinfo WHERE username LIKE '".$email."' AND password LIKE '".$pass."';";
$result = mysqli_query($con,$query);


if(mysqli_num_rows($result)>0){
	//$name = $_POST["name"];
	$response = array();
	$code = "login_true";
	$row = mysqli_fetch_array($result);
	$name = $row[1];//name
	$message = "Login Success! Welcome ".$name;
	array_push($response,array("code"=>$code,"message"=>$message));
	echo json_encode(array("server_response"=>$response));

}
else{
	$response = array();
	$code = "login_false";
	$message = "Login Failed! Try again ".$name;
	array_push($response,array("code"=>$code,"message"=>$message));
	echo json_encode(array("server_response"=>$response));
}

mysqli_close($con);

?>