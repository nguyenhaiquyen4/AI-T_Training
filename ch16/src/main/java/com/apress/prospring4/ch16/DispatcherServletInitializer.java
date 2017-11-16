package com.apress.prospring4.ch16;

import com.sun.tools.hat.internal.model.Root;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by noah on 5/6/17.
 */

public class DispatcherServletInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {AppConfig.class, MethodSecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {
                ServletConfig.class };
    }
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

//    @Override
//    public void onStartup(ServletContext container) throws ServletException {
//        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
////        appContext.setConfigLocation("/WEB-INF/spring/appServlet/servlet-context.xml");
//        ServletRegistration.Dynamic dispatcher =
//                container.addServlet("appServlet", new DispatcherServlet(appContext));
//        MultipartConfigElement multipartConfigElement =
//                new MultipartConfigElement(null, 5000000, 5000000, 0);
//        dispatcher.setMultipartConfig(multipartConfigElement);
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
//    }
}
