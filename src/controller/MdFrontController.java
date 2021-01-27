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

// ������ url�� *.md�� ������ ��û�� �����ϴ� �������� ����.
// (���� url ��ο� ������� Ȯ���ڰ� �ڿ� .md�� ������ url ��û�� ������ ��û ó���� �ϰڴٴ� ����).
@WebServlet("*.md")
// ��� Ŭ���̾�Ʈ�� ��û�� �޾Ƽ� �����ϴ� ��Ʈ�ѷ� Ŭ����.
public class MdFrontController extends HttpServlet {
	// Ŭ���̾�Ʈ���� ��û�� get ������� ���۵Ǿ� ���ų� post ������� ���۵Ǿ� ���ų� ��� ��û�� ó���ϱ� ���ؼ�
	// doGet �޼ҵ�� doPost �޼ҵ忡�� ���������� doProcess �޼ҵ带 ȣ���ϰ� �ִ�.
	// ��, GoodsFrontController �������� ������ ��� ��û������ doProcess �޼ҵ带 ȣ���ϰ� �ȴ�.
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �Ķ���� ������ �ѱ��� ���۵Ǿ��� �� �ѱ��� ó��.
		request.setCharacterEncoding("UTF-8");
		
		// 1. ���۵� ��û�ľ�
		// ��û URL : http://localhost:8088/boardProject/boardWriteFrom.bo
		// requestURI : /boardProject/boardWriteForm.bo ��ȯ
		String requestURI = request.getRequestURI();
		//   /boardProject ��ȯ
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		System.out.println(command);
		// ��û�� �ľǵǸ� �ش� ��û�� ó���ϴ� �� Action Ŭ���� ��ü�� ����ؼ� ��û�� ó���ϰ� �Ǵµ�
		// �� ��û�� �ش��ϴ� Action Ŭ���� ��ü���� �������� �̿��ؼ� �����ϱ� ���ؼ� Action �������̽� Ÿ���� ������ �����Ͽ���.
		Action action = null;
		// �� Action Ŭ���� ��ü�� execute �޼ҵ带 ȣ���ϸ� ��û�� �ش��ϴ� ����Ͻ� ������ �����ϰ� �������� URL ������ �����̷�Ʈ ��� ������ ��ȯ.
		// �� �������� ���õ� ������ ������ ��ü�� ������ ������ ����.
		ActionForward forward = null;
		
		// 2. �� ��û���� �����Ͻ����� ȣ��
		// �ľǵ� �� ��û(command)�� ���ؼ� �� Action Ŭ���� ��ü�� execute �޼ҵ带 �������� �̿��ؼ� ȣ���Ͽ�
		// ����Ͻ� ������ ó���ϰ� �������� ���õ� ������ ActionForward Ÿ������ ��ȯ����.
		if(command.equals("/mdList.md")) {
			action = new MdListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdView.md")) {
			action = new MdViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdCartAdd.md")) {
			action = new MdCartAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdCartList.md")) {
			action = new MdCartListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdCartSearch.md")) {
			action = new MdCartSearchAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdCartRemove.md")){
			action = new MdCartRemoveAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdCartQtyUp.md")) {
			action = new MdCartQtyUpAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdCartQtyDown.md")) {
			action = new MdCartQtyDownAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdRegist.md")) {
			action = new MdRegistAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdRegistForm.md")) {
			action = new MdRegistFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 3. ������
		// �� Action Ŭ���� ��ü���� ��ȯ�� forward ��ü ������ ����Ͽ� ������ ó��.
		if(forward !=null) {
			// ������ ����� �����̷�Ʈ�� �����Ǿ������� �����̷�Ʈ �������,
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			// ����ġ�� �����Ǿ������� ����ġ �������.
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
				
			}
		}
		
	}
	
}