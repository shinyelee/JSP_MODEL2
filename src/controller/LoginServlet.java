package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import svc.LoginService;
import vo.Member;

// 로그인 요청을 처리하는 서블릿 페이지
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Cookie[] cookieArray = request.getCookies();
		String id = "";
		String passwd = "";

		if(cookieArray != null) {
			
			for (int i = 0; i < cookieArray.length; i++) {
				if(cookieArray[i].getName().equals("id")) {
					id = cookieArray[i].getValue();
				}
				else if(cookieArray[i].getName().equals("passwd")) {
					passwd = cookieArray[i].getValue();
				}
			}

			LoginService loginService = new LoginService();
			Member loginMember = loginService.getLoginMember(id,passwd);

			if(loginMember != null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
				request.setAttribute("loginMember", loginMember);
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("loginForm.html");
				dispatcher.forward(request, response);
			}
		}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트에서 "id"라는 이름으로 전송된 파라미터 값을 얻어옴.
		String id = request.getParameter("id");
		// 클라이언트에서 "passwd"라는 이름으로 전송된 파라미터 값을 옫어옴.
		String passwd = request.getParameter("passwd");
		String useCookie = request.getParameter("useCookie");
		// 로그인 비즈니스 로직을 처리하는 LoginService 클래스 객체를 생성.
		LoginService loginService = new LoginService();
		// 로그인에 성공한 사용자의 정보를 얻어오는 getLoginMember 메소드를 호출.
		// getLoginMember 메소드는 로그인에 성공하면 사용자의 정보를 Member 객체에 담아서 반환하고 로그인에 실패하면 null을 반환한다.
		Member loginMember = loginService.getLoginMember(id,passwd);
		
		if(useCookie != null) {

			Cookie idCookie = new Cookie("id", id);
			// 쿠키를 생성하면 기본 생존기간이 -1이다. 브라우저가 실행중일 때는 쿠키가 생존하지만 브라우저를 닫으면 쿠키가 사라짐.
			idCookie.setMaxAge(60 * 60 * 24); // 단위는 초. 60*60*24=24시간.
			Cookie passwdCookie = new Cookie("passwd", passwd);
			passwdCookie.setMaxAge(60 * 60 * 24);
			// 응답에 쿠키 추가.
			response.addCookie(idCookie);
			response.addCookie(passwdCookie);
		}
		
		// 로그인 성공.
		if(loginMember != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
			request.setAttribute("loginMember", loginMember);
			dispatcher.forward(request, response);		
//			HttpSession session = request.getSession();
//			session.setAttribute("id", id);
//			// index.jsp 페이지로 리다이렉트.
//			response.sendRedirect("index.jsp");
		}
		// 로그인 실패.
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginFail.jsp");
			dispatcher.forward(request, response);
//			response.setContentType("text/html;charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>");
//			out.println("alert('로그인에 실패했습니다.')");
//			out.println("history.back()");
//			out.println("</script>");
		}
	}

}