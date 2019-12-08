<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h2>Flight details: </h2>
<pre>
    Airlines: ${reservation.flight.operatingAirlines}
    Number: ${reservation.flight.flightNumber}
    Dep City: ${reservation.flight.departureCity}
    Arr City: ${reservation.flight.arrivalCity}
    DOD: ${reservation.flight.dateOfDeparture}
    EDT: ${reservation.flight.estimatedDepartureTime}
</pre>
<br>
<h2> Passenger Details</h2>
<pre>
    FName: ${reservation.passenger.firstName}
    LastName: ${reservation.passenger.lastName}
    Email: ${reservation.passenger.email}
    Phone: ${reservation.passenger.phone}
</pre>
<br>
<form action="completeCheckin" method="post">
    <pre>
    Number of Bags: <input type="number" name="numberOfBags"/>
    <input type="hidden" value="${reservation.id}" name="reservationId">
    <input type="submit">
    </pre>
</form>

</body>
</html>