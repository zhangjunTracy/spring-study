package www.springweb.hello.util;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

public class ServletContextUtil implements ServletContextAware {
    private static ServletContext servletContext;

    public static ServletContext getServletContext() {
        return servletContext;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        ServletContextUtil.servletContext = servletContext;
    }

}
