package com.chf.sample.spring.controller.hessian;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caucho.services.client.ServiceProxyFactory;

@RestController
public class HessianController {

    public static final String URL = "http://localhost:8080/hessian";

    @Autowired
    public ServiceProxyFactory factory;

    @RequestMapping(value = "/hessianclient", method = GET)
    public String getHessianMessage() throws MalformedURLException {

        Service service = (Service) factory.create(Service.class, URL);
        return service.sayHello();
    }

}
