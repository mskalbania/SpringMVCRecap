package edu.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        servletContext.setInitParameter("spring.profiles.default", "dev"); //Just for example purposes
        //Active > Default
        //When spring notice active profile variable than default doesn't matter
    }

    //Adding additional beans
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    //Adding servlet related beans
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcWebConfig.class};
    }

    //Mapped dispatcher servlet path
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}