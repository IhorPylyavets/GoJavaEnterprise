<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<div class="container">

    <%--<c:choose>
        <c:when test="${position_form['new']}">
            <h1>Add Position</h1>
        </c:when>
        <c:otherwise>
            <h1>Update Position</h1>
        </c:otherwise>
    </c:choose>
    <br />--%>

    <h1>Create / Update Warehouse</h1>
    <br />

    <spring:url value="/warehouses" var="warehouseActionUrl" />

    <form:form class="form-horizontal" method="post" modelAttribute="warehouse_form" action="${warehouseActionUrl}">

        <form:hidden path="id" />

        <spring:bind path="ingredient">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Ingredient</label>
                <div class="col-sm-10">
                    <form:select path="ingredient.ingredientTitle" class="form-control selcls">
                        <form:options items="${ingredientList}" itemValue="ingredientTitle"/>
                    </form:select>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="amount">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Amount</label>
                <div class="col-sm-10">
                    <form:input path="amount" type="number" min="0" class="form-control " id="amount" placeholder="Amount" />
                    <form:errors path="amount" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <%--<div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${position_form['new']}">
                        <button type="submit" class="btn-lg btn-primary pull-right">Add</button>
                    </c:when>
                    <c:otherwise>
                        <button type="submit" class="btn-lg btn-primary pull-right">Update</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>--%>

        <button type="submit" class="btn-lg btn-primary pull-right">Create / Update</button>
    </form:form>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>