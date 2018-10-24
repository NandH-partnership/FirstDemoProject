<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Info</title>
</head>
<body bgcolor="#290066">

<form name="manager">
<h2><font color="white"><center>Manager INFORMATION</center></font></h2>
<h3><font color="white"><center>Hii{manager.username}</center></font></h3>
<table border="1" >
			<tr>
				<th><h4><font color="white">Id</font></h4></th>
				<th><h4><font color="white">First Name</font></h4></th>
				<th><h4><font color="white">Last Name</font></h4></th>
				<th><h4><font color="white">Mobile Number</font></h4></th>
				<th><h4><font color="white">Username</font></h4></th>
				<th><h4><font color="white">Password</font></h4></th>
			</tr>
			<tr>
					<td><h4><font color="white">${manager.id}</font></h4></td>
					<td><h4><font color="white">${manager.firstname}</font></td>
					<td><h4><font color="white">${manager.lastname}</font></h4></td>
					<td><h4><font color="white">${manager.mobilenumber}</font></h4></td>
					<td><h4><font color="white">${manager.username}</font></h4></td>
					<td><h4><font color="white">${manager.password}</font></h4></td>
			</tr>
	</table>
		<input type="button" value="userList" onclick="adminList()">
	<input type="button" value="managerList" onclick="managerList()">
	<input type="button" value="userList" onclick="userList()">

</form>
</body>
</html>