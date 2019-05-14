<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="java.sql.*"
%>
<%
if (request.getSession().getAttribute("user") == null) {
%>
<form class="form-inline my-2 my-lg-0" action="" method="post">
    <input class="form-control mr-sm-2" name="login" type="text" placeholder="Login">
    <input class="form-control mr-sm-2" name="password" type="password" placeholder="Password">
    <button class="btn btn-outline-success my-2 my-sm-0" name="do_login" type="submit">Sign in</button>
</form>
<button class="btn btn-outline-success my-2 my-sm-0" name="do_login" type="submit">
    <a style="color: lime" href="registration">Sign up</a></button>
<%
} else {
%>
<form class="form-inline my-2 my-lg-0" action="" method="post">
    <button class="btn btn-outline-success my-2 my-sm-0" name="do_logout" type="submit">Log out</button>
</form>
<%
    }
%>

