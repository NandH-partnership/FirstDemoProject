<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
	position: relative;
	background-color: #fefefe;
	margin: auto;
	padding: 0;
	border: 1px solid #888;
	width: 80%;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	-webkit-animation-name: animatetop;
	-webkit-animation-duration: 0.4s;
	animation-name: animatetop;
	animation-duration: 0.4s
}

/* Add Animation */
@
-webkit-keyframes animatetop {
	from {top: -300px;
	opacity: 0
}

to {
	top: 0;
	opacity: 1
}

}
@
keyframes animatetop {
	from {top: -300px;
	opacity: 0
}

to {
	top: 0;
	opacity: 1
}

}

/* The Close Button */
.close {
	color: white;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}

.modal-header {
	padding: 2px 16px;
	background-color: #5cb85c;
	color: white;
}

.modal-body {
	padding: 2px 16px;
}

.modal-footer {
	padding: 2px 16px;
	background-color: #5cb85c;
	color: white;
}
</style>


<script type="text/javascript">
function createXmlHttpRequestObject() {
	var xmlHttp;
	if (window.ActiveXObject) {
		try {
			xmlHttp = new ActiveXObject(Microsoft.XMLHTTP);

		} catch (e) {
			xmlHttp = false;
		}

	} else {
		try {
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			xmlHttp = false;
		}
	}
	if (!xmlHttp)
		alert("cant create xmlHttp object");
	else
		return xmlHttp;
}

	
	
	
	function addUser() {
		document.manager.action = "registerpage";
		document.manager.submit();

	}
	function adminList() {
		
		var xmlHttp = createXmlHttpRequestObject();
		console.log("in admin List");
		var url = "getAdminList";
		xmlHttp.open("GET", url, true);
		xmlHttp.send();
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {

				responseList(xmlHttp);

			}

		}
	
	}
	function managerList() {
		var xmlHttp = createXmlHttpRequestObject();
		console.log("in admin List");
		var url = "getManagerList";
		xmlHttp.open("GET", url, true);
		xmlHttp.send();
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {

				responseList(xmlHttp);

			}

		}

	}
	function userList() {
		var xmlHttp = createXmlHttpRequestObject();
		console.log("in admin List");
		var url = "getUserList";
		xmlHttp.open("GET", url, true);
		xmlHttp.send();
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {

				responseList(xmlHttp);

			}

		}

	}
	
	function edit(id) {
		var xmlHttp = createXmlHttpRequestObject();
	//	alert(id);
		var url= "edit?id=" + id;
		xmlHttp.open("GET", url, true);
		xmlHttp.send();
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				getSingleUser(xmlHttp);
			}

		}
	}
	function getSingleUser(xmlHttp) {
		
		var user = JSON.parse(xmlHttp.responseText);
		document.getElementsByName("id")[0].value=user.id;
	
		document.getElementsByName("firstname")[0].value = user.firstname;
		document.getElementsByName("lastname")[0].value = user.lastname;
		document.getElementsByName("mobilenumber")[0].value = user.mobilenumber;
		document.getElementsByName("username")[0].value = user.credentials.username;
		document.getElementsByName("password")[0].value = user.credentials.password;
		document.getElementsByName("roleid")[0].value = user.role.roleid;
		buttonClick();

	}

	function responseList(xmlHttp) {

		var userList = JSON.parse(xmlHttp.responseText);
		var table = document.getElementById("userDataTable");
		table.innerHTML = "";
		table.style.display = "block";
		var row = table.insertRow();
		var idCell = row.insertCell();
		var firstnameCell = row.insertCell();
		var lastnameCell = row.insertCell();
		var mobilenumberCell = row.insertCell();
		var usernameCell = row.insertCell();
		var passwordCell = row.insertCell();
		var editCell = row.insertCell();
		var deleteCell = row.insertCell();

		idCell.innerHTML = "ID";
		firstnameCell.innerHTML = "Firstname";
		lastnameCell.innerHTML = "Lastname";
		mobilenumberCell.innerHTML = "Mobile Number";
		usernameCell.innerHTML = "Username";
		passwordCell.innerHTML = "Password";
		editCell.innerHTML = "Edit";
		deleteCell.innerHTML = "Delete";

		for ( var key in userList) {
			row = table.insertRow();
			idCell = row.insertCell();
			firstnameCell = row.insertCell();
			lastnameCell = row.insertCell();
			mobilenumberCell = row.insertCell();
			usernameCell = row.insertCell();
			passwordCell = row.insertCell();
			editCell = row.insertCell();
			deleteCell = row.insertCell();

			idCell.innerHTML = userList[key].id;
			firstnameCell.innerHTML = userList[key].firstname;
			lastnameCell.innerHTML = userList[key].lastname;
			mobilenumberCell.innerHTML = userList[key].mobilenumber;
			usernameCell.innerHTML = userList[key].credentials.username;
			passwordCell.innerHTML = userList[key].credentials.password;
			editCell.innerHTML = "<input type='button' value='Edit' id='"
					+ userList[key].id + "' onclick='edit(this.id)'>";
			deleteCell.innerHTML = "<input type='button' value='Delete' id='"
					+ userList[key].id + "' onclick='remove(this.id,"+row.rowIndex+")'>";

		}

	}
	/* code for edit form */

	function update() {
		var modal = document.getElementById('myModal');
		var user=new Object();
		user.id=document.getElementsByName("id")[0].value;
		
		user.firstname=document.getElementsByName("firstname")[0].value;
		user.lastname=document.getElementsByName("lastname")[0].value;
		user.mobilenumber=document.getElementsByName("mobilenumber")[0].value;
		var credentials=new Object();
		credentials.username=document.getElementsByName("username")[0].value;
		credentials.password=document.getElementsByName("password")[0].value; 
		
		user.credentials=credentials;
		var role=new Object();
		role.roleid=document.getElementsByName("roleid")[0].value;
		alert(role.roleid);
		user.role=role;
		console.log("in the buttonClick Function");
		modal.style.display = "none";
		
		Update(user);
		
	}
	function Update(user) {
		var xmlHttp = createXmlHttpRequestObject();
		var json=JSON.stringify(user);
		
		console.log("in Update user");
	 	var url = "update";
	 	
		xmlHttp.open("PUT", url, true);
		xmlHttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
		xmlHttp.send(json);
		
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				
				responseList(xmlHttp);

			}

		} 
	}
	function remove(id,index){
		alert(id);
		alert(index);
		var xmlHttp = createXmlHttpRequestObject();
		var url = "remove?id="+id;
		xmlHttp.open("Get", url, true);
		xmlHttp.send();
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				var i= JSON.parse(xmlHttp.responseText);
				if(i==1){
				 document.getElementById("userDataTable").deleteRow(index);
				}else {
					alert("sf");
				}
			}

		} 
		
	}

	

	// When the manager clicks the button, open the modal 
	function buttonClick() {
		var modal = document.getElementById('myModal');
		modal.style.display = "block";
	}

	// When the user clicks on <span> (x), close the modal
	function spanClick() {
		var modal = document.getElementById('myModal');
		modal.style.display = "none";
	}

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		var modal = document.getElementById('myModal');
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}


	
</script>
<title>Admin Dashbord</title>
</head>
<body bgcolor="#b30000">

	<form name="manager">
		<h2>
			<font color="white"><center>Admin INFORMATION</center></font>
		</h2>
		<h3>
			<font color="white"><center>Hii{admin.username}</center></font>
		</h3>
		<table border="1">
			<tr>
				<th><h4>
						<font color="white">Id</font>
					</h4></th>
				<th><h4>
						<font color="white">First Name</font>
					</h4></th>
				<th><h4>
						<font color="white">Last Name</font>
					</h4></th>
				<th><h4>
						<font color="white">Mobile Number</font>
					</h4></th>
				<th><h4>
						<font color="white">Username</font>
					</h4></th>
				<th><h4>
						<font color="white">Password</font>
					</h4></th>

			</tr>
			<tr>
				<td><h4>
						<font color="white">${admin.id}</font>
					</h4></td>
				<td><h4>
						<font color="white">${admin.firstname}</font>
					</h4></td>
				<td><h4>
						<font color="white">${admin.lastname}</font>
					</h4></td>
				<td><h4>
						<font color="white">${admin.mobilenumber}</font>
					</h4></td>
				<td><h4>
						<font color="white">${admin.credentials.username}</font>
					</h4></td>
				<td><h4>
						<font color="yellow">${admin.credentials.password}</font>
					</h4></td>
			</tr>
		</table>
		<input type="button" value="Adminlist" onclick="adminList(1)">
		<input type="button" value="Managerlist" onclick="managerList(2)">
		<input type="button" value="Userlist" onclick="userList(3)"><br>
		<input type="button" value="Add User" onclick="addUser()">
		<table id="userDataTable"></table>
		
		
		<!-- code for edit form -->



	<!-- The Modal -->
	<div id="myModal" class="modal">

		<!-- Modal content -->
		<div class="modal-content">
			<div class="modal-header">
				<span class="close" onclick="spanClick()">&times;</span>
				<h2>Modal Header</h2>
			</div>
			<div class="modal-body">

				<h2>
					<font color="white">Edit Form</font>
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
						<td><input type="text" name="lastname"
							placeholder="Last Name"></td>
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
								<font color="yellow">UserName:-</font></h4></td>
						<td><input type="text" name="username"
							placeholder="Enter Username"></td>
					</tr>
					<tr>
						<td><h4>
								<font color="yellow">Password:-</font></h4></td>
						<td><input type="Password" name="password"
							placeholder="Enter password"></td>
					</tr>
					<tr>
						<td><input type="button" value="Update" onclick="update()"><input type="hidden" name="id"></td>
					</tr>
				</table>
			</div>
			<div class="modal-footer">
				<h3>Modal Footer</h3>
			</div>
		</div>

	</div>

		
		
	</form>
</body>
</html>