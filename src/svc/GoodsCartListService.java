package svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Cart;

public class GoodsCartListService {
	
	public ArrayList<Cart> getCartList(HttpServletRequest request) {
		// 요청한 클라이언트의 세션 영역 객체를 얻어옴.
		HttpSession session = request.getSession();
		// 세션 영역에 공유되어 있는 장바구니 목록 객체를 얻어옴.
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		return cartList;
	}
	
}