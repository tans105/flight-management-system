<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<body>

<pre>
Airline: ${flight.operatingAirlines}
Departure City: ${flight.departureCity}
Arrival City: ${flight.arrivalCity}
</pre>

<br>

<form action="completeReservation" method="post">
<pre>
<h2> Passenger information </h2>
	First Name: <input type="text" name="passengerFirstName">
	Middle Name: <input type="text" name="passengerMiddleName">
	Last Name: <input type="text" name="passengerLastName">
	Email: <input type="text" name="passengerEmail">
	Phone: <input type="text" name="passengerPhone">

<h2> Card details </h2>
	Name on the card: <input type="text" name="nameOnTheCard">
	Card number: <input type="text" name="cardNumber">
	Expiry Date: <input type="text" name="expiryDate">
	CVV: <input type="text" name="securityCode">

<input type="hidden" name="flightId" value="${flight.id}"/>
<input type="submit" value="confirm">
</pre>
</form>
</body>
</html>