package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;
import action.Action;
import action.MdCartAddAction;
import action.MdCartListAction;
import action.MdCartQtyDownAction;
import action.MdCartQtyUpAction;
import action.MdCartRemoveAction;
import action.MdCartSearchAction;
import action.MdListAction;
import action.MdRegistAction;
import action.MdRegistFormAction;
import action.MdViewAction;

// 마지막 url이 *.md로 끝나는 요청을 매핑하는 서블릿으로 지정.
// (앞의 url 경로에 상관없이 확장자가 뒤에 .md로 끝나는 url 요청이 들어오면 요청 처리를 하겠다는 설정).
@WebServlet("*.md")
// 모든 클라이언트의 요청을 받아서 제어하는 컨트롤러 클래스.
public class MdFrontController extends HttpServlet {
	// 클라이언트에서 요청이 get 방식으로 전송되어 오거나 post 방식으로 전송되어 오거나 모든 요청을 처리하기 위해서
	// doGet 메소드와 doPost 메소드에서 공통적으로 doProcess 메소드를 호출하고 있다.
	// 즉, GoodsFrontController 서블릿으로 들어오는 모든 요청에서는 doProcess 메소드를 호출하게 된다.
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 값으로 한글이 전송되었을 때 한글을 처리.
		request.setCharacterEncoding("UTF-8");
		
		// 1. 전송된 요청파악
		// 요청 URL : http://localhost:8088/boardProject/boardWriteFrom.bo
		// requestURI : /boardProject/boardWriteForm.bo 반환
		String requestURI = request.getRequestURI();
		//   /boardProject 반환
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		System.out.println(command);
		// 요청이 파악되면 해당 요청을 처리하는 각 Action 클래스 객체를 사용해서 요청을 처리하게 되는데
		// 각 요청에 해당하는 Action 클래스 객체들을 다형성을 이용해서 참조하기 위해서 Action 인터페이스 타입의 변수를 정의하였다.
		Action action = null;
		// 각 Action 클래스 객체의 execute 메소드를 호출하면 요청에 해당하는 비즈니스 로직을 수행하고 포워딩될 URL 정보와 리다이렉트 방식 정보를 반환.
		// 이 포워딩에 관련된 정보를 저장할 객체를 참조할 변수를 선언.
		ActionForward forward = null;
		
		// 2. 각 요청별로 비지니스로직 호출
		// 파악된 각 요청(command)에 대해서 각 Action 클래스 객체의 execute 메소드를 다형성을 이용해서 호출하여
		// 비즈니스 로직을 처리하고 포워딩에 관련된 정보를 ActionForward 타입으로 반환받음.
		if(command.equals("/mdList.md")){
			action = new MdListAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdView.md")){
			action = new MdViewAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdCartAdd.md")){
			action = new MdCartAddAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdCartList.md")){
			action = new MdCartListAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdCartSearch.md")){
			action = new MdCartSearchAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdCartRemove.md")){
			action = new MdCartRemoveAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdCartQtyUp.md")){
			action = new MdCartQtyUpAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdCartQtyDown.md")){
			action = new MdCartQtyDownAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdRegist.md")){
			action = new MdRegistAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdRegistForm.md")){
			action = new MdRegistFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//3. 포워딩
		// 각 Action 클래스 객체에서 반환된 forward 객체 정보를 사용하여 포워딩 처리.
		if(forward !=null){
			// 포워딩 방식이 리다이렉트로 설정되어있으면 리다이렉트 방식으로,
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			// 디스패치로 설정되어있으면 디스패치 방식으로.
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
				
			}
		}
		
	}
	
}