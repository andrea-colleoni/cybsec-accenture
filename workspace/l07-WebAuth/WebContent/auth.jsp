<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Benvenuto</title>
</head>
<body>
<h1>Eccomi sono AUTH!!</h1>

<% 
boolean loggedIn = false;
if (session.getAttribute("loggedIn") != null) {
	loggedIn = (boolean)session.getAttribute("loggedIn");
};
if (!loggedIn && request.getParameter("user") != null
		&& request.getParameter("pass") != null && request.getParameter("pass").equals("pasticcio")) { %>
<h2>Benvenuto <%= request.getParameter("user") %>!</h2>
<% 
	session.setAttribute("nomeUtente", request.getParameter("user"));
	session.setAttribute("loggedIn", true);
	javax.servlet.http.Cookie c = new javax.servlet.http.Cookie("potere", "user");
	response.addCookie(c);
} else if(loggedIn) { %>
<h2>Bentornato <%= session.getAttribute("nomeUtente") %>!</h2>
<% } else { %>
<h2>Hai sbagliato qualcosa.</h2>
<% } %>
<h2>Torna alla pagina di <a href="login.jsp">login</a>, oppure effettua direttamente il
<a href="logout.jsp">logout</a>.</h2>
</body>
</html>