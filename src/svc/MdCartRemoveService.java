package svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Cart;

// ��ٱ��� �׸� ���� ��û�� ó���ϴ� ����Ͻ� ������ �����ϴ� Service Ŭ����.
public class MdCartRemoveService {
	
	public void cartRemove(HttpServletRequest request, String[] itemArray) {
		
		// ��û�� �� Ŭ���̾�Ʈ�� ���� ��ü�� ����.
		HttpSession session = request.getSession();
		// ���� ������ �����Ǿ� �ִ� ��ٱ��� ��� ��ü�� ����.
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		// Ŭ���̾�Ʈ�� ������ ������� ������ �׸��� item ������ �ݺ��ؼ� ó��.
		for (int i = 0; i < itemArray.length; i++) {
			// ������ �׸��� item���� �ش� item ���� ������ item ���� ���� ��ٱ��� �׸��� ã�Ƽ� ���� ó��.
			for (int j = 0; j < cartList.size(); j++) {
				// ������ item ���� ��ٱ��� �׸��� item ���� ��.
				if(cartList.get(j).getItem().equals(itemArray[i])){
					// ������  �׸��� ��ٱ��� ��Ͽ��� ����.
					cartList.remove(cartList.get(j));
				}
				
			}
			
		}
		
	}
}