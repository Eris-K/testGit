<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2019/7/9
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>check</title>
</head>
<body>
    <%
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("uname");
        String pwd = request.getParameter("upwd");

        //将用户名家加入到cookie
        Cookie cookie = new Cookie("uname", name);
        cookie.setMaxAge(10);
        response.addCookie(cookie);
        response.sendRedirect("result.jsp");
    %>

</body>
</html>
