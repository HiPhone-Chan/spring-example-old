package com.chf.sample.spring.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDiscoveryClient
@EnableEurekaServer
@EnableConfigServer
@EnableZuulProxy // 默认代理服务的路劲为/${spring。application。name}
public class CloudConfig {

}
