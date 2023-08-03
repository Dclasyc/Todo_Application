<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
	    <link href="webjars\bootstrap\5.3.0\css\bootstrap.min.css" rel="Stylesheet">
	    <link href="webjars\bootstrap-datepicker\1.9.0\css\bootstrap-datepicker.standalone.min.css" rel="Stylesheet"/>
		<title> Add Todo Page </title>
	</head>
	<body>
	    <div class="container">

            <h1 class="mt-5">Add A New Todo</h1>

            <form:form method="post" modelAttribute="todo">
                <fieldset>
                    <div>
                         <form:errors path="description" cssClass="text-danger"/>
                    </div>
                    <div class="mt-2">
                         <label class="form-label me-3" for="description">Description</label>
                         <form:input type="text" placeholder="Description" path="description" required="required"/>
                    </div>
                </fieldset>

                <fieldset>
                     <div class="mt-2">
                          <label class="form-label me-3" for="targetDate">Target Date</label>
                          <form:input type="text" path="targetDate" required="required"/>
                     </div>
                </fieldset>

                <div>
                    <form:input type="hidden" name="id" path="id" />
                    <form:input type="hidden" name="done" path="done" />
                </div>

                <div class="mt-3">
                    <input type="submit" class="btn btn-primary" value="Add Todo">
                </div>
            </form:form>
		</div>


        <script src="webjars\bootstrap\5.3.0\js\bootstrap.min.js"></script>
        <script src="webjars\jquery\3.6.4\jquery.min.js"></script>
        <script src="webjars\bootstrap-datepicker\1.9.0\js\bootstrap-datepicker.min.js"></script>


        <script type=text/javascript>
             $('#targetDate').datepicker({
             format: 'yyyy-mm-dd'
             });
        </script>
	</body>
</html>
