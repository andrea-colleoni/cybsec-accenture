<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>Oggi è <%= new java.util.Date() %>.</p>
<p>Hai scritto <%= request.getParameter("testo") %></p>
<% 
	int n = 5;
	if (request.getParameter("numero") != null) {
		try {
			n = Integer.parseInt(request.getParameter("numero"));
			if (n > 100) n = 100;
			n = n + 10;
		} catch (NumberFormatException ex) {
			n = 2;
		}
	}
	// commento
%>
<% for (int i = 0; i < n; i++) { %>
<h2>Ciao (<%= i %>)</h2>
<% } %>
</body>
</html>