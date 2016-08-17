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

    <h1>All Dishes</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>#ID</th>
            <th>Title</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        </thead>

        <c:set var="idCounter" value="1"/>
        <c:forEach var="dish" items="${dishes}">
            <tr>
                <td><c:out value="${idCounter}"/></td>
                <td>${dish.dishTitle}</td>
                <td>${dish.price}</td>
                <td>
                    <spring:url value="/dishes/${dish.id}" var="dishUrl" />
                    <spring:url value="/dishes/${dish.id}/delete" var="deleteUrl" />
                    <spring:url value="/dishes/${dish.id}/update" var="updateUrl" />

                    <button class="btn btn-info" onclick="location.href='${dishUrl}'">Select</button>
                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
                    <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button></td>
            </tr>
            <c:set var="idCounter" value="${idCounter+1}"/>
        </c:forEach>
    </table>

    <spring:url value="/dishes/create" var="urlCreateDish" />
    <button class="btn btn-toolbar" onclick="location.href='${urlCreateDish}'">Create Dish</button>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>