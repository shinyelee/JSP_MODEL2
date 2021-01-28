package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.MdCartAddService;
import vo.ActionForward;
import vo.Md;

//��ٱ��� ��� ��û�� ó���ϴ� Action Ŭ����.
public class MdCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// ��ٱ��� �׸��� �߰��ϴ� ����Ͻ� ������ ó���ϴ� ���� ��ü�� ����.
		MdCartAddService mdCartAddService = new MdCartAddService();
		// ��ٱ��� �׸����� �߰��� ��ǰ�� ���̵� �Ķ���� ������ ����.
		int id = Integer.parseInt(request.getParameter("id"));
		// ��ٱ��� �׸����� �߰��� ��ǰ ������ ����.
		Md cartMd = mdCartAddService.getCartMd(id);
		// Ư�� ��ǰ�� ��ٱ��� �׸����� �߰��ϴ� �޼ҵ带 ȣ��. ���� ���� ��ü�� ��ٱ��� �׸��� �߰��ؾ� �ϱ� ������ �Ķ���� ������ request ��ü�� ������.
		mdCartAddService.addCart(request,cartMd);
		// ���� ��ü�� ���� �� request.getSession() �޼ҵ带 ȣ���ؼ� ����. �������� ���Ǵ� ������ ActionForward ��ü�� ����.
		// ��ٱ��� �׸��� �߰��� �� ��ٱ��� ��Ϻ��� ��û�� �ٽ� �ϱ� ���ؼ� url�� goodsCartList.go�� ����,
		// �����̷�Ʈ ������� ������ ó���� �ϱ� ���ؼ� redirect �Ӽ� ���� true�� ����.
		ActionForward forward = new ActionForward("mdCartList.md", true);
		
		return forward;
	}

}
