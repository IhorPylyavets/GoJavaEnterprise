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

    <h1>Employee Detail</h1>
    <br />

    <div class="row">
        <label class="col-sm-2">ID</label>
        <div class="col-sm-10">${employee.id}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">LAST_NAME</label>
        <div class="col-sm-10">${employee.lastName}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">FIRST_NAME</label>
        <div class="col-sm-10">${employee.firstName}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">BIRTHDAY</label>
        <div class="col-sm-10">${employee.birthday}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">PHONE</label>
        <div class="col-sm-10">${employee.phone}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">POSITION</label>
        <div class="col-sm-10">${employee.position.positionTitle}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">SALARY</label>
        <div class="col-sm-10">${employee.salary}</div>
    </div>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>
