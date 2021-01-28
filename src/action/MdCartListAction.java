package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.MdCartListService;
import vo.ActionForward;
import vo.Cart;

// ��ٱ��� ��Ϻ��� ��û�� ó���ϴ� Action Ŭ����.
public class MdCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// ��ٱ��� ��Ϻ��� ����Ͻ� ������ ó���ϴ� ���� Ŭ���� ��ü�� ����.
		MdCartListService mdCartListService = new MdCartListService();
		// ��ü ��ٱ��� ����� ArrayList Ÿ���� ��ü�� ��ȯ�ϴ� �޼ҵ带 ȣ��.
		ArrayList<Cart> cartList = mdCartListService.getCartList(request);
		
		// �����ؾ� �ϴ� �� �ݾ��� �����ϴ� ������ ����.
		int totalMoney = 0;
		// ��ٱ��� �׸� �ϳ��� ���� ���� �ݾ��� �����ϴ� ������ ����.
		int money = 0 ;
		
		// ��ٱ��� �׸� ��Ͽ� �����ϴ� ��ü ��ǰ�� �����ϴ� �� �ʿ��� �� �ݾ��� ���.
		for (int i = 0; i < cartList.size(); i++) {
			// ��ٱ��� �׸� �ϳ����� �ݾ��� ���.
			money = cartList.get(i).getPrice()*cartList.get(i).getQty();
			// �� ��ٱ��� �׸��� �ݾ��� �� �ݾ׿� ���ϸ鼭 ��ü ��ٱ��� �׸��� ��ǰ�� �����ϱ� ���� �ʿ��� �� �ݾ��� ���.
			totalMoney += money;
		}

		// �� �ݾ��� request ������ �Ӽ����� ����.
		request.setAttribute("totalMoney", totalMoney);
		// ��ü ��ٱ��� ����� request ������ �Ӽ����� ����.
		request.setAttribute("cartList", cartList);
		// ������ ������ ActionForward ��ü�� ����. �������� URL�� goodsCartList.jsp�� �����ϰ� ������ ����� ����ġ ������� ó���ϱ� ���� false�� ����.
		ActionForward forward = new ActionForward("mdCartList.jsp", false);
		
		return forward;
	}

}