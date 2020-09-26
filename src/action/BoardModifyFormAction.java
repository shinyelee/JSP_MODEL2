package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

// 글 수정폼 보기 요청을 처리하는 Action 클래스.
public class BoardModifyFormAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		int board_num = Integer.parseInt(request.getParameter("board_num")); // 파라미터로 전송되어 오는 수정 대상이 되는 글의 번호를 받음.
		BoardDetailService boardDetailService = new BoardDetailService();
		// 수정 대상이 되는 글의 정보를 반환하는 메소드 호출. 수정폼에는 해당 글의 이전 정보를 출력해 주고 새로운 정보를 입력 받아야 함.
		BoardBean article = boardDetailService.getArticle(board_num);
		// 수정 대상이 되는 글의 이전 정보를 request 영역에 속성으로 공유.
		request.setAttribute("article", article);
		forward.setPath("/board/qna_board_modify.jsp");
		return forward;
		
	}

}