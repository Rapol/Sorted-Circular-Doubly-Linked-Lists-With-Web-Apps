<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main App</title>
<style>
	#mainView,#mainAdd {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	color: green;
	position:relative;
}
#stage {
	margin: 0px auto;
	width: 200px;
	height: 80px;
	position: relative;
	padding:15px;
	margin-bottom: 20px;
	border: green;
	box-shadow: 0 0 5px 5px rgba(0, 0, 0, 0.5);
	border-radius: 10px;
}
#searchButton,#addButton {
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

#searchButton:hover,#addButton:hover {
	color: black;
	box-shadow: 5px 3px 3px rgba(0, 0, 0, 0.3);
}

#searchButton:active,#addButton:active {
	box-shadow: 5px 3px 3px rgba(0, 256, 0, 0.8);
}
</style>
</head>
<body>
	<div id="stage" align=center>
		<form id="mainView" action="searchStudent.jsp" method="GET">
			<font>Search Student</font>: <input id="searchButton"type="submit"
				value="Go">
		</form>
		<p>
		<form id="mainAdd" action="addStudent.jsp" method="GET">
			<font>Add Student</font>: <input id="addButton" type="submit"
				value="Go">
		</form>
	</div>
</body>
</html>