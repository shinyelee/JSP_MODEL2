/*

package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardDeleteProService;
import vo.ActionForward;

public class BoardDeleteProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		int board_num = Integer.parseInt(request.getParameter("board_num")); // 파라미터로 전송되어 오는 삭제 대상이 되는 글의 번호를 얻어옴.
		String nowPage = request.getParameter("page"); // 글 삭제 요청을 처리한 후 원래 보던 페이지 목록으로 돌아가기 위해서 페이지 번호를 얻어옴.
		BoardDeleteProService boardDeleteProService = new BoardDeleteProService();
		// 삭제 요청을 한 사용자가 글을 작성한 사용자인지를 판단.
		boolean isArticleWriter = boardDeleteProService.isArticleWriter(board_num, request.getParameter("board_pass"));
		
		if(!isArticleWriter) { // 삭제 요청을 한 사용자가 글을 작성한 사용자가 아닐 경우 경고 창을 출력하고 이전 페이지로 되돌아가게 처리.
			response.setContentType("text/html;charset=UTF=8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제할 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		else { // 인자값으로 지정한 글 번호를 가지고 있는 글을 삭제하는 기능을 하는 메소드를 호출.
			boolean isDeleteSuccess = boardDeleteProService.removeArticle(board_num);
			
			if(!isDeleteSuccess) { // 삭제 작업이 실패한 경우 자바 스크립트로 경고 창을 출력하고 이전 페이지로 되돌아가게 처리.
				response.setContentType("text/html;charset=UTF=8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제실패');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}
			else { // 삭제 작업이 성공한 경우 글 목록 보기를 다시 요청. 이전에 보던 페이지로 다시 돌아가게 하기 위해서 page 값을 파라미터로 전송.
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardList.bo?page="+nowPage);
			}
			
		}
		return forward;
	}
	
}

*/