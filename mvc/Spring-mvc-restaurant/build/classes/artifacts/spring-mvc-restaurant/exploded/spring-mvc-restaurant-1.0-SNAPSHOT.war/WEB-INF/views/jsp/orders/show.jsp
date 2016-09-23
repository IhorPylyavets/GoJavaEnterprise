<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>Order Detail</h1>
    <br />

    <div class="row">
        <label class="col-sm-2">ID</label>
        <div class="col-sm-10">${order.id}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">WAITER</label>
        <div class="col-sm-10">${order.waiter.firstName} ${order.waiter.lastName}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">DESK</label>
        <div class="col-sm-10">${order.desk.deskTitle}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">DATE</label>
        <div class="col-sm-10">${order.orderDate}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">DISHES</label>
        <div class="col-sm-10">
            [
            <c:forEach items="${order.dishesInOrder}" var="dish" varStatus="stat">
                ${dish.dishTitle}
                <c:if test="${!stat.last}">|</c:if>
            </c:forEach>
            ]
        </div>
    </div>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>
