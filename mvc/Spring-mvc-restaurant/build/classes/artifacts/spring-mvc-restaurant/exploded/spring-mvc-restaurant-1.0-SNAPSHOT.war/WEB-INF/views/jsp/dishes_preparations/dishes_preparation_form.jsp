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

    <h1>Create / Update DishesPreparation</h1>
    <br />

    <spring:url value="/dishes_preparations" var="dishes_preparationActionUrl" />

    <form:form class="form-horizontal" method="post" modelAttribute="dishes_preparation_form" action="${dishes_preparationActionUrl}">

        <form:hidden path="id" />

        <spring:bind path="dish">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Dish</label>
                <div class="col-sm-10">
                    <form:select path="dish" class="form-control selcls">
                        <form:option value="NONE" label="--- Select Dish ---" />
                        <form:options items="${dish}" itemValue="id" itemLabel="dishTitle"/>
                    </form:select>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="cook">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Cook</label>
                <div class="col-sm-10">
                    <form:select path="cook" class="form-control selcls">
                        <form:option value="NONE" label="--- Select Cook ---" />
                        <form:options items="${cookList}" itemValue="id" itemLabel="lastName"/>
                    </form:select>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="orderValue">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Order</label>
                <div class="col-sm-10">
                    <form:select path="orderValue" class="form-control selcls">
                        <form:option value="NONE" label="--- Select Order ---" />
                        <form:options items="${orderValuekList}" itemValue="id" itemLabel="id"/>
                    </form:select>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="datePreparation">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">DishesPreparation DATE</label>
                <div class="col-sm-10">
                    <form:input path="datePreparation" type="datetime-local" class="form-control " id="datePreparation"/>
                    <form:errors path="datePreparation" class="control-label" />
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