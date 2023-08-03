<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	    <link href="webjars\bootstrap\5.3.0\css\bootstrap.min.css" rel="Stylesheet">
		<title> List Todos Page - JSP</title>
	</head>
	<body>
	    <div class="container">
            <div class="mt-3">
                <h3>Welcome ${username}</h3>
            </div>
            <hr>
            <h1>Your Todos</h1>

            <table class="table">
                <thead>
                    <tr>
                        <th>Todo Description</th>
                        <th>Todo Target Date</th>
                        <th>Task Completed</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todoList}" var="todo">
                        <tr>
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.done}</td>
                            <td>
                                <a href="update-todo?id=${todo.id}" class="btn btn-success me-2">Update</a>
                                <a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                <tbody>
            </table>
            <div>
                <a href="add-todo" class="btn btn-primary">Add Todo</a>
            </div>
		</div>


        <script src"webjars\bootstrap\5.3.0\js\bootstrap.min.js"></script>
        <script src"C:webjars\jquery\3.6.4\jquery.min.js"></script>
	</body>
</html>