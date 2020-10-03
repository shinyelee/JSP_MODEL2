package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;


// 새로운 굿즈 상품 정보 등록 페이지를 보여주는 요청을 처리하는 Action 클래스.
public class GoodsRegistFormAction implements Action {
	
	// 이 클래스 객체는 특별한 비즈니스 로직을 처리할 필요가 없기 때문에 바로 ActionForward 객체를 생성해서 goodsRegistForm.jsp로 포워딩 처리를 한다.
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward("goodsRegistForm.jsp", false);
		return forward;
	}
	
}