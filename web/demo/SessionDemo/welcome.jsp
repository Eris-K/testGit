<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2019/7/10
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
</head>
<body>
    welcome!
    <%
        String name = (String)session.getAttribute("uname");
        if (name!=null){
            out.print(name);
    %>
        <a href="invalidote.jsp">注销</a>
    <%
        }else{
            response.sendRedirect("");
        }

    %>
</body>
</html>
