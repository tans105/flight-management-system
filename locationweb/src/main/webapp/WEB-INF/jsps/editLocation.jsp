<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<body>
<form action="updateLoc" method="post">
    <pre>
    Id: <input type="text" name="id" value="${location.id}" readonly/>
    Code: <input type="text" name="code" value="${location.code}"/>
    Name: <input type="text" name="name" value="${location.name}"/>
    Type:   Urban <input type="radio" name="type" value="urban" ${location.type == 'urban'? 'checked':''}/>
            Rural <input type="radio" name="type" value="rural" ${location.type == 'rural'? 'checked':''}/>
    <input type="submit" value="Save"/>
    </pre>
</form>

</body>
</html>