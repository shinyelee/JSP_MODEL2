package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.MdViewService;
import vo.ActionForward;
import vo.Md;

// 특정 상품의 상세 정보보기 요청을 처리하는 Action 클래스.
public class MdViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 상품 정보 상세 보기 비즈니스 로직을 처리하는 서비스 객체를 생성.
		MdViewService mdViewService = new MdViewService();
		// 상세 정보를 출력할 대상 상품의 id 값을 파라미터로 받음.
		int id = Integer.parseInt(request.getParameter("id"));
		// 파라미터 값으로 전송된 id 값을 가지고 있는 상품의 정보를 Md 클래스 객체 타입으로 반환받음.
		Md md = mdViewService.getMdView(id);
		// request 영역에 md 객체를 속성으로 공유.
		request.setAttribute("md", md);
		// 상품 정보의 이미지 이름 문자열을 today 문자열 뒤에 해당 상품의 id 값을 연결하여 ("today"+id) 쿠키 이름을 지정한 후 쿠키 객체를 생성하여 저장.
		Cookie todayImageCookie = new Cookie("today"+id, md.getImage());
		// 오늘 본 상품 이미지를 저장한 쿠키 객체가 클라이언트 시스템에 저장되어 있을 기간을 24시간으로 설정.
		todayImageCookie.setMaxAge(60*60*24);
		// 응답에 쿠키 객체를 추가.
		response.addCookie(todayImageCookie);
		// 포워딩 정보를 ActionForward 객체로 생성. 포워딩될 URL은 mdView.jsp로 설정하고 포워딩 방식은 디스패치 방식으로 설정.
		ActionForward forward = new ActionForward("mdView.jsp", false);
		
		return forward;
	}
	
}