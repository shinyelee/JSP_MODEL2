package svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Cart;

// ��ٱ��� ��Ϻ��� ��û�� ó���ϴ� ����Ͻ� ������ �����ϴ� Service Ŭ����.
public class MdCartListService {

	public ArrayList<Cart> getCartList(HttpServletRequest request) {
		// ��û�� �� Ŭ���̾�Ʈ�� ���� ��ü�� ����.
		HttpSession session = request.getSession();
		// ���� ������ �����Ǿ� �ִ� ��ٱ��� ��� ��ü�� ����.
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		return cartList;
	}
	
}
