package cn.tedu.store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.tedu.store.bean.User;

public class LoginInterceptor implements HandlerInterceptor{
	
	//在执行控制器方法之前
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//1.获取session对象，从session中取出user
		HttpSession session = request.getSession();
		//2.Object obj ==null；说明没登录过
		Object obj = session.getAttribute("user");
		if(obj==null) {
			//那么跳转到登录页面（重定向）
			String path =
					request.getContextPath()+"/user"+"/showLogin.do";
			response.sendRedirect(path);
			return false;
		}else {
			//3.放行 return true;
			return true;
		}				
	}
	
	//在执行控制器方法之后，但是在响应页面之前
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}
	
	//在响应页面之后
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
	}

}
