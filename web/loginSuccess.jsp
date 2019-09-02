<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2019/7/9
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="company.login" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>success</title>
</head>
<body>
        登录成功!<br/>
        welcome!
        <%
            //调用name
            String name = (String)session.getAttribute("sname");
            out.print(name);
        %>
        <br/>
        <form action="UploadServlet" method="post" enctype="multipart/form-data">
            昵称：<input name="myid"/><br/>
            上传照片<input type="file" name="myphoto"/><br/>
            <input  type="submit"  value="确定" ><br/>
        </form>
        <a href="DownLoadServlet?filename=MINE.png" >MIME</a>
</body>
</html>
