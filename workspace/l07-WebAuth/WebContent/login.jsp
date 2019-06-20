<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
	System.out.println(System.currentTimeMillis() + " - sono passato di qui...");
	double n = Math.log(Math.random());
	boolean loggedIn = false;
	if (session.getAttribute("loggedIn") != null) {
		loggedIn = (boolean)session.getAttribute("logged\"In");
	};
	%>
	<% if (!loggedIn) { %>
	<form method="post" action="auth.jsp">
		User name:<br> 
		<input type="text" name="user" maxlength="5"><br>
		User password:<br> 
		<input type="password" name="pass"> <br>
		<input type="submit" value="Effettua il login!">
	</form>
	<% } else { %>
	<h2>Sei già autenticato! Clicca <a href="logout.jsp">qui</a> per uscire.</h2>
	<% } %>
</body>
</html>
<% 
int pagViste = 0;
session.setAttribute("pagineViste", pagViste); 
%>