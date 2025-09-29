package jp.co.sss.crud.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.sss.crud.bean.EmployeeBean;

public class AccountCheckFilter extends HttpFilter {
	
	/**
	 * 登録画面と削除画面のリクエストが行われると権限のチェックを行う
	 * 
	 * 一般ユーザ　　ログイン画面に遷移
	 * 管理者ユーザ　登録入力画面、削除確認画面に遷移
	 *
	 * */
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String requestURL = request.getRequestURI();

		if (requestURL.indexOf("/html/") != -1 || requestURL.indexOf("/css/") != -1 || requestURL.indexOf("/js/") != -1) {
			chain.doFilter(request, response);
			return;
		}

		if (requestURL.endsWith("/regist/input") || requestURL.endsWith("/delete/check")) {
			
			HttpSession session = request.getSession();
			EmployeeBean loginUser = (EmployeeBean) session.getAttribute("loginUser");

			if (loginUser.getAuthority() == 1 || loginUser == null) {
				session.invalidate();
				response.sendRedirect("/spring_crud/");
				return;
			} else {
				chain.doFilter(request, response);
			}
		}else {
			chain.doFilter(request, response);
		}
	}
}
