<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>STOCK EXCHANGE</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div class="center">
		<form action="UserData.jsp" method="post">
			<div class="imgcontainer">
				<img src="img/logo.png" alt="Avatar" class="avatar">
			</div>

			<div class="container">
				<label for="uname"><b>Username</b></label> <input type="text"
					placeholder="Enter Username" name="uname" required> <label
					for="psw"><b>Password</b></label> <input type="password"
					placeholder="Enter Password" name="psw" required>
			        <% session.setAttribute("page", "login"); %>

				<button type="submit">Login</button>
				<label> <input type="checkbox" checked="checked"
					name="remember"> Remember me
				</label>
			</div>

			<div class="container" style="background-color: #f1f1f1">
				<button type="button" class="cancelbtn">Cancel</button>
				<span class="psw">No Account. <a href="Registration.jsp">Please register first!</a></span>
			</div>
		</form>
	</div>
</body>
</html>