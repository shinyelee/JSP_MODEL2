package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.GoodsCartQtyUpService;
import vo.ActionForward;

// ��ٱ��� �׸� ���� ���� ��û�� ó���ϴ� Action Ŭ����.
public class GoodsCartQtyUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// ������ ������ų ����� �Ǵ� ��ٱ��� �׸��� kind ���� �Ķ���� ������ ����. ��ٱ��� �׸��� �ĺ��ڴ� kind ���� ���.
		String kind = request.getParameter("kind");
		// ��ٱ��� �׸��� ������ ������Ű�� ����Ͻ� ������ ó���ϴ� ���� ��ü�� ����.
		GoodsCartQtyUpService goodsCartQtyUpService = new GoodsCartQtyUpService();
		goodsCartQtyUpService.upCartQty(kind,request); // ��ٱ��� �׸��� ������ ������Ű�� �޼ҵ带 ȣ��.
		// ��ٱ��� �׸��� ������ ������Ű�� ��û ó���� ������ �� ������ ������ ActionForward ��ü�� ����.
		// ��ٱ��� �׸��� ���� ���� ó���� �� �� ��ٱ��� ��Ϻ��� ��û�� �ٽ� �ϱ� ���ؼ� URL�� goodsCartList.go��, �������� �����̷�Ʈ ������� ó���ϱ� ���� true�� ����.
		ActionForward forward = new ActionForward("goodsCartList.go", true);
		return forward;
	}

}