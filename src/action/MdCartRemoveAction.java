package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.MdCartRemoveService;
import vo.ActionForward;

// 장바구니 항목 삭제 요청을 처리하는 Action 클래스.
public class MdCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 동시에 여러 개의 장바구니 항목을 삭제할 수 있기 때문에 삭제할 장바구니 항목의 item 파라미터 값을 배열 형태로 받는다.
		// 본 프로젝트에서는 목록보기 페이지에서 삭제할 장바구니 항목을 체크 박스 형태로 체크하게 처리된다.
		String[] kindArray = request.getParameterValues("remove");
		// 장바구니 항목 삭제 비즈니스 로직을 처리하는 서비스 객체를 생성.
		MdCartRemoveService mdCartRemoveService = new MdCartRemoveService();
		// 장바구니 항목 삭제 요청을 처리하는 메소드를 호출. 세션 영역에 공유되어 있는 장바구니 항목 정보를 삭제해야 하기 때문에 세션에 접근하기 위해서 request 객체를 인자로 던짐.
		mdCartRemoveService.cartRemove(request,kindArray);
		// 장바구니 항목 삭제 요청 처리를 실행한 후 포워딩 정보를 ActionForward 객체로 생성.
		// 장바구니 항목 삭제 처리를 한 후 장바구니 목록보기 요청을 다시 하기 위해서 URL은mdCartList.md로, 포워딩은 리다이렉트 방식으로 처리하기 위해 true로 지정.
		ActionForward forward = new ActionForward("mdCartList.md",true);
		
		return forward;
	}
	
}