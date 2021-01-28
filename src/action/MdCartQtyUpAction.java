package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.MdCartQtyUpService;
import vo.ActionForward;

//��ٱ��� �׸� ���� ���� ��û�� ó���ϴ� Action Ŭ����.
public class MdCartQtyUpAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// ������ ������ų ����� �Ǵ� ��ٱ��� �׸��� item ���� �Ķ���� ������ ����. ��ٱ��� �׸��� �ĺ��ڴ� kind ���� ���.
		String item = request.getParameter("item");
		// ��ٱ��� �׸��� ������ ������Ű�� ����Ͻ� ������ ó���ϴ� ���� ��ü�� ����.
		MdCartQtyUpService mdCartQtyUpService = new MdCartQtyUpService();
		// ��ٱ��� �׸��� ������ ������Ű�� �޼ҵ带 ȣ��.
		mdCartQtyUpService.upCartQty(item,request);
		// ��ٱ��� �׸��� ������ ������Ű�� ��û ó���� ������ �� ������ ������ ActionForward ��ü�� ����.
		// ��ٱ��� �׸��� ���� ���� ó���� �� �� ��ٱ��� ��Ϻ��� ��û�� �ٽ� �ϱ� ���� URL�� goodsCartList.go��, �������� �����̷�Ʈ ������� ó���ϱ� ���� true�� ����.
		ActionForward forward = new ActionForward("mdCartList.md", true);
		
		return forward;
	}

}
