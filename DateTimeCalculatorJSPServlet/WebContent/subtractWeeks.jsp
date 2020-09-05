<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>Subtract Weeks</title>
<body>
	<h1>Subtract N Weeks</h1>
	<form action="OpsServlet" method="get">
		<input type="hidden" name="op" value="5">
		Date : <input type="text" name="date1">
		<br>
		Weeks : <input type="text" name="weeks">
		<br>
		<br>
		<input type="submit" value="Get Result">
	</form>
		<br>
	<a href="Ops.jsp"> Home </a>
</body>
</html>