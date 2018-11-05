package com.cloud.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

/**
 * 通过过滤器，过滤所有的请求为同一次请求
 * @author wangqi
 *
 */
@WebFilter(urlPatterns = "/*", filterName = "hystrixfilter")
public class MyFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HystrixRequestContext contxt = HystrixRequestContext.initializeContext();
		try {
			arg2.doFilter(arg0, arg1);
		} catch (Exception e) {
			
		} finally {
			contxt.shutdown();
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
