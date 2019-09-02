<%@ page import="java.sql.*" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.util.Scanner" %><%--
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
        String URL = "jdbc:mysql://localhost:3306/dome_01?user=root&useSSL=false&serverTimezone=UTC";
        String USERNAME = "root";
        String PWD = "Liang0613";

        Connection connection = null;
        //Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            //导入驱动类，加载具体的驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //与数据库建立连接
            connection = DriverManager.getConnection(URL,USERNAME,PWD);

            //statement
//            stmt = connection.createStatement();
//            String name = request.getParameter("uname");
//            String pwd = request.getParameter("upwd");
//            String sql = "select count(*) from dome_01.dome.login ";
//            rs = stmt.executeQuery(sql);  //返回值表示增删改了几条数据

            //prepareStatement
//            String name = request.getParameter("uname");
//            String pwd = request.getParameter("upwd");
//            String sql = "select count(*) from dome_01.dome.login ";
            //增删改
            String sql = "insert into login values(?,?,?)";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,2);
            pstmt.setString(2,"jt");
            pstmt.setString(3,"321");

            int count = pstmt.executeUpdate();

            //处理结果
            if(rs.next()){
                count = rs.getInt(1);
            }if (count > 0){
                out.println("登录成功！");
            }else{
                out.println("登录失败！");
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                if(rs!=null)  rs.close();
                if(stmt!=null)   stmt.close();
                if(connection !=null)  connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    %>

</body>
</html>
