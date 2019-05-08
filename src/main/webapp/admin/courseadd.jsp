<%--
  Created by IntelliJ IDEA.
  User: ruslan
  Date: 3.3.19
  Time: 19.50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="java.util.*" %>
<%@ page import ="by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.*" %>
<html lang="en">
<head>
    <title>Add course</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<nav class="navbar navbar-expand-md navbar-dark" style="background-color: #000000;">
    <div class="collapse navbar-collapse" id="collapsibleNavId">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-link" href="/Facultative/admin/accounts">Аккаунты<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/Facultative/admin/courses">Курсы<span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="" method="post">
            <button class="btn btn-outline-success my-2 my-sm-0" name="do_logout" type="submit">Выйти</button>
        </form>
    </div>
</nav>

<form method="post" style="margin-top: 20px; margin-left: 30vw; width: 40vw">
    <div class="form-group">
        <label for="fullName">Название курса</label>
        <input type="text" class="form-control" id="fullName" name="name" placeholder="Введите название курса">
    </div>
    <div class="form-group">
        <label for="exampleFormControlTextarea1">Описание курса</label>
        <textarea class="form-control" name="description" id="exampleFormControlTextarea1" rows="3"></textarea>
    </div>
    <div class="form-group">
        <label for="exampleFormControlSelect1">Преподаватель</label>
        <select class="form-control" name="teacher" id="exampleFormControlSelect1">
            <%List<Account> teachers = (List<Account>)request.getAttribute("teachers");
                for (Account teacher : teachers) {
            %>
                <option><%=teacher.getLogin()%></option>
            <%}%>
        </select>
    </div>
    <button type="submit" name="addCourse" class="btn btn-primary">Добавить</button>
</form>

</body>
</html>