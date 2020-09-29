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

// ������ url�� *.go�� ������ ��û�� �����ϴ� �������� ����(���� url ��ο� ������� Ȯ���ڰ� �ڿ� .go�� ������ url ��û�� ������ ��û ó���� �ϰڴٴ� ����).
@WebServlet("*.go")
// ��� Ŭ���̾�Ʈ�� ��û�� �޾Ƽ� �����ϴ� ��Ʈ�ѷ� Ŭ����.
public class GoodsFrontController {
	
	// Ŭ���̾�Ʈ���� ��û�� get ������� ���۵Ǿ� ���ų� post ������� ���۵Ǿ� ���ų� ��� ��û�� ó���ϱ� ���ؼ�
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	// doGet �޼ҵ�� doPost �޼ҵ忡�� ���������� doProcess �޼ҵ带 ȣ���ϰ� �ִ�.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	// ��, GoodsFrontController �������� ������ ��� ��û������ doProcess �޼ҵ带 ȣ���ϰ� �ȴ�.

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. ��û�ľ�.
		request.setCharacterEncoding("UTF-8"); // �Ķ���� ������ �ѱ��� ���۵Ǿ��� �� �ѱ��� ó��.
		String RequestURI=request.getRequestURI(); // ���۵�
		String contextPath=request.getContextPath(); // ��û
		String command=RequestURI.substring(contextPath.length()); // �ľ�.
		System.out.println(command);
		// ��û�� �ľǵǸ� �ش� ��û�� ó���ϴ� �� Action Ŭ���� ��ü�� ����ؼ� ��û�� ó���ϰ� �Ǵµ�
		// �� ��û�� �ش��ϴ� Action Ŭ���� ��ü���� �������� �̿��ؼ� �����ϱ� ���ؼ� Action �������̽� Ÿ���� ������ �����Ͽ���.
		Action action=null;
		// �� Action Ŭ���� ��ü�� execute �޼ҵ带 ȣ���ϸ� ��û�� �ش��ϴ� ����Ͻ� ������ �����ϰ� �������� URL ������ �����̷�Ʈ ��� ������ ��ȯ.
		// �� �������� ���õ� ������ ������ ��ü�� ������ ������ ����.
		ActionForward forward=null;
		
		// 2. �� ��û���� ����Ͻ� ���� ȣ��.
		// �ľǵ� �� ��û(command)�� ���ؼ� �� Action Ŭ���� ��ü�� execute �޼ҵ带 �������� �̿��ؼ� ȣ���Ͽ� ����Ͻ� ������ ó���ϰ�
		// �������� ���õ� ������ ActionForward Ÿ������ ��ȯ����.
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

		// 3. ������.
		// �� Action Ŭ���� ��ü���� ��ȯ�� forward ��ü ������ ����Ͽ� ������ ó��.
		if (forward != null) {
			if (forward.isRedirect()) { // ������ ����� �����̷�Ʈ�� �����Ǿ������� �����̷�Ʈ �������,
				response.sendRedirect(forward.getPath());
			} else { // ����ġ�� �����Ǿ������� ����ġ ������� ��������.
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}

		}

	}

}

*/