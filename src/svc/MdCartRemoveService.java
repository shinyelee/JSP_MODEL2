package svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Cart;

// 장바구니 항목 삭제 요청을 처리하는 비즈니스 로직을 구현하는 Service 클래스.
public class MdCartRemoveService {
	
	public void cartRemove(HttpServletRequest request, String[] itemArray) {
		
		// 요청을 한 클라이언트의 세션 객체를 얻어옴.
		HttpSession session = request.getSession();
		// 세션 영역에 공유되어 있는 장바구니 목록 객체를 얻어옴.
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		// 클라이언트가 삭제할 대상으로 선택한 항목의 item 값들을 반복해서 처리.
		for (int i = 0; i < itemArray.length; i++) {
			// 삭제할 항목의 item별로 해당 item 값과 동일한 item 값을 가진 장바구니 항목을 찾아서 삭제 처리.
			for (int j = 0; j < cartList.size(); j++) {
				// 삭제할 item 값과 장바구니 항목의 item 값을 비교.
				if(cartList.get(j).getItem().equals(itemArray[i])){
					// 삭제할  항목을 장바구니 목록에서 제거.
					cartList.remove(cartList.get(j));
				}
				
			}
			
		}
		
	}
}