package com.lys.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lys.model.SessionInfo;

/**
 * 权限拦截器
 * 
 * @author 林玉生
 * 
 */
public class SecurityInterceptor implements HandlerInterceptor {
	
	private static final Logger logger = Logger.getLogger(SecurityInterceptor.class);
	
	private static final String[] IGNORE_URI = {"/login","/loginCombobox","/logout","/register","/isUserNameExist"};

	/**
	 * 完成页面的render后调用
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception)throws Exception {

	}
	/**
	 * 在调用controller具体方法后拦截
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {

	}
	/**
	 * 在调用controller具体方法前拦截
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		//跳过不拦截的url
		String url = request.getRequestURL().toString();
		for (String s : IGNORE_URI) {
			if (url.contains(s)) {
				return true;
			}
		}
		//已经登录的用户不拦截
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute("sessionInfo");
		if (sessionInfo != null) {
			return true;
		}
		//用户登录后访问自己的资源不拦截
		
		
		//拦截到登录页面
		response.sendRedirect(request.getContextPath()+"/user/login.jsp");
		return false;
	}

}
