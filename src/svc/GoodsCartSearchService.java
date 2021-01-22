package svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Cart;

// ��ٱ��� �׸� �˻� ��û�� ó���ϴ� ����Ͻ� ������ �����ϴ� Service Ŭ����.
public class GoodsCartSearchService {

	public ArrayList<Cart> getCartSearchList(int start_money, int end_money, HttpServletRequest request) {
		HttpSession session = request.getSession(); // ��û�� �� Ŭ���̾�Ʈ�� ���� ��ü�� ����.
		// ���� ������ �����Ǿ� �ִ� ��ٱ��� ��� ��ü�� ����.
		ArrayList<Cart> oldCartList = (ArrayList<Cart>)session.getAttribute("cartList");
		// �˻��� ��ٱ��� �׸��� ������ ���ο� ArrayList ��ü ����.
		ArrayList<Cart> cartList = new ArayList<Cart>();

		// ��ٱ��� ����� �ݺ��ϸ鼭 �˻� ������ �ش��ϴ� ��ٱ��� �׸��� ã�Ƽ� ���� ������ ArrayList ��ü�� �߰�.
		for (int i = 0; i < cartList.size(); i++) {
			// ��ٱ��� �׸� �� ������ �˻� ���ݿ� �ش��ϴ��� üũ.
			if(oldCartList.get(i).getPrice()>=start_money &&
			   oldCartList.get(i).getPrice()<=end_money) {
				cartList.add(oldCartList.get(i));
			}
			
		}
		
		return cartList;
	}
}
