<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2>Add User Form</h2>
<h2 style="color:red;">${msg}</h2>
<%
	if(request.getSession().getAttribute("msg") != null)
		request.getSession().removeAttribute("msg");
%>
	<p>choose an option</p>

				<form action="CROMServlet" method="post">
					<table>
						<tr>
							<td><input type="radio" name="crom" value="add"
								checked="checked">Add</td>
							<td><input type="radio" name="crom" value="delete">Delete</td>
							<td><input type="radio" name="crom" value="update">Update</td>
							<td><input type="radio" name="crom" value="retrieve">View</td>
						</tr>
						<tr>
							<th>First Name:</th>
							<td><input type="text" name="name"></td>
						</tr>
						<tr>	
							<th>Last Name:</th>
							<td><input type="text" name="lname"></td>
						</tr>
						<tr>
							<th>Password:</th>
							<td><input type="text" name="pass"></td>
						</tr>
						<tr>
							<td><input type="submit" name="sutbmit" value="submit" /></td>
						</tr>
					</table>
					<a href="#" onclick="history.go(-1)">Go Back</a>

				</form>
