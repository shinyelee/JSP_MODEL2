package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.MdCartListService;
import vo.ActionForward;
import vo.Cart;

// 장바구니 목록보기 요청을 처리하는 Action 클래스.
public class MdCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 장바구니 목록보기 비즈니스 로직을 처리하는 서비스 클래스 객체를 생성.
		MdCartListService mdCartListService = new MdCartListService();
		// 전체 장바구니 목록을 ArrayList 타입의 객체로 반환하는 메소드를 호출.
		ArrayList<Cart> cartList = mdCartListService.getCartList(request);
		
		// 지불해야 하는 총 금액을 저장하는 변수를 정의.
		int totalMoney = 0;
		// 장바구니 항목 하나에 대한 지불 금액을 저장하는 변수를 정의.
		int money = 0 ;
		
		// 장바구니 항목 목록에 존재하는 전체 상품을 구매하는 데 필요한 총 금액을 계산.
		for (int i = 0; i < cartList.size(); i++) {
			// 장바구니 항목 하나당의 금액을 계산.
			money = cartList.get(i).getPrice()*cartList.get(i).getQty();
			// 각 장바구니 항목의 금액을 총 금액에 더하면서 전체 장바구니 항목의 상품을 구매하기 위해 필요한 총 금액을 계산.
			totalMoney += money;
		}

		// 총 금액을 request 영역에 속성으로 공유.
		request.setAttribute("totalMoney", totalMoney);
		// 전체 장바구니 목록을 request 영역에 속성으로 공유.
		request.setAttribute("cartList", cartList);
		// 포워딩 정보를 ActionForward 객체로 생성. 포워딩될 URL은 goodsCartList.jsp로 설정하고 포워딩 방식은 디스패치 방식으로 처리하기 위해 false로 지정.
		ActionForward forward = new ActionForward("mdCartList.jsp", false);
		
		return forward;
	}

}