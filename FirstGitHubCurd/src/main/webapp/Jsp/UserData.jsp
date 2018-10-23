<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserInfo</title>
</head>
<body bgcolor="#290066">

<form action="/">
<h2><font color="white"><center>USER INFORMATION</center></font></h2>
<h3><font color="white"><center>Hii{user.username}</center></font></h3>
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
					<td><h4><font color="white">${user.id}</font></h4></td>
					<td><h4><font color="white">${user.firstname}</font></td>
					<td><h4><font color="white">${user.lastname}</font></h4></td>
					<td><h4><font color="white">${user.mobilenumber}</font></h4></td>
					<td><h4><font color="white">${user.username}</font></h4></td>
					<td><h4><font color="white">${user.password}</font></h4></td>
				</tr>
		
		</table>
<input type="submit" value="Logout">
</form>
</body>
</html>