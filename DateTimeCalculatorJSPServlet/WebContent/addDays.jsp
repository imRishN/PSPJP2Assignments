<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>Add Days</title>
<body>
	<h1>Add N Days</h1>
	<form action="OpsServlet" method="get">
		<input type="hidden" name="op" value="2">
		Date : <input type="text" name="date1">
		<br>
		Days : <input type="text" name="days">
		<br>
		<br>
		<input type="submit" value="Get Result">
	</form>
		<br>
	<a href="Ops.jsp"> Home </a>
</body>
</html>