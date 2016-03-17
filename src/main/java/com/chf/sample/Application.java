package com.chf.sample;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chf.sample.spring.config.SpringConfig;

@Configuration
@EnableAutoConfiguration
@Import({ SpringConfig.class })
public class Application extends SpringBootServletInitializer {

	private static ApplicationContext ctx;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.setLogStartupInfo(false);
		ctx = app.run(args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		SpringApplicationBuilder builder = application.sources(Application.class);
		ctx = builder.context();
		return builder;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "redirect:/swagger-ui.html";
	}

	public static Object getBean(String beanName) {
		return ctx.getBean(beanName);
	}
}
