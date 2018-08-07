package edu.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

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