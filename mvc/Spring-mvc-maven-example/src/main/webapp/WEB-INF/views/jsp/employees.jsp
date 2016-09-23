<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <table style="align-items: center">
            <tr>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Position</th>
            </tr>

            <c:forEach items="${employees}" var="employee">
                <tr>
                    <td><a href="/employee/${employee.name}">${employee.name}</a></td>
                    <td>${employee.surname}</td>
                    <td>${employee.position}</td>
                </tr>
            </c:forEach>

        </table>
    </body>
</html>
