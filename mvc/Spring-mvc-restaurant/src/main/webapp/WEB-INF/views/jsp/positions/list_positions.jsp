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
					<th>Title</th>
					<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="position" items="${positions}">
				<tr>
					<td>${position.id}</td>
					<td>${position.positionTitle}</td>
					<td>
						<spring:url value="/positions/${position.id}" var="userUrl" />
						<spring:url value="/positions/${position.id}/delete" var="deleteUrl" />
						<spring:url value="/positions/${position.id}/update" var="updateUrl" />

						<button class="btn btn-info" onclick="location.href='${userUrl}'">Query</button>
						<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
						<button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button></td>
				</tr>
			</c:forEach>
		</table>

		<spring:url value="/positions/create" var="urlCreatePosition" />
		<button class="btn btn-toolbar" onclick="location.href='${urlCreatePosition}'">Create Position</button>

	</div>

	<jsp:include page="../fragments/footer.jsp" />

</body>
</html>