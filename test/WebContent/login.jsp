<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Login</title>
</head>
<body style="overflow:hidden;">
<header><jsp:include page="/snippets/header.jsp" /></header>
		
		<div class="flex-container">
			<div>
			</div>
			<a href = "admin_home.jsp">skip to admin home page</a>
			<div class="inputBox">
				<h1>Login Page</h1>
				<form action="<%=request.getContextPath()%>/LoginServlet" method="post">
				<p>Login for purchasing items</p>
					<ul>
							<li>
								<label>UserName</label>
								<input type="text" name="uName_" />
							</li>
	
							<li>
								<label>Password</label>
								<input type="password" name="pass_" />
							</li>
	
							
					</ul>
					
					<div>
								<%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%>
					</div>
					<div>
								
								<input class="buttonInput" type="submit" name="submit" value="login" />
									<%
										if ("login".equals(session.getAttribute("login_state"))) {
									%> <input 
									type="submit" name="submit" value="logout" /> <%}%>
								
					</div>
					<p><a href="ItemListServlet">Login as Guest</a></p>
					<p><a href="Registration.html">No Account? Sign Up HERE!</a></p>
	
				</form>
	
			</div>
		</div>	
		<footer><jsp:include page="/snippets/footer.jsp" /></footer>
		
</body>
</html>