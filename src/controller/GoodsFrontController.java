/*

package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;
import action.Action;
import action.GoodsCartAddAction;
import action.GoodsCartListAction;
import action.GoodsCartQtyDownAction;
import action.GoodsCartQtyUpAction;
import action.GoodsCartRemoveAction;
import action.GoodsCartSearchAction;
import action.GoodsListAction;
import action.GoodsRegistAction;
import action.GoodsRegistFormAction;
import action.GoodsViewAction;

// 마지막 url이 *.go로 끝나는 요청을 매핑하는 서블릿으로 지정(앞의 url 경로에 상관없이 확장자가 뒤에 .go로 끝나는 url 요청이 들어오면 요청 처리를 하겠다는 설정).
@WebServlet("*.go")
// 모든 클라이언트의 요청을 받아서 제어하는 컨트롤러 클래스.
public class GoodsFrontController {
	
	// 클라이언트에서 요청이 get 방식으로 전송되어 오거나 post 방식으로 전송되어 오거나 모든 요청을 처리하기 위해서
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	// doGet 메소드와 doPost 메소드에서 공통적으로 doProcess 메소드를 호출하고 있다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	// 즉, GoodsFrontController 서블릿으로 들어오는 모든 요청에서는 doProcess 메소드를 호출하게 된다.

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청파악.
		request.setCharacterEncoding("UTF-8"); // 파라미터 값으로 한글이 전송되었을 때 한글을 처리.
		String RequestURI=request.getRequestURI(); // 전송된
		String contextPath=request.getContextPath(); // 요청
		String command=RequestURI.substring(contextPath.length()); // 파악.
		System.out.println(command);
		// 요청이 파악되면 해당 요청을 처리하는 각 Action 클래스 객체를 사용해서 요청을 처리하게 되는데
		// 각 요청에 해당하는 Action 클래스 객체들을 다형성을 이용해서 참조하기 위해서 Action 인터페이스 타입의 변수를 정의하였다.
		Action action=null;
		// 각 Action 클래스 객체의 execute 메소드를 호출하면 요청에 해당하는 비즈니스 로직을 수행하고 포워딩될 URL 정보와 리다이렉트 방식 정보를 반환.
		// 이 포워딩에 관련된 정보를 저장할 객체를 참조할 변수를 선언.
		ActionForward forward=null;
		
		// 2. 각 요청별로 비즈니스 로직 호출.
		// 파악된 각 요청(command)에 대해서 각 Action 클래스 객체의 execute 메소드를 다형성을 이용해서 호출하여 비즈니스 로직을 처리하고
		// 포워딩에 관련된 정보를 ActionForward 타입으로 반환받음.
		if (command.equals("/goodsList.go")) {
			action = new GoodsListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/goodsView.go")) {
			action = new GoodsViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/goodsCartAdd.go")) {
			action = new GoodsCartAddAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/goodsCartList.go")) {
			action = new GoodsCartListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/goodsCartSearch.go")) {
			action = new GoodsCartSearchAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/goodsCartRemove.go")) {
			action = new GoodsCartRemoveAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/goodsCartQtyUp.go")) {
			action = new GoodsCartQtyUpAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/goodsCartQtyDown.go")) {
			action = new GoodsCartQtyDownAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/goodsRegist.go")) {
			action = new GoodsRegistAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/goodsRegistForm.go")) {
			action = new GoodsRegistFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 3. 포워딩.
		// 각 Action 클래스 객체에서 반환된 forward 객체 정보를 사용하여 포워딩 처리.
		if (forward != null) {
			if (forward.isRedirect()) { // 포워딩 방식이 리다이렉트로 설정되어있으면 리다이렉트 방식으로,
				response.sendRedirect(forward.getPath());
			} else { // 디스패치로 설정되어있으면 디스패치 방식으로 포워딩함.
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}

		}

	}

}

*/