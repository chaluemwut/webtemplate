package com.nsc.webtemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserLoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception arg3)
			throws Exception {
		// System.out.println("After completion handle");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// System.out.println("Post-handle");
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		String path = req.getContextPath();
		// System.out.println("path " + path);
		// System.out.println("Pre-handle " +
		// req.getSession().getAttribute("isUser"));
		if (!req.getRequestURI().equals(path + "/") && !req.getRequestURI().equals(path + "/home/login")
				&& !(req.getRequestURI().indexOf(path + "/resources/app/app-release.apk") != -1)
				&& !(req.getRequestURI().indexOf(path + Config.apiBaseName) != -1)) {
			if (req.getSession().getAttribute("isUser") == null) {
				res.sendRedirect(path + "/");
				return false;
			}
		}
		return true;
	}

}
