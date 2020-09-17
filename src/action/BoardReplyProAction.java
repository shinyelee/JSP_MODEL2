/*

package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardReplyProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardReplyProAction implements Action { // 답변글 등록 요청을 처리하는 Action 클래스.
	
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		String nowPage = request.getParameter("page");
		BoardBean article = new BoardBean();
		// 답변글 작성 폼에서 작성한 파라미터 데이터들을 전송받아 BoardBean 객체의 속성 값으로 설정.
		article.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
		article.setBoard_name(request.getParameter("board_name"));
		article.setBoard_pass(request.getParameter("board_subject"));
		article.setBoard_content(request.getParameter("board_content"));
		article.setBoard_re_ref(Integer.parseInt(request.getParameter("board_re_ref")));
		article.setBoard_re_lev(Integer.parseInt(request.getParameter("board_re_lev")));
		article.setBoard_seq(Integer.parseInt(request.getParameter("board_re_seq")));
		// 답변글 등록 작업을 하는 메소드를 호출.
		BoardReplyProService boardReplyProService = new BoardReplyProService();
		boolean isReplySuccess = boardReplyProService.replyArticle(article);
		
		if(isReplySuccess) { // 답변글 등록 작업이 성공했을 때 글 목록 보기를 다시 요청.
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardList.bo?page=" + nowPage);
		}
		else { // 답변글 등록 작업이 실패했을 때 자바스크립트로 경고 창을 출력하고 이전 페이지로 되돌아가게 처리.
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('답장실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;

	}

}

*/