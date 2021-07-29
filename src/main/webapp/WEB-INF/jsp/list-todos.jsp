<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
<div class="container">
    <h1>Hi ${name}</h1>
    <table class="table table-striped">
        <caption> This are your todos </caption>
        <thead>
            <tr>
                <th>Description</th>
                <th>Date</th>
                <th>Is it done?</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.description}</td>
                    <td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
                    <%-- Por convencion de Java Bean para las variables que empiecen con is(booleanos), no se tiene que poner el is--%>
                    <td>${todo.done}</td>
                    <td><a class="btn btn-primary" type="button" href="/update-todo?id=${todo.id}">Edit</a></td>
                    <td><a class="btn btn-danger" type="button" href="/delete-todo?id=${todo.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div><a class="btn btn-success" href="/add-todo"> Add a new Todo </a></div>
</div>
<%@ include file="common/footer.jsp" %>