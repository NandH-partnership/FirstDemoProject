<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function addUser() {
	document.manager.action="registerpage";
	document.manager.submit();
	
}
function adminList() {
	
}
function managerList() {
	
}
function userList() {
	
}
</script>
<title>Admin Dashbord</title>
</head>
<body bgcolor="#b30000">

<form name="manager">
<h2><font color="white"><center>Admin INFORMATION</center></font></h2>
<h3><font color="white"><center>Hii{admin.username}</center></font></h3>
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
					<td><h4><font color="white">${admin.id}</font></h4></td>
					<td><h4><font color="white">${admin.firstname}</font></td>
					<td><h4><font color="white">${admin.lastname}</font></h4></td>
					<td><h4><font color="white">${admin.mobilenumber}</font></h4></td>
					<td><h4><font color="white">${admin.username}</font></h4></td>
					<td><h4><font color="white">${admin.password}</font></h4></td>
					
			</tr>
	</table>
		<input type="button" value="Adminlist" onclick="adminList()">
	<input type="button" value="Managerlist" onclick="managerList()">
	<input type="button" value="Userlist" onclick="userList()"><br>
     	<input type="button" value="Add User" onclick="addUser()">

</form>
</body>
</html>