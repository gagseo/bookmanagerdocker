package common.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	//Controller가 수행되기 전 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//log4j.xml <!-- Root Logger --> 를 info레벨로 수정해줘야 찍힌다.
		logger.info("[interceptor] : preHandle");
		// spring 3.2 이상부터는 servlet-context.xml 에서 <exclude-mapping-path> 를 통해 설정할 수 있다.
		if (request.getRequestURI().contains("book/") && request.getSession().getAttribute("logInInfo") == null) {
		
			request.setAttribute("alertMsg", "로그인 이후 사용 가능한 기능입니다.");
			request.setAttribute("back", "back");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			rd.forward(request, response);
			return false;
		}
		
		return true;
	}

	@Override
	//Controller가 수행되고 View를 호출하기 전
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("[interceptor] : postHandle");

	}

	@Override
	//View호출이 완료된 후
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("[interceptor] : afterCompletion");

	}

}
