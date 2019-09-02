<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2019/7/17
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Title</title>
    <c:set var="name"   value="zs"   scope="request" />
    ${requestScope.name}<br/>
    ==========给对象的属性赋值=========
    <c:set target="${requestScope.name}"/> <br/>
    ==========给对象的属性赋值=========
    ${requestScope.}
</head>
<body>







</body>
</html>
