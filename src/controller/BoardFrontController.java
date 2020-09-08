/*

package controller; // ��� Ŭ���̾�Ʈ�� ��û�� �޾Ƽ� �����ϴ� ��Ʈ�ѷ� Ŭ����.

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import action.BoardDeleteProAction;
import action.BoardDetailAction;
import action.BoardListAction;
import action.BoardModifyFormAction;
import action.BoardModifyProAction;
import action.BoardReplyFormAction;
import action.BoardReplyProAction;
import action.BoardWriteProAction;
import vo.ActionForward;

@WebServlet("*.bo") // ������ url�� *.bo�� ������ ��û�� �����ϴ� �������� ����.
public class BoardFrontController extends javax.servlet.http.HttpServlet {
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String RequestURI=request.getRequestURI(); // ���۵�
		String contextPath=request.getContextPath(); // ��û
		String command=RequestURI.substring(contextPath.length()); // �ľ�.
		ActionForward forward=null; // �� Action Ŭ���� ��ü�� execute �޼ҵ带 ������ �� ��ȯ�Ǵ� ActionForward ��ü�� ������ ������ ����.
		Action action=null; // �� ��û�� ó���ϴ� Action Ŭ���� ��ü�� �������� ����ؼ� �����ϴ� ������ ����.
		
		// �� ��û�� �����ϴ� Action Ŭ���� ��ü�� ����.
		// �� Action ��ü�� �����ϸ� forward ������ �� �׼� ��ü���� ��ȯ�� ActionForward ��ü�� ������.
		if(command.equals("/boardWriteForm.bo")) { // �۾��� �������� �����ִ� ��û ���� ����
			forward=new ActionForward(); // Ư���� ����Ͻ� ������ ������ �ʿ� ����
			forward.setPath("/board/qna_board_write.jsp"); // <- �������� �������� �����ϸ� ��.
		} else if(command.equals("/boardWritePro.bo")) {
			action = new BoardWriteProAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardList.bo")) {
			action = new BoardListAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardDetail.bo")) {
			action = new BoardDetailAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardReplyForm.bo")) {
			action = new BoardReplyFormAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardReplyPro.bo")) {
			action = new BoardReplyProAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardModifyForm.bo")) {
			action = new BoardModifyFormAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardModifyPro.bo")) {
			action = new BoardModifyProAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardDeleteForm.bo")) { // �Խ��� �� �ϳ��� ������ �� ���� ���� ��� ���� �������� �ǵ��� ���� �ϱ� ������
			String nowPage = request.getParameter("page"); // �Խ��� ������ ���ؼ� ��й�ȣ�� �Է��ϴ� ������(qna_board_delete.jsp)��
			request.setAttribute("page", nowPage); // <- ������ ��ȣ�� �����Ѵ�.
				int board_num=Integer.parseInt(request.getParameter("board_num"));
				request.setAttribute("board_num", board_num);
				forward=new ActionForward();
				forward.setPath("/board/qna_board_delete.jsp");
		} // �� ������ ��ȣ�� �� �� ������ �� �� ���� ��ư�� ������ �� �Ķ���ͷ� ���۵�.
		else if(command.equals("/boardDeletePro.bo")) {
			action = new BoardDeleteProAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// �� Action Ŭ���� ��ü���� ��ȯ�� ActionForward ��ü ������ ����Ͽ� ������ ó��.
		if(forward != null) {
			
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}

		}
	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
}

*/