<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2019/7/12
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="company.JDBCDome" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String name = request.getParameter("uname");
        String pwd = request.getParameter("upwd");
        JDBCDome jdbcDome = new JDBCDome();
        int result = jdbcDome.update(name,pwd);
        if(result >0){
            out.print("登录成功！");
    %>
    <a href="Servlet">Welcome</a><br/>
    <form action="Servlet" method="post">
        <input type="submit" value="欢迎">
    </form>
    <%
        }else if(result==0){
            out.print("用户名或密码有误！");
        }else{
            out.print("系统错误！");
        }
    %>

</body>
</html>
