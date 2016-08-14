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

    <h1>All Position</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>#ID</th>
            <th>LastName</th>
            <th>FirstName</th>
            <th>Position</th>
            <th>Action</th>
        </tr>
        </thead>

        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.lastName}</td>
                <td>${employee.firstName}</td>
                <td>${employee.position.positionTitle}</td>
                <td>
                    <spring:url value="/employees/${employee.id}" var="employeeUrl" />
                    <spring:url value="/employees/${employee.id}/delete" var="deleteUrl" />
                    <spring:url value="/employees/${employee.id}/update" var="updateUrl" />

                    <button class="btn btn-info" onclick="location.href='${employeeUrl}'">Query</button>
                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
                    <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button></td>
            </tr>
        </c:forEach>
    </table>

    <spring:url value="/employees/create" var="urlCreateEmployee" />
    <button class="btn btn-toolbar" onclick="location.href='${urlCreateEmployee}'">Create Employee</button>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>