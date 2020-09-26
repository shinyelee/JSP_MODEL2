package action;

import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardWriteProService;
import vo.ActionForward;
import vo.BoardBean;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

// 새로운 글을 등록하는 Action 클래스.
public class BoardWriteProAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		ActionForward forward=null;
		BoardBean boardBean=null;
		String realFolder=""; // 서버 상의 파일 경로를 저장할 실제 경로를 저장할 변수를 정의.
		String saveFolder="/boardUpload"; // 파일을 업로드할 디렉토리명을 지정.
		int fileSize=5*1024*1024; // 한 번에 업로드할 파일 사이즈를 정의.
		ServletContext context = request.getServletContext();
		realFolder=context.getRealPath(saveFolder); // 파라미터로 지정된 디렉토리의 서버 상의 실제 경로를 얻어옴.
		// MultipartRequest 객체 생성. 여기서 파일 업로드 처리. 새로 등록할 글 정보를 저장할 BoardBean 객체를 생성.
		MultipartRequest multi=new MultipartRequest(request, realFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		boardBean = new BoardBean(); // 새로 등록할 글 정보들을 BoardBean 객체의 속성 값으로 할당.
		// 새로운 글을 등록하는 비즈니스 로직이 실행되는 메소드 호출.
		boardBean.setBOARD_NAME(multi.getParameter("BOARD_NAME"));
		boardBean.setBOARD_PASS(multi.getParameter("BOARD_PASS"));
		boardBean.setBOARD_SUBJECT(multi.getParameter("BOARD_SUBJECT"));
		boardBean.setBOARD_CONTENT(multi.getParameter("BOARD_CONTENT"));
		boardBean.setBOARD_FILE(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		BoardWriteProService boardWriteProService = new BoardWriteProService();
		boolean isWriteSuccess = boardWriteProService.registArticle(boardBean);
		
		// 글 등록 작업이 실패했을 때, '등록 실패' 경고 창을 출력한 후 이전 페이지로 되돌아가게 처리.
		if(!isWriteSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		// 글 등록 성공 후 목록 보기 요청을 함.
		else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardList.bo"); // 글이 데이터베이스에 저장된 후 바로 글 목록 보기 요청 실행.
		}
		
		return forward;

	}
	
}