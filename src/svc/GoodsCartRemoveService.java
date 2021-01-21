package svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Cart;

// ��ٱ��� �׸� ���� ��û�� ó���ϴ� ����Ͻ� ������ �����ϴ� Service Ŭ����.
public class GoodsCartRemoveService {

	public void cartRemove(HttpServletRequest request, String[]nameArray) { 
		HttpSession session = request.getSession(); // ��û�� �� Ŭ���̾�Ʈ�� ���� ��ü�� ����.
		// ���� ������ �����Ǿ� �ִ� ��ٱ��� ��� ��ü�� ����.
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		// Ŭ���̾�Ʈ�� ������ ������� ������ �׸��� name ������ �ݺ��ؼ� ó��.
		for (int i = 0; i < nameArray.length; i++) {
			// ������ �׸��� name���� �ش� name ���� ������ name ���� ���� ��ٱ��� �׸��� ã�Ƽ� ���� ó��.
			for (int j = 0; j < cartList.size(); j++){
				// ������ name ���� ��ٱ��� �׸��� name ���� ��.
				if(cartList.get(j).getName().equals(nameArray[i])) {
					// ������  �׸��� ��ٱ��� ��Ͽ��� ����.
					cartList.remove(cartList.get(j));
				}
				
			}
			
		}
		
	}
	
}