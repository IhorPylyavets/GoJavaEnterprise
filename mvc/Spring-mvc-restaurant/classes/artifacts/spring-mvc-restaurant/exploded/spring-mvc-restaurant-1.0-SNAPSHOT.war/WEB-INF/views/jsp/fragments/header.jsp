<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>Spring MVC Form Handling Example</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/employees" var="urlEmployee" />
<spring:url value="/ingredients" var="urlIngredient" />
<spring:url value="/menus" var="urlMenu" />
<spring:url value="/categories" var="urlCategory" />
<spring:url value="/warehouses" var="urlWarehouse" />
<spring:url value="/dishes" var="urlDish" />
<spring:url value="/desks" var="urlDesk" />
<spring:url value="/orders" var="urlOrder" />
<spring:url value="/dishes_preparations" var="urlDishPreparation" />

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Positions</a>
		</div>
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlEmployee}">Employees</a>
		</div>
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlIngredient}">Ingredients</a>
		</div>
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlMenu}">Menus</a>
		</div>
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlCategory}">Categories</a>
		</div>
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlWarehouse}">Warehouses</a>
		</div>
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlDish}">Dishes</a>
		</div>
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlDesk}">Desks</a>
		</div>
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlOrder}">Orders</a>
		</div>
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlDishPreparation}">DishesPreparations</a>
		</div>
	</div>
</nav>