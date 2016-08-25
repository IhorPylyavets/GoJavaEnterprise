<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<body>

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>All Orders</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>#ID</th>
            <th>Waiter</th>
            <th>Desk</th>
            <th>Date</th>
            <th>Action</th>
        </tr>
        </thead>

        <c:set var="idCounter" value="1"/>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td><c:out value="${idCounter}"/></td>
                <td>${order.employee.firstName} ${order.employee.lastName}</td>
                <td>${order.desk.deskTitle}</td>
                <td>${order.orderDate}</td>
                <td>
                    <spring:url value="/orders/${order.id}" var="orderUrl" />
                    <spring:url value="/orders/${order.id}/delete" var="deleteUrl" />
                    <spring:url value="/orders/${order.id}/update" var="updateUrl" />

                    <button class="btn btn-info" onclick="location.href='${orderUrl}'">Select</button>
                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
                    <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button></td>
            </tr>
            <c:set var="idCounter" value="${idCounter+1}"/>
        </c:forEach>
    </table>

    <spring:url value="/orders/create" var="urlCreateOrder" />
    <button class="btn btn-toolbar" onclick="location.href='${urlCreateOrder}'">Create Order</button>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>