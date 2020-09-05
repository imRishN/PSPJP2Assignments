<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>Date Time Calculator</title>
<body>
	<h1>Date Time Calculator</h1>
	
	<h2>Select Option</h2>

	<form action="OpsServlet" method="get">
	
		<a href="diffTwoDates.jsp">1. Difference Between Two Dates</a> 
		<br>
		<a href="addDays.jsp">2. Add N Days</a>	
		<br>
		<a href="subtractDays.jsp">3. Subtract N Days</a>
		<br>
		<a href="addWeeks.jsp">4. Add N Weeks</a>	 
		<br>
		<a href="subtractWeeks.jsp">5. Subtract N Weeks</a>
		<br>
		<a href="addMonths.jsp">6. Add N Months</a>	
		<br>
		<a href="subtractMonths.jsp">7. Subtract N Months</a>
		<br>
		<a href="dayOfWeek.jsp">8. Get Day of Week</a>
		<br>
		<a href="getWeekNumber.jsp">9. Get Week Number</a> 
	</form>
</body>
</html>