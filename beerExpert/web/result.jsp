<%--
  Created by IntelliJ IDEA.
  User: gtluszcz
  Date: 2019-03-17
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <P>Your beer is <% out.print(request.getAttribute("beer")); %></P>
</body>
</html>
