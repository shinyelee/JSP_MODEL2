package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 로그아웃 요청을 처리하는 서블릿
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public LogoutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그아웃을 요청한 사용자의 세션 객체를 얻어옴.
		HttpSession session = request.getSession();
		// 사용자의 세션 영역을 제거.
		session.invalidate();
		// index.jsp 페이지로 리다이렉트.
		response.sendRedirect("index.jsp");
	}

}
