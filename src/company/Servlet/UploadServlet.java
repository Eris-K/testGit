package company.Servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "UploadServlet",urlPatterns="/UploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        //上传
        try{
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {    //判断前台的form是否有mutipart属性
       //         FileItemFactory factory = new DiskFileItemFactory() ;
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            factory.setSizeThreshold(2048000);
            //设置临时文件的目录
            factory.setRepository(new File("E:\\code\\lfdsb2\\web\\uploadtemp"));
            //控制上传单个文件的大小
            upload.setSizeMax(4096000); //字节 B

            //通过parseRequest解析form中的所有请求字段，并保存到items集合中
            List<FileItem> items = upload.parseRequest(request);
            //遍历items中的数据
            Iterator<FileItem> iterator = items.iterator();
            while (iterator.hasNext()) {
                FileItem item = iterator.next();
                //获得普通表单字段的Name
                    String itemName = item.getFieldName();
                    String myid = null;
                    //判断前台字段是普通 form表单字段(myid), 还是文件字段(myphoto)
                    if (item.isFormField()){
                        if (itemName.equals("myid")){
                            myid = item.getString("UTF-8");
                        }else{
                            System.out.println("其他字段...");
                        }
                    }else {//文件 上传
                        //获得文件名
                        String fileName = item.getName();
                        String ext = fileName.substring(fileName.indexOf(".")+1);
                        if (!((ext.equals("png"))||(ext.equals("gif"))||(ext.equals("jpg")))){
                            System.out.println("照片格式有误！");
                            return ;
                        }
                        //上传,定义文件路径
                        //获取服务器路径 E:\\code\\lfdsb2\\Upload ;
                          String p = "E:\\code\\lfdsb2\\web\\upload";
                        File file = new File(p,fileName);
                        //设置上传时用到的临时文件大小factory

                        item.write(file);
                        System.out.println(fileName+"上传成功！");

                        return ;
                    }
                }
            }
        }catch (FileUploadBase.SizeLimitExceededException e){
            e.printStackTrace();
        }catch (FileUploadException e){
            e.printStackTrace();//请求解析
        }catch (Exception e) {
            e.printStackTrace();
        }finally {

            }
    }

}


