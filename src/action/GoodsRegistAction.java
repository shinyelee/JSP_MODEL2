package action;

import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.GoodsRegistService;
import vo.ActionForward;
import vo.Goods;
import com.oreilly.servlet.MultipartRequest; // 파일 업로드 처리를 위해 cos.jar 라이브러리에서 제공되는 업로드관련 클래스를 임포트.
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy; // 해당 라이브러리를 프로젝트에 추가해야 한다.

public class GoodsRegistAction implements Action {
	
	// 새로운 개 상품 정보를 등록하는 Action 클래스.
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 파일을 서버 상에 업로드 한 후 업로드된 파일의 정보를 데이터베이스에 저장하는 비즈니스 로직이 구현되는 Service 클래스 객체를 생성.
		GoodsRegistService GoodsRegistService = new GoodsRegistService();
		String realFolder = ""; // 파일이 업로드될 서버 상의 실제 경로를 저장할 변수를 정의.
		String saveFolder = "/images"; // 파일이 업로드될 디렉토리 이름을 정의.
		String encType = "UTF-8"; // 업로드되는 파일의 인코딩 타입을 정의.
		int maxSize = 5 * 1024 * 1024; // 한 번의 요청에 의해서 업로드될 수 있는 바이트 수를 정의(최대 5MB로 지정).
		
		ServletContext context = request.getServletContext(); // 파일이 업로드될 서버상의 물리적인 경로를 얻어옴.
		realFolder = context.getRealPath(saveFolder); // 즉, 웹 애플리케이션 루트의 image 디렉토리의 물리적인 경로를 얻어옴.
		// MultipartRequest 클래스의 생성자를 사용해서 요청에 전송되어온 파일을 서버 상에 업로드.
		// 생성자를 사용해서 객체를 생성하는 순간 바로 서버 상에 파일이 업로드된다.
		// DefaultFileRenamePolicy 클래스 객체는 클라이언트가 업로드하는 파일 이름과 동일한 이름의 파일이 이미 서버 상의 업로드 디렉토리에 존재할 때
		// 업로드되는 파일 이름을 자동으로 변경하여 업로드되게 하는 기능을 제공.
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		String image = multi.getFilesystemName("image"); // 서버 상에 업로드된 파일 이름을 얻어옴.
		// 클라이언트에서 전송된 파라미터 데이터들을 사용해서 새로 등록될 굿즈 정보를 저장하는 Goods 객체를 생성.
		Goods goods = new Goods(0, multi.getParameter("name"), Integer.parseInt(multi.getParameter("price")), image,
					  multi.getParameter("category"), multi.getParameter("category2"),
					  Integer.parseInt(multi.getParameter("version")), multi.getParameter("content"), 0);
		boolean isRegistSuccess = GoodsRegistService.registGoods(goods); // 굿즈 상품 등록 비즈니스 로직을 처리하는 registGoods 메소드를 호출.
		ActionForward forward = null; // 최종적으로 메서드에서 반환해야되는 ActionForward 객체의 클래스 변수를 정의.
		
		// 굿즈 상품 등록 작업이 성공적으로 처리되었을때 리다이렉트 방식으로 굿즈 목록보기 요청을 하도록 함.
		// 여기서 생성해서 반환하는 forward 객체가 GoodsFrontController 서블릿의 forward = action.execute(request, response); 부분으로 반환되어
		// 해당 정보를 사용하여 포워딩 처리된다.
		if (isRegistSuccess) {
			forward = new ActionForward("goodsList.go", true);
		// 굿즈 상품 등록 작업이 실패되었을 경우 자바스크립트를 사용해서 "등록 실패" 문자열을 경고창으로 띄우고 이전 URL, 즉 굿즈 상품 등록 페이지로 되돌아가게 처리.
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("history.back();");
			out.println("</script>");
		}

		return forward;
		
	}

}