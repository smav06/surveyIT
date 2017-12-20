<?php

require_once '../includes/init.php';	

$name= $_POST["name"];
$email = $_POST["email"];
$pass = $_POST["password"];

$query = "SELECT * FROM userinfo WHERE username like'".$email."';";
$result = mysqli_query($con,$query);
 
if(mysqli_num_rows($result)>0){
	$response = array();
	$code = "reg_false";
	$message = "User already exist...";
	array_push($response,array("code"=>$code,"message"=>$message));
	echo json_encode(array("server_response"=>$response));
}

else{
	$query = "INSERT INTO userinfo(`user_id`, `name`, `username`, `password`) VALUES (NULL,'".$name."','".$email."','".$pass."');";
	//INSERT INTO `userinfo` (`user_id`, `name`, `username`, `password`) VALUES (NULL, 'f', 'f', 'f')
	$result = mysqli_query($con,$query);

	if(!$result){
		$response = array();
		$code = "reg_false";
		$message = "Some Error Occured";
		array_push($response,array("code"=>$code,"message"=>$message));
		echo json_encode(array("server_response"=>$response));
	}
	else{
		$response = array();
		$code = "reg_true";
		$message = "Registration Success";
		array_push($response,array("code"=>$code,"message"=>$message));
		echo json_encode(array("server_response"=>$response));
	}
	mysqli_close($con);
}

?>