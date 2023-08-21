
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	    <div class="container">

            <h1 class="mt-5">Update Todo</h1>

            <form:form method="post" modelAttribute="todo">
                <fieldset>
                    <div>
                         <form:errors path="description" cssClass="text-danger"/>
                    </div>
                    <div class="mt-2">
                         <label class="form-label me-3" for="description">Description</label>
                         <form:input type="text" path="description" required="required"/>
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
                    <input type="submit" class="btn btn-primary" value="Update Todo">
                </div>
            </form:form>
		</div>

<%@ include file="common/footer.jspf" %>

        <script type=text/javascript>

            $('#targetDate').datepicker({
                format: 'yyyy-mm-dd'
            });

        </script>
