<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge;" />
    <title>Simple Java ToDo List</title>

    <!-- Bootstrap -->
    <link href="//ajax.aspnetcdn.com/ajax/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">

    <style>
        /* Add padding to body for fixed nav bar */
        body {
            padding-top: 50px;
        }
    </style>
</head>
<body>

<jsp:include page="header.jsp" />
<!-- Body -->
<div class="container">
    <h1>My ToDo List</h1>

    <!-- The ToDo List -->
    <div class = "todoList">
        <form class="form-horizontal" role="form" method="POST" name="taskTable">
            <table class="table table-bordered table-striped" id="list">
                <%--<thead>--%>
                <tr>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Complete</th>
                </tr>
                <c:forEach items="${taskList}" var="task">
                    <tr>
                        <td><c:out value="${task.name}"/></td>
                        <td><c:out value="${task.category}"/></td>
                        <td><input type="checkbox" name="complete" value="${task.id}"
                                   <c:if test="${task.complete == true}">checked="checked"</c:if>
                        /></td>

                    </tr>
                </c:forEach>
                </thead>
                <tbody>
                </tbody>
            </table>
            <div class="todoForm">
                <form class="form-horizontal" role="form" method="POST" action="list">
                    <button href="list.jsp" role="button" class="btn btn-primary" name="updateTasks">Update Tasks</button>
                </form>

            </div>
        </form>
    </div>

    <hr/>

    <!-- Task Input Form -->
    <div class="todoForm">
        <form class="form-horizontal" role="form" method="POST" action="list">
            <div class="form-group">
                <label for="name" class="col-sm-2">Task Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter name">
                </div>
            </div>

            <div class="form-group">
                <label for="category" class="col-sm-2">Task Category</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="category" name="category" placeholder="Enter category">
                </div>
            </div>

            <button href="list.jsp" role="button" class="btn btn-primary" name="addTask">Add Task</button>
        </form>

    </div>

</div>

<!-- Placed at the end of the document so the pages load faster -->
<script src="//ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.1.min.js"></script>
<script src="//ajax.aspnetcdn.com/ajax/bootstrap/3.2.0/bootstrap.min.js"></script>
<script src="assets/todo.js"></script>
</body>
</html>