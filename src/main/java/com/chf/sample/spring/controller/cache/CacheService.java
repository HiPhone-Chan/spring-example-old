package com.chf.sample.spring.controller.cache;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

	private AtomicInteger counter = new AtomicInteger();

	@CachePut(value = "sampleCache1", key = "#key")
	public String update(String key) {
		return "Success";
	}

	@Cacheable(value = "sampleCache1", key = "#key")
	public String getValue(String key) {
		return key + counter.getAndIncrement();
	}
}
