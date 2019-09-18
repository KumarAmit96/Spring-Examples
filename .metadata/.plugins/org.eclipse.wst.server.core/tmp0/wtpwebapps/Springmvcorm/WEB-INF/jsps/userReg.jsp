<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="registerUser" method="post">
		<pre>
		ID: <input type="text" name="id"> 
		NAME: <input type="text" name="name"> 
		EMAIL: <input type="text" name="email"> 
		<input type="submit" name="register">
	    </pre>
	</form>
	
	<br/>${result}
	
</body>
</html>