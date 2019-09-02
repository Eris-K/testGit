package company.Servlet;

import company.JDBC;
import company.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet",urlPatterns="/Servlet",loadOnStartup=1)
public class Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理登录
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("uname");
        //将name保存至本次会话有效，可在其他页面随意调用
        request.getSession().setAttribute("sname",name);
        String pwd = request.getParameter("upwd");
        login log = new login(name,pwd);//用户名、密码
        int result = JDBC.Check(log);
        if (result > 0){
            response.sendRedirect("loginSuccess.jsp");
        }
        else if(result==0){
            request.getRequestDispatcher("LoginFailure.jsp").forward(request,response);
        }else{
            System.out.print("系统错误！");
        }
    }

}
