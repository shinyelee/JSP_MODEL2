package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

// �� �� ���� ���� ��û�� ó���ϴ� Action Ŭ����.
public class BoardDetailAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		int board_num = Integer.parseInt(request.getParameter("board_num")); // �Ķ���ͷ� ���۵Ǿ� ���� �� ������ �� ���� ��ȣ�� ����.
		String page = request.getParameter("page"); // �Ķ���ͷ� ���۵Ǵ� ������ ��ȣ�� �޴� �κ�.
		BoardDetailService boardDetailService = new BoardDetailService();
		BoardBean article = boardDetailService.getArticle(board_num); // �Ķ���ͷ� ���۵� �� ��ȣ�� ������ �ִ� �� �ϳ��� ������ ��ȯ�ϴ� �޼ҵ� ȣ��.
		ActionForward forward = new ActionForward();
		// ������ ��ȣ�� �� ������ request ������ �Ӽ����� ����.
		request.setAttribute("page", page);
		request.setAttribute("article", article);
		forward.setPath("/board/qna_board_view.jsp");
		return forward;
		
	}

}