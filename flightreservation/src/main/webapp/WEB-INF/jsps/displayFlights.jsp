<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<body>
<h1>Find Flights</h1>
<form action="findFlights" method="post">
    From: <input type="text" name="from"/>
    To: <input type="text" name="to"/>
    Departure Date: <input type="text" name="departureDate"/>
    <input type="submit" value="search">
</form>

<table>
    <tr>
        <th>Airlines</th>
        <th>Departure City</th>
        <th>Arrival City</th>
        <th>Departure Time</th>
    </tr>

    <c:forEach items="${flights}" var="flight">
        <tr>
            <td>${flight.operatingAirlines}</td>
            <td>${flight.departureCity}</td>
            <td>${flight.arrivalCity}</td>
            <td>${flight.estimatedDepartureTime}</td>
            <td><a href="showCompleteReservation?flightId=${flight.id}">Select</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>