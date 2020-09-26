package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardModifyProService;
import vo.ActionForward;
import vo.BoardBean;

// �� ���� ��û�� ó���ϴ� Action Ŭ����.
public class BoardModifyProAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		boolean isModifySuccess = false;
		int board_num = Integer.parseInt(request.getParameter("BOARD_NUM")); // �� ���� �۾� ���� ���θ� ������ ������ ����.
		BoardBean article = new BoardBean(); // �Ķ���ͷ� ���۵Ǿ� ���� ���� ����� �Ǵ� ���� ��ȣ�� ����.
		BoardModifyProService boardModifyProService = new BoardModifyProService();
		// �Ķ���ͷ� ���۵� ��й�ȣ�� ����ؼ� �� ���� ��û�� �� ����ڰ� ���� �ۼ��� ����������� �Ǵ��� �ִ� �޼ҵ带 ȣ��.
		boolean isRightUser = boardModifyProService.isArticleWriter(board_num, request.getParameter("board_pass"));
		
		// �� ���� ��û�� �� ����ڰ� ���� �ۼ��� ����ڰ� �ƴ� ��� �ڹ� ��ũ��Ʈ�� ��� â�� ����ϰ� ���� �������� �ǵ��ư��� ó��.
		if(!isRightUser) {
			response.setContentType("text/html;charset=UTF=8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('������ ������ �����ϴ�.');");
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
				out.println("alert('���� ����');");
				out.println("history.back();");
				out.println("</script>");
			}
			// �� ���� ��û�� �� ����ڰ� ���� �ۼ��� ������� ��� ���� �۾��� �����ϰ� �� �� ���� ���⸦ �ٽ� ��û.
			else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardDetail.bo?board_num="+article.getBOARD_NUM()); 
			}
			
		}
		
		return forward;
	}
	
}