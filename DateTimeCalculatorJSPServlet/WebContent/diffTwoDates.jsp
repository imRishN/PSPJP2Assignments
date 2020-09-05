<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
  
<html>
<title>Period Between Two Dates</title>
<body>
	<h1>Period</h1>
	
	<form action="OpsServlet" method="get">
		<input type="hidden" name="op" value="1">
		Date 1: <input type="text" name="date1">
		<br>
		Date 2: <input type="text" name="date2">
		<br>
		<input type="submit" value="Get Result">
	</form>
		<br>
	<a href="Ops.jsp"> Home </a>
</body>
</html>