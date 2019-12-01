<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<body>
<h1>Locations</h1>
<table style="border: 1px solid black">
    <tr>
        <th>Id</th>
        <th>Code</th>
        <th>Name</th>
        <th>Type</th>
    </tr>
    <c:forEach items="${locations}" var="location">
        <tr>
            <td>${location.id}</td>
            <td>${location.code}</td>
            <td>${location.name}</td>
            <td>${location.type}</td>
            <td><a href="deleteLocation?id=${location.id}">Delete</a></td>
            <td><a href="updateLocation?id=${location.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<a href="showCreate">Add Record</a>
</body>
</html>