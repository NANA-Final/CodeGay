package jishaokang.interceptor;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器
 * 实现用户权限管理和筛除xss攻击
 */
public class LoginInterceptor implements HandlerInterceptor{


	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exc)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception 
	{
		//过滤xss攻击
        Map map = request.getParameterMap();  
        Set<String> keySet = map.keySet();  
        for (String key : keySet) 
        {  
        	String[] values = (String[]) map.get(key);  
        	for (String value : values) 
        	{  
        		if ((value!=null)&&((key.equals("username")||(key.equals("password")))))
        		{
        			String safe = Jsoup.clean(value, Whitelist.basic());;
					if (!value.equals(safe))
        			{
        				request.getRequestDispatcher("user/login").forward(request, response);
        				return false;			
        			}			
        		} 
        	}  
        }
        //权限控制
		String url = request.getRequestURI();
		if((url.indexOf("login")>=0)||(url.indexOf("register")>=0)) return true;
		if((url.indexOf("js")>=0)||(url.indexOf("css")>=0)||(url.indexOf("fonts")>=0)||(url.indexOf("images")>=0)) return true;
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		if((userId != null)&&(userId!=0)) return true;
		request.getRequestDispatcher("user/login").forward(request, response);
		return false;
	}

}

