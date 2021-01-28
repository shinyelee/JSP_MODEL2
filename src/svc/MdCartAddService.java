package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Cart;
import vo.Md;
import dao.MdDAO;

// 새로운 장바구니 항목을 추가하는 요청을 처리하는 비즈니스 로직을 구현하는 Service 클래스.
public class MdCartAddService {

	// 파라미터 값으로 전송된 id 값을 가지고 있는 굿즈 상품 정보를 얻어오는 메소드를 정의.
	public Md getCartMd(int id) {
		Connection con = getConnection();
		MdDAO mdDAO = MdDAO.getInstance();
		mdDAO.setConnection(con);	
		Md md = mdDAO.selectMd(id);
		close(con);
		return md;
	}

	// 장바구니 항목을 추가하는 기능이 구현된 메소드를 정의.
	public void addCart(HttpServletRequest request, Md cartMd) {
		// 요청을 한 클라이언트의 세션 객체를 얻어옴.
		HttpSession session = request.getSession();
		// 현재 세션 영역에 저장되어 있는 장바구니 목록을 얻어옴.
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		// 요청시 아직 세션 영역에 장바구니 목록 객체가 존재하지 않으면, 즉, 장바구니 요청을 처음 실행하는 경우에는
		// 장바구니 항목을 요소로 추가할 ArrayList 객체를 생성해서 해당 객체를 세션 영역의 속성으로 공유해줌.
		if(cartList == null){
		   cartList = new ArrayList<Cart>();
		   session.setAttribute("cartList", cartList);
		}
		
		// 요청에 의해서 추가되는 장바구니 항목이 장바구니 항목 목록에 이미 존재하는 항목인지를 판단하는 변수를 정의.
		// isNewCart 변수의 기본 값을 true로 지정하여 기본적으로 요청에서 지정한 항목이 처음으로 추가되는 장바구니 항목으로 지정되게 함.
		boolean isNewCart = true;
		
		// 새로 추가할 장바구니 항목이 기존 장바구니 항목 목록(cartList)에 존재하는지를 판단하여
		// 기존에 존재하는 장바구니 항목이면 isNewCart 변수 값을 false로 변경해 주고 기존 장바구니 항목의 수량을 하나 증가시킴.
		for (int i = 0; i < cartList.size(); i++) {
			// 각 장바구니 항목 데이터의 식별자를 name 값으로 사용하기 때문에
			// 새로 추가하는 상품(cartMd)의 name 값과 동일한 name 값을 가지고 있는 cart 객체가 존재하면
			// 새로 추가하려는 상품의 장바구니 항목이 존재한다고 판단.
			if(cartMd.getItem().equals(cartList.get(i).getItem())){
				isNewCart = false;
				// 새로 장바구니에 담는 굿즈 상품의 장바구니 항목 개수를 증가시킴.
				cartList.get(i).setQty(cartList.get(i).getQty()+1);
				break;
			}
		}
		
		// 장바구니 담기 요청을 한 굿즈 상품이 장바구니 항목으로 존재하지 않으면
		// 장바구니 항목을 저장하는 cartList 객체에 새로운 Cart 객체를 생성하여 추가.
		if(isNewCart){
			Cart cart = new Cart();
			cart.setImage(cartMd.getImage());
			cart.setItem(cartMd.getItem());
			cart.setPrice(cartMd.getPrice());
			cart.setQty(1);
			cartList.add(cart);
		}
		
	}
	
}