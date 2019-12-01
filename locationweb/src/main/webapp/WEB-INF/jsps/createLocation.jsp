<html>
<body>
<form action="saveLoc" method="post">
    <pre>
    Id: <input type="text" name="id"/>
    Code: <input type="text" name="code"/>
    Name: <input type="text" name="name"/>
    Type:   Urban <input type="radio" name="type" value="urban"/>
            Rural <input type="radio" name="type" value="rural"/>
    <input type="submit" value="Save"/>
    </pre>
</form>
${msg}
<br>
<a href="displayLocations">Show locations</a>
</body>
</html>