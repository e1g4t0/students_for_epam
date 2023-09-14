<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="Models.Student" %>
<html>
<head>
    <title>Home page</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
</head>

<body>

<a class="btn btn-primary" href="/">Home</a>

<form class="row g-3" action="/" method="get">
    <div class="mb-3">
    <label for="basic-url" class="form-label">Search</label>
    <div class="input-group mb-3">
        <select class="form-select" aria-label="Default select example" name = "key">
            <option value="name">Name</option>
            <option value="surname">Surname</option>
            <option value="student_group">Group</option>
            <option value="admitted_year">Year</option>
        </select>
        <input type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3" name = "value">
        <button class="input-group-text" type="submit">Search</button>
    </div>
    </div>
</form>


<table class="table table-striped">
    <thead>
    <tr>
        <th scope="num">#</th>
        <th scope="name">Name</th>
        <th scope="surname">Surname</th>
        <th scope="group">Group</th>
        <th scope="Year">Admitted Year</th>
        <th scope="act">Action</th>
    </tr>
    </thead>

    <tbody>
    <%
        List<Student> students =
                (List<Student>) request.getAttribute("students");
        for (Student student: students){
    %>

    <tr>
        <th><%= student.getId()%></th>
        <td><%= student.getName()%></td>
        <td><%= student.getSurname()%></td>
        <td><%= student.getGroup()%></td>
        <td><%= student.getYear()%></td>

        <td>
            <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                    data-bs-target="#deleteModal" onclick="setDeleteId(<%= student.getId()%>)">Delete</button>
            <a type="button" class="btn btn-info" data-bs-toggle="modal"
               data-bs-target="#updModal" onclick="setEditData(<%= student.getId()%>)">Edit</a>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>

<button type="button" class="btn btn-success"
        data-bs-toggle="modal" data-bs-target="#addModal" style="
                position: absolute;
                left: 40%;
                width: 15%;
                height: 9%;
                font-size: x-large;">Add a student</button>




<%@include file="modals/deleteModal.jsp"%>
<%@include file="modals/updateModal.jsp"%>
<%@include file="modals/addModal.jsp"%>


<script>
    <%@include file="js/scripts.js"%>
</script>



</body>
</html>