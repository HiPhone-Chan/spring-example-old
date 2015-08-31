package com.chf.sample.spring.config;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.caucho.hessian.client.HessianProxyFactory;
import com.caucho.hessian.server.HessianServlet;
import com.chf.sample.spring.controller.hessian.Service;
import com.chf.sample.spring.controller.hessian.ServiceImpl;

@Configuration
public class HessianConfig {

    @Bean
    public HessianProxyFactory hessianProxyFactory() {
        HessianProxyFactory factory = new HessianProxyFactory();
        return factory;
    }

    @Bean
    public ServletRegistrationBean hessianServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        HessianServlet hessianServlet = new HessianServlet();
        hessianServlet.setHomeAPI(Service.class);
        hessianServlet.setHome(new ServiceImpl());
        hessianServlet.setHomeAPI(Service.class);

        servletRegistrationBean.setServlet(hessianServlet);
        servletRegistrationBean.addUrlMappings("/hessian");
        return servletRegistrationBean;
    }
}
