package com.galaxy.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.galaxy.bean.Account;

public class LoginInterceptor implements HandlerInterceptor {
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Account loginAccount = (Account) request.getSession().getAttribute("loginAccount");
		if (loginAccount == null) {
			request.setAttribute("errorMsg", "ÇëÖØÐÂµÇÂ¼!");
			request.getRequestDispatcher("login.jsp").forward(request, response);;
//			response.sendRedirect("../login.jsp");
			return false;
		} else {
			return true;
		}
	}

}
