<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>Week Number</title>
<body>
	<h1>Week Number</h1>
	<form action="OpsServlet" method="get">
		<input type="hidden" name="op" value="9">
		Date : <input type="text" name="date1">
		<br>
		<input type="submit" value="Get Result">
	</form>
		<br>
	<a href="Ops.jsp"> Home </a>
</body>
</html>