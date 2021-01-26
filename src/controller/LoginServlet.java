// 로그인 요청을 처리하는 서블릿 페이지
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import svc.LoginService;
import vo.Member;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트에서 "id"라는 이름으로 전송된 파라미터 값을 얻어옴.
		String id = request.getParameter("id");
		// 클라이언트에서 "passwd"라는 이름으로 전송된 파라미터 값을 옫어옴.
		String passwd = request.getParameter("passwd");
		// 로그인 비즈니스 로직을 처리하는 LoginService 클래스 객체를 생성.
		LoginService loginService = new LoginService();
		// 로그인에 성공한 사용자의 정보를 얻어오는 getLoginMember 메소드를 호출.
		// getLoginMember 메소드는 로그인에 성공하면 사용자의 정보를 Member 객체에 담아서 반환하고 로그인에 실패하면 null을 반환한다.
		Member loginMember = loginService.getLoginMember(id,passwd);
		
		// 로그인이 성공했을 경우 세션 영역에 "id"라는 이름으로 로그인에 성공한 아이디 값을 속성으로 공유.
		if(loginMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			// index.jsp 페이지로 리다이렉트.
			response.sendRedirect("index.jsp");
		}
		// 로그인 실패시 자바스크립트를 사용해 경고창 출력. 경고창에서 확인 버튼 누르면 이전 페이지인 loginForm.html로 되돌아가게 처리.
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인에 실패했습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

}