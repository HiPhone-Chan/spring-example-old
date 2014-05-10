package com.chf.sample.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	private final String pointcutValue = "pointcut()";

	private final String exeValue = "execution(* com.chf.sample.spring.controller..*.*(..))";

	@Pointcut(exeValue)
	public void pointcut() {

	}

	@Before(value = pointcutValue)
	public void before() {

	}
}
