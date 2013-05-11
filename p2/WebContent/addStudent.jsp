<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
<style>
*
{
  font-family: Arial, Helvetica, sans-serif;
	font-size: 17px;
	color: green;
}
#stage {
	margin: 0px auto;
	width: 330px;
	height: auto;
	padding: 5px;
	border: green;
	box-shadow: 0 0 5px 5px rgba(0, 0, 0, 0.5);
	border-radius: 10px;
}
#submitButton {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	color: green;
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
#sId,#phone,#fName,#lName,#age,#gpa{
	font-family: Arial, Helvetica, sans-serif;
	font-size: 15px;
	color: green;
	width: 75px;
	padding: 5px 10px;
	border: 2px solid #000;
	box-shadow: 5px 3px 3px rgba(0, 0, 0, 0.3);
	border-radius: 10px;
}
</style>
</head>
<body>
	<div id="stage" align="center">
		<h2>New Student Information</h2>
		<div>
			<form id="addStudent" action="AddStudent" method="POST">
				Student Id : <input id="sId" type="text" name="studentId">
				<p>
					First Name : <input id="fName" type="text" name="firstName">
				<p>
					Last Name : <input id="lName" type="text" name="lastName">
				<p>
					Phone : <input id="phone"  type="text" name="phone">
				<p>
					Age : <input id="age" type="text" name="age">
				<p>
					GPA : <input id="gpa"  type="text" name="gpa">
				<p>
					<input id="submitButton"type="submit" value="Submit">
			</form>
		</div>
	</div>
</body>
</html>