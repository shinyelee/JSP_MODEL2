/*

package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.GoodsCartListService;
import vo.ActionForward;
import vo.Cart;

// ��ٱ��� ��Ϻ��� ��û�� ó���ϴ� Action Ŭ����.
public class GoodsCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		GoodsCartListService goodsCartListService = new GoodsCartListService(); // ��ٱ��� ��Ϻ��� ����Ͻ� ������ ó���ϴ� ���� Ŭ���� ��ü�� ����.
		ArrayList<Cart> cartList = goodsCartListService.getCartList(request); // ��ü ��ٱ��� ����� ArrayList Ÿ���� ��ü�� ��ȯ�ϴ� �޼ҵ带 ȣ��.
		
		int totalMoney = 0; // �����ؾ� �ϴ� �� �ݾ��� �����ϴ� ������ ����.
		int money = 0 ; // ��ٱ��� �׸� �ϳ��� ���� ���� �ݾ��� �����ϴ� ������ ����.
		
		// ��ٱ��� �׸� ��Ͽ� �����ϴ� ��ü ��ǰ�� �����ϴ� �� �ʿ��� �� �ݾ��� ���.
		for (int i = 0; i < cartList.size(); i++) {
			money = cartList.get(i).getPrice()*cartList.get(i).getQty(); // ��ٱ��� �׸� �ϳ����� �ݾ��� ���.
			totalMoney += money; // �� ��ٱ��� �׸��� �ݾ��� �� �ݾ׿� ���ϸ鼭 ��ü ��ٱ��� �׸��� ��ǰ�� �����ϱ� ���� �ʿ��� �� �ݾ��� ���.
		}

		request.setAttribute("totalMoney", totalMoney); // �� �ݾ��� request ������ �Ӽ����� ����.
		request.setAttribute("cartList", cartList); // ��ü ��ٱ��� ����� request ������ �Ӽ����� ����.
		// ������ ������ ActionForward ��ü�� ����. �������� URL�� goodsCartList.jsp�� �����ϰ� ������ ����� ����ġ ������� ó���ϱ� ���� false�� ����.
		ActionForward forward = new ActionForward("goodsCartList.jsp", false);
		return forward;
	}

}

*/