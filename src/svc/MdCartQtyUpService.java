package svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Cart;

// ��ٱ��� �׸� ���� ���� ��û�� ó���ϴ� ����Ͻ� ������ �����ϴ� Service Ŭ����.
public class MdCartQtyUpService {

	public void upCartQty(String item, HttpServletRequest request) { 
		
		// ��û�� �� Ŭ���̾�Ʈ�� ���� ��ü�� ����.
		HttpSession session = request.getSession();
		// ���� ������ �����Ǿ� �ִ� ��ٱ��� ��� ��ü�� ����.
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		// ������ ������ų ��ٱ��� �׸� ��ü�� item ������ ���� �˻��� �� �ش� ��ü�� ���� ���� ������Ŵ.
		for (int i = 0; i < cartList.size(); i++) {
			
			if(cartList.get(i).getItem().equals(item)) {
				cartList.get(i).setQty(cartList.get(i).getQty()+1);		
			}
			
		}
		
	}
	
}