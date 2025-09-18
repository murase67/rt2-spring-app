package jp.co.sss.crud.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.sss.crud.bean.EmployeeBean;


public class LoginCheckFilter extends HttpFilter {
	/**
	 * ユーザのログイン状態の判定を実行します。
	 * 
	 */
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException { 
		String requestURL = request.getRequestURI();

		if (requestURL.indexOf("/html/") != -1 || requestURL.indexOf("/css/") != -1) {
			chain.doFilter(request, response);
			return;
		}

		if (requestURL.endsWith("/") || requestURL.endsWith("/login")) {
			chain.doFilter(request, response);
		} else {
			HttpSession session = request.getSession();
			EmployeeBean loginUser = (EmployeeBean) session.getAttribute("loginUser");

			if (loginUser == null) {
				response.sendRedirect("/spring_crud/");
				return;
			} else {
				chain.doFilter(request, response);
			}
		}
	}
}
