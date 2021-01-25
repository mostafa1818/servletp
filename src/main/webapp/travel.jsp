<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html>
<body>
<h2>نتایج جستجو</h2>
<hr>
<br/>

<table border="1">

    <tr>
        <th>Travel Id</th>
        <th>Travel From</th>
        <th>Travel To </th>
        <th>Date</th>
        <th>Time</th>
    </tr>

    <c:forEach var="tempTravel" items="${travelList}">
        <tr>
        <form action="TicketControllerServlet" method="get">
            <td>${tempTravel.travelId}</td>
            <td>${tempTravel.travelFrom}</td>
            <td>${tempTravel.travelTo}</td>
            <td>${tempTravel.date}</td>
            <td>${tempTravel.time}</td>
            <td><button type="submit" value="buy"/>Buy</td>
        </tr>
</table>
    </c:forEach>
            <%
                 session.setAttribute("userN",session.getAttribute("username"));
            %>
        </form>
</body>
</html>
