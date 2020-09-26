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
		int board_num = Integer.parseInt(request.getParameter("board_num")); // �亯�� ��� ó���� �� �� ���� ���� �������� �ǵ��� ���� �ϱ� ������ �Ķ���ͷ� ���۵Ǿ���� ������ ��ȣ ���� ����.
		BoardDetailService boardDetailService = new BoardDetailService();
		BoardBean article = boardDetailService.getArticle(board_num); // �亯���� �޾��� ��� ���� ������ ����.
		request.setAttribute("article", article); // �� ������
		request.setAttribute("page", nowPage); // ������ ��ȣ�� request ������ �Ӽ����� ����.
		forward.setPath("/board/qna_board_reply.jsp");
		return forward;

	}
	
}