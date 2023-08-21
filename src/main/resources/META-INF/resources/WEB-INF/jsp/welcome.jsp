<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

        <div class="container">
            <div class="mt-3">
                <h2>Welcome Page</h2>
            </div>
            <div>
                <p>Your Username is ${username}</p>
            </div>

            <div>
                <p><a href =list-todos>Manage</a> your Todos</p>
            </div>
        </div>

<%@ include file="common/footer.jspf" %>