package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.GoodsCartAddService;
import vo.ActionForward;
import vo.Goods;

// ��ٱ��� ��� ��û�� ó���ϴ� Action Ŭ����.
public class GoodsCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		GoodsCartAddService goodsCartAddService = new GoodsCartAddService(); // ��ٱ��� �׸��� �߰��ϴ� ����Ͻ� ������ ó���ϴ� ���� ��ü�� ����.
		int id = Integer.parseInt(request.getParameter("id")); // ��ٱ��� �׸����� �߰��� ���� ��ǰ�� ���̵� �Ķ���� ������ ����.
		Goods cartGoods = goodsCartAddService.getCartGoods(id); // ��ٱ��� �׸����� �߰��� ���� ��ǰ ������ ����.
		// Ư�� ���� ��ǰ�� ��ٱ��� �׸����� �߰��ϴ� �޼ҵ带 ȣ��. ���� ���� ��ü�� ��ٱ��� �׸��� �߰��ؾ� �ϱ� ������ �Ķ���� ������ request ��ü�� ������.
		goodsCartAddService.addCart(request,cartGoods);
		// ���� ��ü�� ���� �� request.getSession() �޼ҵ带 ȣ���ؼ� ����. �������� ���Ǵ� ������ ActionForward ��ü�� ����.
		// ��ٱ��� �׸��� �߰��� �� ��ٱ��� ��Ϻ��� ��û�� �ٽ� �ϱ� ���ؼ� url�� goodsCartList.go�� ����,
		// �����̷�Ʈ ������� ������ ó���� �ϱ� ���ؼ� redirect �Ӽ� ���� true�� ����.
		ActionForward forward = new ActionForward("goodsCartList.go", true);
		return forward;
	}

}