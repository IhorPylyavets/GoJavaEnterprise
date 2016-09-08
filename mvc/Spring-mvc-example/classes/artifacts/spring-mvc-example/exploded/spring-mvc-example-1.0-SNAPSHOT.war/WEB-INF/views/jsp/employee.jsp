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
                <th>PhoneNumber</th>
                <th>Salary</th>
            </tr>

            <tr>
                <td>${employee.name}</td>
                <td>${employee.surname}</td>
                <td>${employee.position}</td>
                <td>${employee.phoneNumber}</td>
                <td>${employee.salary}</td>
            </tr>

        </table>
    </body>
</html>
