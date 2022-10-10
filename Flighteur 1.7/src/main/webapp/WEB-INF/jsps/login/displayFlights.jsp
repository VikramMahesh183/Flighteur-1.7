<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Flights</title>
</head>
<link rel="stylesheet" type="text/css" href="showLocation.css">
<body>
	<h2>Flight Search Results</h2>
	<h2>List Of Flights</h2>
	<table id="customers">
		<tr>
		<tr>
			<th>Airlines</th>
			<th>Departure City</th>
			<th>Arrival City</th>
			<th>Departure Time</th>
			<th>Select Flight</th>
		</tr>
		<c:forEach items="${findFlights}" var="findFlights">
			<tr>
				<td>${findFlights.operatingAirlines}</td>
				<td>${findFlights.departureCity}</td>
				<td>${findFlights.arrivalCity}</td>
				<td>${findFlights.estimatedDepartureTime}</td>
				<td><a href="showCompleteReservation?flightId=${findFlights.id}">Select</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>