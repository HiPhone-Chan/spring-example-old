package com.chf.sample.spring.controller.hessian;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.tomcat.util.http.fileupload.IOUtils;

public class ServiceImpl implements Service {

    @Override
    public String sayHello() {
        return "hessian hello";
    }

    @Override
    public void uploadFile(String filename, InputStream input) {

        try (OutputStream output = new FileOutputStream(filename);) {
            IOUtils.copy(input, output);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public InputStream downloadFile(String filename) {
        InputStream input = null;
        try {
            input = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return input;
    }

}
