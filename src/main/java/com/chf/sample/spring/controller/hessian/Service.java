package com.chf.sample.spring.controller.hessian;

import java.io.InputStream;

public interface Service {

    String sayHello();

    void uploadFile(String filename, InputStream data);

    InputStream downloadFile(String filename);
}
