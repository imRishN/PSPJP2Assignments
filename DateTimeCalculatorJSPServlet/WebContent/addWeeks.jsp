<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>Add Weeks</title>
<body>
	<h1>Add N Weeks</h1>
	<form action="OpsServlet" method="get">
		<input type="hidden" name="op" value="4">
		Date : <input type="text" name="date1">
		<br>
		Days : <input type="text" name="weeks">
		<br>
		<br>
		<input type="submit" value="Get Result">
	</form>
		<br>
	<a href="Ops.jsp"> Home </a>
</body>
</html>