<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="align-items: center">
    <tr>
        <th>ID</th>
        <th>POSITION_TITLE</th>
    </tr>

    <c:forEach items="${all_positions}" var="positionItem">
        <tr>
            <td>${positionItem.id}</td>
            <td>${positionItem.positionTitle}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>