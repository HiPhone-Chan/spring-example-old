package com.chf.sample.spring.controller.cloud;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ServiceDiscoveryController.PATH)
public class ServiceDiscoveryController {

	public static final String PATH = "/serviceDiscovery";

	@Autowired
	private DiscoveryClient discoveryClient;

	@Value("${server.port}")
	private String port;

	@RequestMapping(method = RequestMethod.GET)
	public List<?> getServices(@RequestParam(required = false) String serviceName) {
		if (!StringUtils.isEmpty(serviceName)) {
			return discoveryClient.getInstances(serviceName);
		}
		List<URI> uris = new ArrayList<>();
		String uriStr = "http://localhost:" + port + PATH + "?serviceName=";
		for (String service : discoveryClient.getServices()) {
			try {
				URI uri = new URI(uriStr + service);
				uris.add(uri);
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
		return uris;
	}

	@RequestMapping(path = "/local", method = RequestMethod.GET)
	public ServiceInstance getLocalServiceInstance() {
		return discoveryClient.getLocalServiceInstance();
	}
}
