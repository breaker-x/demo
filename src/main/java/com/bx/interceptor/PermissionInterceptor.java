package com.bx.interceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PermissionInterceptor extends HandlerInterceptorAdapter{
	private final Logger log = LoggerFactory.getLogger(PermissionInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException{
		log.info("开始执行1");
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		
		log.info("requestUri：" + requestUri);
		log.info("contextPath ：" + contextPath);
		log.info("url：" + url);
		String userName = (String) request.getSession().getAttribute("user");
		if(null == userName){
			log.info("Interceptor：跳转到login页面！");
			response.sendRedirect(request.getContextPath() + "/web/login");
			return false;
		}else{
			return true;
		}
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
		log.info("执行开始2");
		if(modelAndView != null){
			modelAndView.addObject("var", "测试postHandle");
		}
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
		log.info("执行顺序3");
	}
}
