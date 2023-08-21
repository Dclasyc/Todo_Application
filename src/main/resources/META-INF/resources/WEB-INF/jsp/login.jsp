<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

	   <div class="container">
            <div class="mt-3">
                <h4>Welcome</h4>
            </div>
            <div>
                <h3 style="color:red;">
                    ${errorMessage}
                </h3>
            </div>
            <form action="" method="post">
            <div>
                <div class="mt-3">
                    <label class="form-label" for="username">Username</label>
                    <input name="username" placeholder="username" id="username">
                </div>

                <div class="mt-3">
                    <label class="form-label" for="password">Password</label>
                    <input type="password" name="password" placeholder="password" id="password">
                </div>
            </div>

            <div class="mt-3">
                <button type= submit class="btn btn-primary">Submit</button>
            </div>

            </form>
	   </div>

<%@ include file="common/footer.jspf" %>