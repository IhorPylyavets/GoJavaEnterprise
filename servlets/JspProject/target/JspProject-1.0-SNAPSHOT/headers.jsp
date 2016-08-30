<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>HTTP Header Request Example</title>
</head>
<body>
    <h2>HTTP Header Request Example</h2>
    <table width="100%" border="1" align="center">
        <tr bgcolor="#949494">
            <th>Header Name</th>
            <th>Header Value(s)</th>
        </tr>
        <c:forEach items="${header.keySet()}" var="headerName">
            <tr>
                <td><c:out value="${headerName}"/></td>
                <td><c:out value="${header.get(headerName)}"/></td>
            </tr>
        </c:forEach>
        <%--<%
            Enumeration<String> headersNames = request.getHeaderNames();
            while (headersNames.hasMoreElements()) {
                String headerName = headersNames.nextElement();
                String headerValue = request.getHeader(headerName);
                out.print("<tr><td>" + headerName + "</td>\n");
                out.println("<td>" + headerValue + "</td></tr>\n");
            }
        %>--%>
    </table>
</body>
</html>
