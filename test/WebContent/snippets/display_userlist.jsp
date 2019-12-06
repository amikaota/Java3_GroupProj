<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import ="java.util.*" %>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="com.Bean.User" %>
    
    

	<div>
			<table border="1">
				<thead>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Password</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.users}" var="current">
						<tr>
							<td><c:out value="${current.uid}" /></td>
							<td><c:out value="${current.fname}" /></td>
							<td><c:out value="${current.lname}" /></td>
							<td><c:out value="${current.pass}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>


		</div>

