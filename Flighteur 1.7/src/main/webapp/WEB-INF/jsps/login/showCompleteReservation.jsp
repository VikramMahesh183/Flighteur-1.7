<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="form.css">
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<link rel="stylesheet" type="text/css" href="showLocation.css">
<body>
	<h2>Flight Details</h2>
	<table id="customers">
		<tr>
			<td>Flight Number: ${flight.flightNumber}</td>
		</tr>
		<tr>
			<td>Operating Airlines: ${flight.operatingAirlines}</td>
		</tr>
		<tr>
			<td>Departure City: ${flight.departureCity}</td>
		</tr>
		<tr>
			<td>Arrival City: ${flight.arrivalCity}</td>
		</tr>
		<tr>
			<td>Departure Date: ${flight.dateOfDeparture}</td>
		</tr>
	</table>

	<h2>Enter Passenger Details</h2>
	<form action="confirmReservation" method="post">
		<table>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" /></td>
			</tr>
			<tr>
				<td>Middle Name</td>
				<td><input type="text" name="middleName" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone" /></td>
			</tr>
			<tr>
				<td><input type="hidden" name="flightId" value="${flight.id}" /></td>
			</tr>
			<tr>
				<td>Name on the card</td>
				<td><input type="text" name="nameOnTheCard" /></td>
			</tr>
			<tr>
				<td>Card number</td>
				<td><input type="text" name="cardNumber" /></td>
			</tr>
			<tr>
				<td>Cvv</td>
				<td><input type="password" name="cvv" /></td>
			</tr>
			<tr>
				<td>Expiry date</td>
				<td><input type="text" name="expiryDate" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Complete Reservation" /></td>
			</tr>
		</table>
	</form>
</body>
</html>