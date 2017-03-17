package com.group6.b2c.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
 

public class EncodingFilter implements Filter {

	public void init(FilterConfig filterconfig) throws ServletException {
		 
		
	}

	public void doFilter(ServletRequest servletrequest,
			ServletResponse servletresponse, FilterChain filterchain)
			throws IOException, ServletException {
		servletrequest.setCharacterEncoding("UTF-8");
		servletresponse.setCharacterEncoding("UTF-8");		
		filterchain.doFilter(servletrequest, servletresponse);
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

 
}
