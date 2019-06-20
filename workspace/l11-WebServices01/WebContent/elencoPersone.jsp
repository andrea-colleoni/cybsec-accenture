<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elenco persone</title>
<link rel="stylesheet" href="//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="//cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
</head>
<body>
<table id="myTable" class="display">
	<thead>
	<tr>
		<td>Nome</td>
		<td>Cognome</td>
		<td>E-mail</td>
		<td>Numero di telefono</td>
		<td>Indirizzo</td>
	</tr>
	</thead>
	<tbody>
	<% 
	webservice.PersonaDao dao = new webservice.PersonaDao();
	for (webservice.Persona p : dao.tutti()) { %>
	<tr>
		<td><%= p.nome %></td>
		<td><%= p.cognome %></td>
		<td><%= p.email %></td>
		<td><%= p.numeroTelefono %></td>
		<td><%= p.indirizzo %></td>
	</tr>
	<% } %>
	</tbody>
</table>
<% ObjectMapper om = new ObjectMapper(); %>
<textarea>
	<%= om.writeValueAsString(dao.tutti()) %>
</textarea>
<script>
$(document).ready( function () {
    $('#myTable').DataTable();
} );
</script>
</body>
</html>