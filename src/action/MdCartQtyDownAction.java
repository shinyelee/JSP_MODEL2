package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.MdCartQtyDownService;
import vo.ActionForward;

// ��ٱ��� �׸� ���� ���� ��û�� ó���ϴ� Action Ŭ����.
public class MdCartQtyDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// ������ ���ҽ�ų ����� �Ǵ� ��ٱ��� �׸��� kind ���� �Ķ���� ������ ����. ��ٱ��� �׸��� �ĺ��ڴ� kind ���� ���.
		String item = request.getParameter("item");
		// ��ٱ��� �׸��� ������ ���ҽ�Ű�� ����Ͻ� ������ ó���ϴ� ���� ��ü�� ����.
		System.out.println("item = " + item);
		MdCartQtyDownService mdCartQtyDownService = new MdCartQtyDownService();
		// ��ٱ��� �׸��� ������ ���ҽ�Ű�� �޼ҵ带 ȣ��.
		mdCartQtyDownService.downCartQty(item,request);
		// ��ٱ��� �׸��� ������ ���ҽ�Ű�� ��û ó���� ������ �� ������ ������ ActionForward ��ü�� ����.
		// ��ٱ��� �׸��� ���� ���� ó���� �� �� ��ٱ��� ��Ϻ��� ��û�� �ٽ� �ϱ� ���ؼ� URL�� goodsCartList.go��, �������� �����̷�Ʈ ������� ó���ϱ� ���� true�� ����.
		ActionForward forward = new ActionForward("mdCartList.md",true);
		
		return forward;
	}

}