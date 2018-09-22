<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Welcome</title>
</head>
<body>
<h1>Welcome</h1>
<h2>${weatherList}</h2>
<c:forEach var="weather" items="${weatherList}">
    <p>${weather.nameCity}</p>
</c:forEach>
</body>

</html>
