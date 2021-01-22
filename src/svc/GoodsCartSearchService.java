package svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Cart;

// 장바구니 항목 검색 요청을 처리하는 비즈니스 로직을 구현하는 Service 클래스.
public class GoodsCartSearchService {

	public ArrayList<Cart> getCartSearchList(int start_money, int end_money, HttpServletRequest request) {
		HttpSession session = request.getSession(); // 요청을 한 클라이언트의 세션 객체를 얻어옴.
		// 세션 영역에 공유되어 있는 장바구니 목록 객체를 얻어옴.
		ArrayList<Cart> oldCartList = (ArrayList<Cart>)session.getAttribute("cartList");
		// 검색된 장바구니 항목을 저장할 새로운 ArrayList 객체 생성.
		ArrayList<Cart> cartList = new ArayList<Cart>();

		// 장바구니 목록을 반복하면서 검색 범위에 해당하는 장바구니 항목을 찾아서 새로 생성한 ArrayList 객체에 추가.
		for (int i = 0; i < cartList.size(); i++) {
			// 장바구니 항목 중 가격이 검색 가격에 해당하는지 체크.
			if(oldCartList.get(i).getPrice()>=start_money &&
			   oldCartList.get(i).getPrice()<=end_money) {
				cartList.add(oldCartList.get(i));
			}
			
		}
		
		return cartList;
	}
}
