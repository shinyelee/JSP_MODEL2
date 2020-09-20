package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardDeleteProService;
import vo.ActionForward;

// �� ���� ��û�� ó���ϴ� Action Ŭ����.
public class BoardDeleteProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		int board_num = Integer.parseInt(request.getParameter("board_num")); // �Ķ���ͷ� ���۵Ǿ� ���� ���� ����� �Ǵ� ���� ��ȣ�� ����.
		String nowPage = request.getParameter("page"); // �� ���� ��û�� ó���� �� ���� ���� ������ ������� ���ư��� ���ؼ� ������ ��ȣ�� ����.
		BoardDeleteProService boardDeleteProService = new BoardDeleteProService();
		// ���� ��û�� �� ����ڰ� ���� �ۼ��� ����������� �Ǵ�.
		boolean isArticleWriter = boardDeleteProService.isArticleWriter(board_num, request.getParameter("board_pass"));
		
		// ���� ��û�� �� ����ڰ� ���� �ۼ��� ����ڰ� �ƴ� ��� ��� â�� ����ϰ� ���� �������� �ǵ��ư��� ó��.
		if(!isArticleWriter) {
			response.setContentType("text/html;charset=UTF=8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('������ ������ �����ϴ�.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		// ���ڰ����� ������ �� ��ȣ�� ������ �ִ� ���� �����ϴ� ����� �ϴ� �޼ҵ带 ȣ��.
		else {
			boolean isDeleteSuccess = boardDeleteProService.removeArticle(board_num);
			
			// ���� �۾��� ������ ��� �ڹ� ��ũ��Ʈ�� ��� â�� ����ϰ� ���� �������� �ǵ��ư��� ó��.
			if(!isDeleteSuccess) {
				response.setContentType("text/html;charset=UTF=8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('��������');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}
			// ���� �۾��� ������ ��� �� ��� ���⸦ �ٽ� ��û. ������ ���� �������� �ٽ� ���ư��� �ϱ� ���ؼ� page ���� �Ķ���ͷ� ����.
			else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardList.bo?page="+nowPage);
			}
			
		}
		return forward;
	}
	
}