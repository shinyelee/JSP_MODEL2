package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

// �亯�� ���� �� ��� ��û�� ó���ϴ� Action Ŭ����.
public class BoardReplyFormAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		String nowPage = request.getParameter("page");
		// �亯�� ��� ó���� �� �� ���� ���� �������� �ǵ��� ���� �ϱ� ������ �Ķ���ͷ� ���۵Ǿ���� ������ ��ȣ ���� ����.
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		BoardDetailService boardDetailService = new BoardDetailService();
		// �亯���� �޾��� ��� ���� ������ ����.
		BoardBean article = boardDetailService.getArticle(board_num);
		// �� ������ ������ ��ȣ�� request ������ �Ӽ����� ����.
		request.setAttribute("article", article);
		request.setAttribute("page", nowPage);
		forward.setPath("/board/qna_board_reply.jsp");
		return forward;

	}
	
}