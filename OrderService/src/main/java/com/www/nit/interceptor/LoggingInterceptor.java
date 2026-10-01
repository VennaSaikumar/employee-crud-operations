package com.www.nit.interceptor;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoggingInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response,
		Object handler ) throws Exception{
		
		System.out.println("pre handler method :");
		return true;
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		System.out.println("post handle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response,
			Object handler ,Exception ex )throws Exception {
		
		System.out.println("After completion ");
		
		
	}

}
