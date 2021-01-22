package svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Cart;

// ��ٱ��� �׸� ���� ���� ��û�� ó���ϴ� ����Ͻ� ������ �����ϴ� Service Ŭ����.
public class GoodsCartQtyDownService {

	public void downCartQty(String name, HttpServletRequest request) { 
		HttpSession session = request.getSession(); // ��û�� �� Ŭ���̾�Ʈ�� ���� ��ü�� ����.
		// ���� ������ �����Ǿ� �ִ� ��ٱ��� ��� ��ü�� ����.
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		// ������ ���ҽ�ų ��ٱ��� �׸� ��ü�� name ������ ���� �˻��� �� �ش� ��ü�� ���� ���� ���ҽ�Ŵ.
		for (int i = 0; i < cartList.size(); i++) {
			if(cartList.get(i).getName().equals(name)) {
				cartList.get(i).setQty(cartList.get(i).getQty()-1);
			}
			
		}
		
	}
	
}