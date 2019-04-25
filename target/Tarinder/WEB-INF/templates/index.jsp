<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <thymeleaf th:replace="header :: header" />
</head>
<body>
<div class="container">
    <div th:replace="action :: action"></div>
    <h2>Customer List</h2>
    <div th:if="${not #lists.isEmpty(customers)}">
        <table class="table table-striped">
            <tr>
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Show</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <tr th:each="user : ${users}">
                <td th:text="${user.id}"></td>
                <td th:text="${user.firstName}"></td>
                <td th:text="${user.gender}"></td>
                <td th:text="${user.}"></td>
                <td th:text="${user.phone}"></td>
                <td><a class="btn btn-success" th:href="@{'/customer/' + ${customer.id}}">View</a></td>
                <td><a class="btn btn-warning" th:href="@{'/customer/' + ${customer.id} + '/edit'}">Edit</a></td>
                <td><a class="btn btn-danger" th:href="@{'/customer/' + ${customer.id} + '/delete'}">Delete</a></td>
            </tr>
        </table>
    </div>
    <div class="col-sm-3">
        <a class="btn btn-primary" th:href="@{/customer/add}">New Customer</a>
    </div>
</div>
</body>
</html>
