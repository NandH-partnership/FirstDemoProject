<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#004d00">
	<form action="save">
		<h2>
			<font color="white">Registeration Form</font>
		</h2>
		<!-- <center> -->
		<table background="#009900">

			<tr>
				<td><h4>
						<font color="yellow">Name:-</font></td>
				<td><input type="text" name="firstname"
					placeholder="First Name"></td>
			</tr>
			<tr>
				<td><h4>
						<font color="yellow">Last Name:-</font></td>
				<td><input type="text" name="lastname" placeholder="Last Name"></td>
			</tr>
			<tr>
				<td><h4>
						<font color="yellow">Mobile No:-</font></td>
				<td><input type="text" name="mobilenumber"
					placeholder="Contact Number"></td>
			</tr>

			<tr>
				<td><font color="Yellow">Role:-</font></td>
				<td><select name="roleid">
						<option value="1">Administrator</option>
						<option value="2">Manager</option>
						<option value="3">User</option>

				</select></td>
			</tr>

			<tr>
				<td><h4>
						<font color="yellow">UserName:-</font></td>
				<td><input type="text" name="username"
					placeholder="Enter Username"></td>
			</tr>
			<tr>
				<td><h4>
						<font color="yellow">Password:-</font></td>
				<td><input type="Password" name="password"
					placeholder="Enter password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
		<!-- </center> -->

	</form>
</body>
</html>