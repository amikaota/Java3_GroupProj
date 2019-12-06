<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<title>Admin - Home</title>
</head>
<body>
	<header><jsp:include page="/snippets/header_admin.jsp" /></header>

	<h1>Admin Home Page</h1>
	
	<div class="flex-container">
		<%--<div><jsp:include page="/snippets/showUsers.jsp" /></div>  --%>

		<div class="inputBox">
			<div>
				<div><jsp:include page="/snippets/admin_menu.jsp" /></div>
			</div>
		</div>
	</div>
	<footer><jsp:include page="/snippets/footer.jsp" /></footer>

</body>
</html>