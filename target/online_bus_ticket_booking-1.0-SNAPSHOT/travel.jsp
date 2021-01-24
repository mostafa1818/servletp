<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html>
<body>
<h2>نتایج جستجو</h2>
<hr>
<br/>

<table border="1">

    <tr>
        <th>Travel From</th>
        <th>Travel To </th>
        <th>Date</th>
    </tr>

    <c:forEach var="tempTravel" items="${travelList}">

        <tr>
            <td>${tempTravel.travelFrom}</td>
            <td>${tempTravel.travelTo}</td>
            <td>${tempTravel.date}</td>
            <td>${tempTravel.time}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
