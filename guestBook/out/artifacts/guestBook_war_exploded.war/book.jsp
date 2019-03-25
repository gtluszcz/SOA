<%@ page import="Logic.Comment" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: gtluszcz
  Date: 2019-03-18
  Time: 00:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
</body>
<h2>Please submit feedback</h2>
<form action="/book" method="post">
    <label for="email">Username</label>
    <input  id="email" name="email" type="text" placeholder="john.smith@gmail.com">
    <br>
    <label for="name">Email</label>
    <input  id="name" name="name" type="text" placeholder="John Smith">
    <br>
    <label for="text">Comment</label>
    <input  id="text" name="text" type="text">
    <br>
    <button  type="submit">Submit Comment</button>
</form>
<%
    if (request == null)
        return;
    for (Comment comment : (ArrayList<Comment>) request.getAttribute("comments")){
        out.println("<hr>" +
                "<p><b> "+ comment.getName() + "</b> ("+ comment.getEmail() + ") says: </p>" +
                "<p>      "+ comment.getText() + "</p>" +
                "");
    }
%>
</body>
</html>
