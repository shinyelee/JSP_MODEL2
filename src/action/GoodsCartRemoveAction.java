package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.GoodsCartRemoveService;
import vo.ActionForward;

// ��ٱ��� �׸� ���� ��û�� ó���ϴ� Action Ŭ����.
public class GoodsCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// ���ÿ� ���� ���� ��ٱ��� �׸��� ������ �� �ֱ� ������ ������ ��ٱ��� �׸��� kind �Ķ���� ���� �迭 ���·� �޴´�.
		// �� ������Ʈ������ ��Ϻ��� ���������� ������ ��ٱ��� �׸��� üũ �ڽ� ���·� üũ�ϰ� ó���ȴ�.
		String[] kindArray = request.getParameterValues("remove");
		// ��ٱ��� �׸� ���� ����Ͻ� ������ ó���ϴ� ���� ��ü�� ����.
		GoodsCartRemoveService goodsCartRemoveService = new GoodsCartRemoveService();
		// ��ٱ��� �׸� ���� ��û�� ó���ϴ� �޼ҵ带 ȣ��. ���� ������ �����Ǿ� �ִ� ��ٱ��� �׸� ������ �����ؾ� �ϱ� ������ ���ǿ� �����ϱ� ���ؼ� request ��ü�� ���ڷ� ����.
		goodsCartRemoveService.cartRemove(request,kindArray);
		// ��ٱ��� �׸� ���� ��û ó���� ������ �� ������ ������ ActionForward ��ü�� ����.
		// ��ٱ��� �׸� ���� ó���� �� �� ��ٱ��� ��Ϻ��� ��û�� �ٽ� �ϱ� ���ؼ� URL�� goodsCartList.go��, �������� �����̷�Ʈ ������� ó���ϱ� ���� true�� ����.
		ActionForward forward = new ActionForward("goodsCartList.go",true);
		return forward;
	}
	
}