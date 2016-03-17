package com.chf.sample.servlet;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.proxy.ProxyServlet;

public class MyProxyServlet extends ProxyServlet {

	private static final long serialVersionUID = -349757557227694485L;

	private static final String URL = "http://localhost:9090";
	
	protected String rewriteTarget(HttpServletRequest clientRequest) {
		if (!validateDestination(clientRequest.getServerName(), clientRequest.getServerPort()))
			return null;

		StringBuffer target = new StringBuffer(URL);
		target.append(clientRequest.getPathInfo());
		String query = clientRequest.getQueryString();
		if (query != null)
			target.append("?").append(query);
		return target.toString();
	}
}
