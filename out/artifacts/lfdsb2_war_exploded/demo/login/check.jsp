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
        if(name.equals("zs") && pwd.equals("123")){
           //response.sendRedirect ( "success.jsp" ) ;
            request.getRequestDispatcher("success.jsp").forward(request,response);
        }else{
            out.print("defeat");
        }
    %>

</body>
</html>
