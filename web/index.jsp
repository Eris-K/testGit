<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2019/7/13
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form action="Servlet" method="post">
         用户名：<input type="text"    name="uname"/><br/>
         密  码：<input type="password"    name="upwd"/><br/>
        <input  type="submit"  value="登录" style="width:100px"><br/>
        <a href="Registration.jsp">注册</a>
        <a href="https://www.baidu.com">忘记密码</a>
    </form>
</body>
</html>
