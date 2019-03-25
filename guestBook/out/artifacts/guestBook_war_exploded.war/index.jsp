<%--
  Created by IntelliJ IDEA.
  User: gtluszcz
  Date: 2019-03-17
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/login" method="post">
      <label for="username">
        Username
      </label>
      <input  id="username" name="username" type="text" placeholder="Username">
      <label for="password">
        Password
      </label>
      <input  id="password" name="password" type="password" placeholder="******************">
      <%
        if (request != null){
            Object error = request.getAttribute("error");
            if (error != null){
                out.println("<p> "+ error + "</p>");
            }
        }
      %>
      <button  type="submit">
        Sign In
      </button>

  </form>

  </body>
</html>
