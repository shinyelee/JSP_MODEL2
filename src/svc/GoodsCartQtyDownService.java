package svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Cart;

// 장바구니 항목 수량 감소 요청을 처리하는 비즈니스 로직을 구현하는 Service 클래스.
public class GoodsCartQtyDownService {

	public void downCartQty(String name, HttpServletRequest request) { 
		HttpSession session = request.getSession(); // 요청을 한 클라이언트의 세션 객체를 얻어옴.
		// 세션 영역에 공유되어 있는 장바구니 목록 객체를 얻어옴.
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		// 수량을 감소시킬 장바구니 항목 객체를 name 값으로 비교해 검색한 후 해당 객체의 수량 값을 감소시킴.
		for (int i = 0; i < cartList.size(); i++) {
			if(cartList.get(i).getName().equals(name)) {
				cartList.get(i).setQty(cartList.get(i).getQty()-1);
			}
			
		}
		
	}
	
}