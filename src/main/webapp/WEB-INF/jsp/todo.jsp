<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
<div class="container">
    <h1>Hi ${name}, add a new Todo!</h1>
    <form:form method="POST" modelAttribute="todo">
        <form:hidden path="id"/>
        <fieldset class="form-group">
            <form:label path="description">Description</form:label>
            <%-- Required fuerza una validacion del lado del cliente --%>
            <form:input path="description" name="description" type="text" class="form-control" required="required"/>
            <form:errors path="description" cssClass="text-warning"></form:errors>
        </fieldset>
        <fieldset class="form-group">
                        <form:label path="targetDate">Target Date</form:label>
                        <%-- Required fuerza una validacion del lado del cliente --%>
                        <form:input path="targetDate" name="targetDate" type="text" class="form-control" required="required"/>
                        <form:errors path="targetDate" cssClass="text-warning"></form:errors>
                    </fieldset>
        <button type="submit" class="btn btn-success">Add</button>
    </form:form>
</div>
<%@ include file="common/footer.jsp" %>