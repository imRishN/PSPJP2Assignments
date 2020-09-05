<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>Day of Week</title>
<body>
	<h1>Day of Week</h1>
	<form action="/dayOfWeek" method="get">
		<input type="hidden" name="op" value="8">
		Date : <input type="text" name="date1">
		<br>
		<input type="submit" value="Get Result">
	</form>
		<br>
	<a href="ops.jsp"> Home </a>
</body>
</html>