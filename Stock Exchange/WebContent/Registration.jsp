<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stock Exchange</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div class="center">
		<form action="UserData.jsp" method="post">
			<div class="container">
				<h1>Register</h1>
				<p>Please fill in this form to create an account.</p>
				<hr>

				<label for="email"><b>Username</b></label> <input type="text"
					placeholder="Enter username" name="email" required> <label
					for="psw"><b>Password</b></label> <input type="password"
					placeholder="Enter Password" name="psw" required> <label
					for="psw-repeat"><b>Repeat Password</b></label> <input
					type="password" placeholder="Repeat Password" name="pswrepeat"
					required>
				<hr>

				<p>
					By creating an account you agree to our <a href="#">Terms &
						Privacy</a>.
				</p>
				<button type="submit" class="registerbtn">Register</button>
			</div>
			<% session.setAttribute("page", "registration"); %>
			<div class="container signin">
				<p>
					Already have an account? <a href="loginPage.jsp">Sign in</a>.
				</p>
			</div>
		</form>
	</div>
</body>
</html>