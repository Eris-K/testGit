<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2019/7/9
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
        登录成功!<br/>
        welcome!
        <%
            String name = request.getParameter("uname");
            out.print(name);
        %>
</body>
</html>
