<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2019/7/10
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        session.invalidate();   //session
        response.sendRedirect("");
        //session.removeAttribute("uname");
    %>
</body>
</html>
