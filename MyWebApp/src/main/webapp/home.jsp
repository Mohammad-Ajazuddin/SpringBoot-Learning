<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Simple JSP Template</title>
</head>
<body>

    <h1>Hello, JSP World!</h1>
    <h2>Welcome ${name}</h2>
    <p>here checking welcome "$ {name}"</p>

    <%-- Embedded Java code to get current date and time --%>
    <% java.util.Date currentDate = new java.util.Date(); %>
    <p>Current Date and Time: <%= currentDate %></p>

    <%-- Example of using JSTL for conditional rendering --%>
    <c:if test="${1 == 1}">
        <p>This is a JSTL conditional rendering example.</p>
    </c:if>

    <%-- Example of iterating over a list with JSTL --%>
    <c:forEach var="item" items="${itemsList}">
        <p>${item}</p>
    </c:forEach>

</body>
</html>
