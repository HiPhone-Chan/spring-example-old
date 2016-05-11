package com.chf.sample.spring.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	// http://localhost:8080/swagger-ui.html

	public static final String DEFAULT_INCLUDE_PATTERN = "/.*";

	@Bean
	public Docket swaggerSpringfoxDocket() {
		StopWatch watch = new StopWatch();
		watch.start();
		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.genericModelSubstitutes(ResponseEntity.class).forCodeGeneration(true)
				.genericModelSubstitutes(ResponseEntity.class)
				.directModelSubstitute(java.time.LocalDate.class, String.class)
				.directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
				.directModelSubstitute(java.time.LocalDateTime.class, Date.class).select()
				.paths(regex(DEFAULT_INCLUDE_PATTERN)).build();
		watch.stop();
		return docket;
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("swagger API", "description", "version 1.0", "http://springfox.io",
				new Contact("Hiphone", "", "hi.phone.chan@gmail.com"), "Apache License Version 2.0",
				"https://github.com/springfox/springfox/blob/master/LICENSE");
	}

}
