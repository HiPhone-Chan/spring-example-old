package com.chf.sample.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.chf.sample.domain",
		"com.chf.sample.spring" })
@EnableScheduling
@ImportResource("classpath:spring-application.xml")
@PropertySource("classpath:myApplication.properties")
public class SpringConfig {

}
