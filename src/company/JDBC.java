package company;

import company.JDBC;
import company.login;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.rmi.Naming;
import java.sql.*;

public class JDBC {
    private static final  String URL = "jdbc:mysql://localhost:3306/dome_01?user=root&useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PWD = "Liang0613";

    public static int CheckUsername(login log){
        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            //导入驱动，加载具体类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //将访问数据库的连接 只想“数据源”
//            try {
//                Context ctx = new InitialContext(); //context.xml
//                DataSource ds = (DataSource) ctx.lookup("java:comp/env/student");
//                con=ds.getConnection();
//            }catch (NamingException e){
//                e.printStackTrace();
//            }
            //建立链接
            connection = DriverManager.getConnection(URL, USERNAME, PWD);
            //发送sql 执行
            String sql = "select * from dome_01.login where username=? ";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,log.getUname());
            rs = pstmt.executeQuery();
            if(rs.next()){
                return 1;
            }else{
                return 0;
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            return -1;
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }finally{
            try{
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if ( connection != null) connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static int Check(login login){
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet result = null;
        try {
            //导入驱动，加载具体类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立链接
            connection = DriverManager.getConnection(URL, USERNAME, PWD);
            //发送sql 执行
            String sql = "select * from dome_01.login where username=? and passward=? ";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(2,login.getUpwd());
            pstmt.setString(1,login.getUname());
            result = pstmt.executeQuery();
            if(result.next()){
                return 1;
            }else{
                return 0;
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            return -1;
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }finally{
            try{
                if (result != null) result.close();
                if (pstmt != null) pstmt.close();
                if ( connection != null) connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static int Update(login log){
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            //导入驱动，加载具体类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立链接
            connection = DriverManager.getConnection(URL, USERNAME, PWD);
            //发送sql 执行

            String sql = "insert into login values (?,?) ";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(2,log.getUpwd());
            pstmt.setString(1,log.getUname());
            //执行sql
            int count = pstmt.executeUpdate();
            if(count>0){
                return 1;
            }else {
                return 0;
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            return -1;
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }finally {
            try {
                // if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if ( connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
//        login login = new login("zs","abc");
//        update(login);
//        checkUsername(login);
    }

}
