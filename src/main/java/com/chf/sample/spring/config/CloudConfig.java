package com.chf.sample.spring.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableDiscoveryClient
@EnableEurekaServer
@EnableZuulProxy // 默认代理服务的路劲为/${spring。application。name}
public class CloudConfig {

}
