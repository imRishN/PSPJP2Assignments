<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>Subtract Months</title>
<body>
	<h1>Subtract N Months</h1>
	<form action="OpsServlet" method="get">
		<input type="hidden" name="op" value="7">
		Date : <input type="text" name="date1">
		<br>
		Months : <input type="text" name="months">
		<br>
		<br>
		<input type="submit" value="Get Result">
	</form>
		<br>
	<a href="Ops.jsp"> Home </a>
</body>
</html>