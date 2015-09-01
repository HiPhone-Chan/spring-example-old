package com.chf.sample.spring.controller.hessian;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caucho.services.client.ServiceProxyFactory;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

@RestController
@RequestMapping(value = "/hessian")
public class HessianController {

    public static final String URL = "http://localhost:8080/hessian";

    @Autowired
    public ServiceProxyFactory factory;

    @RequestMapping(value = "/hello", method = GET)
    public String getHessianMessage() throws MalformedURLException {

        Service service = (Service) factory.create(Service.class, URL);
        return service.sayHello();
    }

    @RequestMapping(value = "/upload", method = GET)
    public String upload() throws MalformedURLException, FileNotFoundException {

        Service service = (Service) factory.create(Service.class, URL);

        String str = "/text";
        service.uploadFile("test.txt",
                new ByteInputStream(str.getBytes(), str.length()));
        return "upload success";
    }

    @RequestMapping(value = "/download", method = GET)
    public String download(HttpServletResponse response)
            throws MalformedURLException, FileNotFoundException {

        Service service = (Service) factory.create(Service.class, URL);

        String filename = "tmp.txt";
        InputStream input = service.downloadFile("test.txt");

        response.setContentType("text/plain");
        response.setHeader("Location", filename);
        response.setHeader("Content-Disposition", "attachment; filename="
                + filename);

        // OutputStream output = new FileOutputStream("tmp.txt");
        try (OutputStream output = response.getOutputStream()) {
            IOUtils.copy(input, output);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "download success";
    }

}
