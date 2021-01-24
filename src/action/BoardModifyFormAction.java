package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

// �� ������ ���� ��û�� ó���ϴ� Action Ŭ����.
public class BoardModifyFormAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		// �Ķ���ͷ� ���۵Ǿ� ���� ���� ����� �Ǵ� ���� ��ȣ�� ����.
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		BoardDetailService boardDetailService = new BoardDetailService();
		// ���� ����� �Ǵ� ���� ������ ��ȯ�ϴ� �޼ҵ� ȣ��. ���������� �ش� ���� ���� ������ ����� �ְ� ���ο� ������ �Է� �޾ƾ� ��.
		BoardBean article = boardDetailService.getArticle(board_num);
		// ���� ����� �Ǵ� ���� ���� ������ request ������ �Ӽ����� ����.
		request.setAttribute("article", article);
		forward.setPath("/board/qna_board_modify.jsp");
		return forward;
		
	}

}