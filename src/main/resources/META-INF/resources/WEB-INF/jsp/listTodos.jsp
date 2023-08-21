
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

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

<%@ include file="common/footer.jspf" %>