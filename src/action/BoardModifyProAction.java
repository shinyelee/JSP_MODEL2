/*

package action; // �� ���� ��û�� ó���ϴ� Action Ŭ����.

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardModifyProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardModifyProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		boolean isModifySuccess = false;
		int board_num = Integer.parseInt(request.getParameter("board_num")); // �� ���� �۾� ���� ���θ� ������ ������ ����.
		BoardBean article = new BoardBean(); // �Ķ���ͷ� ���۵Ǿ� ���� ���� ����� �Ǵ� ���� ��ȣ�� ����.
		BoardModifyProService boardModifyProService = new BoardModifyProService();
		// �Ķ���ͷ� ���۵� ��й�ȣ�� ����ؼ� �� ���� ��û�� �� ����ڰ� ���� �ۼ��� ����������� �Ǵ��� �ִ� �޼ҵ带 ȣ��.
		boolean isRightUser = boardModifyProService.isArticleWriter(board_num, request.getParameter("board_pass"));
		
		if(!isRightUser) { // �� ���� ��û�� �� ����ڰ� ���� �ۼ��� ����ڰ� �ƴ� ��� �ڹ� ��ũ��Ʈ�� ��� â�� ����ϰ� ���� �������� �ǵ��ư��� ó��.
			response.setContentType("text/html;charset=UTF=8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('������ ������ �����ϴ�.');");
			out.println("history.back();");
			out.println("</script>");
		}
		else {
			article.setBoard_num(board_num);
			article.setBoard_subject(request.getParameter("board_subject"));
			article.setBoard_content(request.getParameter("board_content"));
			isModifySuccess = boardModifyProService.modifyArticle(article);
			
			if(!isModifySuccess) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('���� ����');");
				out.println("history.back();");
				out.println("</script>");
			}
			else { // �� ���� ��û�� �� ����ڰ� ���� �ۼ��� ������� ��� ���� �۾��� �����ϰ� �� �� ���� ���⸦ �ٽ� ��û.
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardDetail.bo?board_num="+article.getBoard_num());
			}
			
		}
		
		return forward;
	}
	
}

*/