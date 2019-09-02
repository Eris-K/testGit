package company.MyFilter;


import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

    @Override   //服务器启动时执行一次
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override   //服务器关闭时执行一次
    public void destroy() {

    }
}
