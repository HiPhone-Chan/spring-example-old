package com.chf.sample;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chf.sample.spring.config.SpringConfig;

@Configuration
@EnableAutoConfiguration
@Import({ SpringConfig.class })
@RestController
public class Application extends SpringBootServletInitializer {

	private static ApplicationContext ctx;

	private AtomicLong counter = new AtomicLong();

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.setShowBanner(false);
		app.setLogStartupInfo(false);
		ctx = app.run(args);

		List<String> names = Arrays.asList(ctx.getBeanDefinitionNames());
		names.sort((a, b) -> a.compareTo(b));
		names.forEach(name -> System.err.println(name));
	}

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		SpringApplicationBuilder builder = application
				.sources(Application.class);
		ctx = builder.context();
		return builder;
	}

	@RequestMapping("/")
	public String index() {

		return String.format("Start page. %d", counter.incrementAndGet());
	}

	public static Object getBean(String beanName) {
		return ctx.getBean(beanName);
	}
}
