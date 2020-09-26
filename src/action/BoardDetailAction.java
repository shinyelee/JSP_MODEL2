package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

// 글 상세 내용 보기 요청을 처리하는 Action 클래스.
public class BoardDetailAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		int board_num = Integer.parseInt(request.getParameter("board_num")); // 파라미터로 전송되어 오는 상세 내용을 볼 글의 번호를 받음.
		String page = request.getParameter("page"); // 파라미터로 전송되는 페이지 번호를 받는 부분.
		BoardDetailService boardDetailService = new BoardDetailService();
		BoardBean article = boardDetailService.getArticle(board_num); // 파라미터로 전송된 글 번호를 가지고 있는 글 하나의 정보를 반환하는 메소드 호출.
		ActionForward forward = new ActionForward();
		// 페이지 번호와 글 정보를 request 영역에 속성으로 공유.
		request.setAttribute("page", page);
		request.setAttribute("article", article);
		forward.setPath("/board/qna_board_view.jsp");
		return forward;
		
	}

}