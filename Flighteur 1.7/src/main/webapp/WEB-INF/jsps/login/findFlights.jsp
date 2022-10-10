<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Flights</title>
<link rel="stylesheet" type="text/css" href="form.css">
</head>
<body>
	<h2>Find Flights</h2>
	<form action="findFlights" method="post">
		<table>
			<tr>
				<td>From:</td>
				<td><input type="text" name="from" /></td>
			</tr>
			<tr>
				<td>To:</td>
				<td><input type="text" name="to" /></td>
			</tr>
			<tr>
				<td>Departure date:</td>
				<td><input type="text" name="departureDate" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search" /></td>
			</tr>
		</table>
	</form>
</body>
</html>