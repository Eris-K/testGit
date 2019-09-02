<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2019/7/9
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="company.JDBC" %>
<%@ page import="company.login" %>
<html>
<head>
    <title>show</title>
</head>
<body>
<%
        String name = request.getParameter("uname");
        String pwd = request.getParameter("upwd");
        login log = new login(name,pwd);
        JDBC jdbc = new JDBC();
        int rs = jdbc.CheckUsername(log);

        if (rs>0){
            out.print("用户已存在！请重新输入用户名！");
    %>
    <a href="Registration.jsp">返回</a>
    <%
        }else{
           int result = jdbc.Update(log);
           if(result >0){
                out.print("注册成功！");
    %>
                <br/>
                注册信息如下：<br/>
                姓名; <%=name%><br/>
                密码：<%=pwd%><br/>
    <%
            }else if(result==0){
                out.print("用户名已存在！");
            }else{
                out.print("系统错误！");
            }
        }
    %>

</body>
</html>
