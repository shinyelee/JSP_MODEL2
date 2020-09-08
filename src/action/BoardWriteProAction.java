package action; // ���ο� ���� ����ϴ� Action Ŭ����.

import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardWriteProService;
import vo.ActionForward;
import vo.BoardBean;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.Multipart.DefaultFileRenamePolicy;

public class BoardWriteProAction implements Action {
	
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		ActionForward forward=null;
		BoardBean boardBean=null;
		String realFolder=""; // ���� ���� ���� ��θ� ������ ���� ��θ� ������ ������ ����.
		String saveFolder="/boardUpload"; // ������ ���ε��� ���丮���� ����.
		int fileSize=5*1024*1024; // �� ���� ���ε��� ���� ����� ����.
		ServletContext context = request.getServletContext();
		realFolder=context.getRealPath(saveFolder); // �Ķ���ͷ� ������ ���丮�� ���� ���� ���� ��θ� ����.
		
		// MultipartRequest ��ü ����. ���⼭ ���� ���ε� ó��. ���� ����� �� ������ ������ BoardBean ��ü�� ����.
		MultipartRequest multi=new MultipartRequest(request,
				realFolder,
				fileSize,
				"UTF-8",
				new DefaultFileRenamePolicy());
		boardBean = new BoardBean(); // ���� ����� �� �������� BoardBean ��ü�� �Ӽ� ������ �Ҵ�.
		
		// ���ο� ���� ����ϴ� ����Ͻ� ������ ����Ǵ� �޼ҵ� ȣ��.
		boardBean.setBoard_name(multi.getParameter("board_name"));
		boardBean.setBoard_pass(multi.getParameter("board_pass"));
		boardBean.setBoard_subject(multi.getParameter("board_subject"));
		boardBean.setBoard_content(multi.getParameter("board_content"));
		boardBean.setBoard_file(
			multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		BoardWriteProService boardWriteProService = new
		BoardWriteProService();
		boolean isWriteSuccess = boardWriteProService.registArticle(boardBean);
		
		// �� ��� �۾��� �������� ��, '��� ����' ��� â�� ����� �� ���� �������� �ǵ��ư��� ó��.
		if(!isWriteSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('��Ͻ���')");
			out.println("history.back();");
			out.println("</script>");
		}
		// �� ��� ���� �� ��� ���� ��û�� ��.
		else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardList.bo"); // ���� �����ͺ��̽��� ����� �� �ٷ� �� ��� ���� ��û ����.
		}
		
		return forward;

	}
	
}