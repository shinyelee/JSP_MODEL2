/*

package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.GoodsCartQtyDownService;
import vo.ActionForward;

// ��ٱ��� �׸� ���� ���� ��û�� ó���ϴ� Action Ŭ����.
public class GoodsCartQtyDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// ������ ���ҽ�ų ����� �Ǵ� ��ٱ��� �׸��� kind ���� �Ķ���� ������ ����. ��ٱ��� �׸��� �ĺ��ڴ� kind ���� ���.
		String kind = request.getParameter("kind");
		// ��ٱ��� �׸��� ������ ���ҽ�Ű�� ����Ͻ� ������ ó���ϴ� ���� ��ü�� ����.
		GoodsCartQtyDownService goodsCartQtyDownService = new GoodsCartQtyDownService();
		goodsCartQtyDownService.downCartQty(kind,request); // ��ٱ��� �׸��� ������ ���ҽ�Ű�� �޼ҵ带 ȣ��.
		// ��ٱ��� �׸��� ������ ���ҽ�Ű�� ��û ó���� ������ �� ������ ������ ActionForward ��ü�� ����.
		// ��ٱ��� �׸��� ���� ���� ó���� �� �� ��ٱ��� ��Ϻ��� ��û�� �ٽ� �ϱ� ���ؼ� URL�� goodsCartList.go��, �������� �����̷�Ʈ ������� ó���ϱ� ���� true�� ����.
		ActionForward forward = new ActionForward("goodsCartList.go", true);
		return forward;
	}

}

*/