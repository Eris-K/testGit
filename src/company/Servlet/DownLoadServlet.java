package company.Servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Base64;

@WebServlet(name = "DownLoadServlet",urlPatterns="/DownLoadServlet")
public class DownLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //获取需要下载的文件名
        String fileName = request.getParameter("filename");
        //下载文件：需设置消息头
        response.addHeader("content-Type","application/octet-stream");

        //对于不同浏览器，进行不同的操作
        //获取客户端的 user-agent信息
//        String agent = request.getHeader("User-Agent");
//        if(agent.toLowerCase().indexOf("firefox")!=-1){
//            response.addHeader("content-Disposition","attachment;filename=?UTF-8?B?"+ new String(fileName.getBytes("UTF-8"))+"?=" );//fileName包括文件后缀
//        }else{
//            //URLEncoder.encode(str,str)处理IE下载 文件名乱码问题
//            response.addHeader("content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));//fileName包括文件后缀
//        }
        
        //Servlet通过文件的地址 将文件转为输入流 读到Servlet中
        InputStream in = getServletContext().getResourceAsStream("/res/MIME.png");
        //通过输出流 将刚才已经转为输入流的文件 输出给用户
        ServletOutputStream out = response.getOutputStream();
        byte[] bs = new byte[10];
        int le = -1;
        while((le = in.read(bs))!= -1){
            out.write(bs,0,le);
        }
        out.close();
        in.close();
    }
}
