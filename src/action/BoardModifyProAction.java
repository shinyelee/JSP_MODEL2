package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardModifyProService;
import vo.ActionForward;
import vo.BoardBean;

// 글 수정 요청을 처리하는 Action 클래스.
public class BoardModifyProAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		boolean isModifySuccess = false;
		int board_num = Integer.parseInt(request.getParameter("BOARD_NUM")); // 글 수정 작업 성공 여부를 저장할 변수를 정의.
		BoardBean article = new BoardBean(); // 파라미터로 전송되어 오는 수정 대상이 되는 글의 번호를 얻어옴.
		BoardModifyProService boardModifyProService = new BoardModifyProService();
		// 파라미터로 전송된 비밀번호를 사용해서 글 수정 요청을 한 사용자가 글을 작성한 사용자인지를 판단해 주는 메소드를 호출.
		boolean isRightUser = boardModifyProService.isArticleWriter(board_num, request.getParameter("board_pass"));
		
		// 글 수정 요청을 한 사용자가 글을 작성한 사용자가 아닐 경우 자바 스크립트로 경고 창을 출력하고 이전 페이지로 되돌아가게 처리.
		if(!isRightUser) {
			response.setContentType("text/html;charset=UTF=8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정할 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		else {
			article.setBOARD_NUM(board_num);
			article.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
			article.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT")); 
			isModifySuccess = boardModifyProService.modifyArticle(article);
			
			if(!isModifySuccess) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정 실패');");
				out.println("history.back();");
				out.println("</script>");
			}
			// 글 수정 요청을 한 사용자가 글을 작성한 사용자인 경우 수정 작업을 실행하고 글 상세 내용 보기를 다시 요청.
			else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardDetail.bo?board_num="+article.getBOARD_NUM()); 
			}
			
		}
		
		return forward;
	}
	
}