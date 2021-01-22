package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.GoodsCartSearchService;
import vo.ActionForward;
import vo.Cart;

public class GoodsCartSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// �������� ��ٱ��� �׸��� �˻��ϴ� ����Ͻ� ������ �����Ǿ� �ִ� ���� ��ü�� ����.
		GoodsCartSearchService goodsCartSearchService = new GoodsCartSearchService();
		int startMoney = Integer.parseInt(request.getParameter("startMoney")); // �˻��� ���� ���� �ݾװ�
		int endMoney = Integer.parseInt(request.getParameter("endMoney")); // ������ �ݾ��� �Ķ���ͷ� ����.
		// ���� �ݾװ� ������ �ݾ� ���̿� �����ϴ� �ݾ��� ������ �ִ� ��ǰ�� ��ٱ��� �׸��� �˻��ϴ� �޼ҵ带 ȣ��.
		ArrayList<Cart> cartList = goodsCartSearchService.getCartSearchList(startMoney,endMoney,request);
		request.setAttribute("cartList", cartList); // �˻��� ��ٱ��� �׸��� request ������ �Ӽ����� ����.
		request.setAttribute("startMoney", startMoney); // �˻��� ���� ���� �ݾ��� request ������ �Ӽ����� ����.
		request.setAttribute("endMoney", endMoney); //  �˻��� ���� ������ �ݾ��� request ������ �Ӽ����� ����.
		
		int totalMoney = 0;
		int money = 0 ;
		
		for (int i = 0; i < cartList.size(); i++) {
			money = cartList.get(i).getPrice()*cartList.get(i).getQty();
			totalMoney += money;
		}

		request.setAttribute("totalMoney", totalMoney);
		// ������ ������ ActionForward ��ü�� ����. �������� �������� GoodsList.jsp �������� ���������� ������ ����� ����ġ ������� ó���ϱ� ���� false�� ����.
		ActionForward forward = new ActionForward("goodsCartList.jsp", false);
		return forward;
	}
	
}