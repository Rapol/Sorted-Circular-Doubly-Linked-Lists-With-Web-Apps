<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
*
{
  font-family: Arial, Helvetica, sans-serif;
	color: green;
}
#loginForm,p {
	font-size: 14px;
}
h1{
font-size: 18px;
}

#submitButton {
	font-size: 14px;
	padding: 5px 15px;
	border: 2px solid #000;
	cursor: pointer;
	border-radius: 20px;
	box-shadow: 5px 3px 3px rgba(0, 100, 0, 0.3);
	user-select: none;
}

#submitButton:hover {
	color: black;
	box-shadow: 5px 3px 3px rgba(0, 0, 0, 0.3);
}

#submitButton:active {
	box-shadow: 5px 3px 3px rgba(0, 256, 0, 0.3);
}

#username,#password {
	font-size: 15px;
	width: 75px;
	padding: 5px 10px;
	border: 2px solid #000;
	box-shadow: 5px 3px 3px rgba(0, 0, 0, 0.3);
	border-radius: 10px;
}

#img {
	padding-bottom: 10px;
}

#stage {
	margin: 0px auto;
	width: 300px;
	height: 300px;
	position: relative;
	margin-bottom: 20px;
}

#section {
	margin: 0px auto;
	width: 330px;
	height: auto;
	padding: 5px;
	border: green;
	box-shadow: 0 0 5px 5px rgba(0, 0, 0, 0.5);
	border-radius: 10px;
}
#password{
	margin-right:36px;
}
</style>
</head>
<body>
	<div id="section">
		<div id="stage" align="center">
			<img id="img" src="rum.png" height="100" />
			<h1>Student Database Information</h1>
			<p>
			<p>Please Enter your username and password</p>
			<form id=loginForm action="Login" method="POST">
				User : <input type="text" name="username" id="username">
				<p>
					Passsword: <input type="password" name="password" id="password">
				<p>
					<input type="submit" value="Submit" id="submitButton">
			</form>
			<!--<a href="http://thenewboston.com">TheNewBoston</a>-->
		</div>
	</div>
</body>
</html>