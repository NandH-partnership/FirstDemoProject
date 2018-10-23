<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Login Page</title>
</head>
<body bgcolor="purple">
<form action="login">


		<h1>
			<font color="Yellow">Login Page</font>
		</h1>

		<h3>
			<font color="White">${msg}</font>
		</h3>
		<table>

			<tr>
				<h3>
					<td><font color="white">Username:-</font></td>
				</h3>
				<td><input type="text" name="username" placeholder="Enter Username"></td>
			</tr>

			<tr>
				<h3>
					<td><font color="white">Password:-</font></td>
				</h3>
				<td><input type="password" name="password" placeholder="Enter password"></td>
			</tr>
		</table>
		<input type="submit" value="Login"> 
		<h3>
			<font color="white"><a href="registerpage">Register Here</a></font>
		</h3>

	</form>
</body>
</html>