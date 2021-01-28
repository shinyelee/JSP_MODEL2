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
	
	// 사용자가 "loginForm.html" 페이지에서 아이디와 비밀번호를 입력하고 로그인 요청을 한 것이 아니고 index.jsp 페이지를 실행한 후 <jsp:forward/> 액션 태그에 의해 요청이 들어감
	// -> GET 방식으로 넘어오기 때문에 doGet 메소드가 실행됨.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 클라이언트에서 전송된 쿠키 객체들을 얻어옴.
		// request.getCookies() 메소드는 클라이언트에서 전송된 쿠키 객체들을 배열로 반환.
		Cookie[] cookieArray = request.getCookies();
		String id = "";
		String passwd = "";

		// 쿠키 배열이 null인지 아닌지를 체크.
		// 클라이언트에서 쿠키 객체가 하나라도 넘어왔으면 쿠키 배열은 null이 아님.
		if(cookieArray != null) {
			
			// 클라이언트에서 전송된 쿠키 객체들의 이름을 하나씩 비교하면서 아이디가 저장된 쿠키 객체와 비밀번호가 저장된 쿠키 객체를 찾아서
			// 아이디와 비밀번호 값을 얻어와서 id 변수와 passwd 변수에 할당.
			for (int i = 0; i < cookieArray.length; i++) {
				// 쿠키 배열에 저장된 각 쿠키 객체의 이름이 "id"인지를 비교.
				// 클라이언트에 저장되는 쿠키 정보의 형태는 "cookieName=cookieValue;각종옵션들"이다.
				// 즉, 각 쿠키 객체들은 쿠키 이름으로 구분된다.
				if(cookieArray[i].getName().equals("id")) {
					// 쿠키 이름이 "id"인 쿠키의 값을 id 변수에 할당.
					id = cookieArray[i].getValue();
				}
				// 쿠키 이름이 "passwd"인지를 판단.
				else if(cookieArray[i].getName().equals("passwd")) {
					// 쿠키 이름이 "passwd"인 쿠키 객체의 값을 얻어와서 passwd 변수에 할당.
					passwd = cookieArray[i].getValue();
				}
			}
			
			// 로그인 비즈니스 로직이 구현돼 있는 LoginService 객체를 생성.
			LoginService loginService = new LoginService();
			// LoginService 클래스에 정의돼 있는 getLoginMember 메소드를 호출해 로그인에 성공한 사용자의 정보를 Member 객체 타입으로 얻어옴.
			Member loginMember = loginService.getLoginMember(id,passwd);
			
			// 로그인에 성공하면 사용자의 정보를 Member 객체의 속성 값으로 설정해 반환함.
			if(loginMember != null) {
				// 사용자 시스템의 쿠키 정보에 로그인에 성공한 아이디와 비밀번호가 저장돼 있음
				// -> request 영역에 로그인에 성공한 사용자의 정보를 Member 객체 타입으로 공유하고 "loginSuccess.jsp" 페이지로 포워딩함.
				RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
				request.setAttribute("loginMember", loginMember);
				dispatcher.forward(request, response);
			}
			// 로그인에 실패하면 null 값을 반환.
			else {
				// 사용자 시스템에 로그인 정보가 없음 -> 다시 로그인 화면으로 돌려보냄.
				RequestDispatcher dispatcher = request.getRequestDispatcher("loginForm.html");
				dispatcher.forward(request, response);
			}
		}
    }

	// 사용자가 "loginForm.html" 페이지에서 아이디와 비밀번호를 입력하고 로그인 요청을 함
	// -> 요청이 POST 방식으로 전송되기 때문에 doPost 메소드가 실행됨.
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