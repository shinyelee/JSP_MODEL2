package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.MdCartRemoveService;
import vo.ActionForward;

// ��ٱ��� �׸� ���� ��û�� ó���ϴ� Action Ŭ����.
public class MdCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// ���ÿ� ���� ���� ��ٱ��� �׸��� ������ �� �ֱ� ������ ������ ��ٱ��� �׸��� item �Ķ���� ���� �迭 ���·� �޴´�.
		// �� ������Ʈ������ ��Ϻ��� ���������� ������ ��ٱ��� �׸��� üũ �ڽ� ���·� üũ�ϰ� ó���ȴ�.
		String[] kindArray = request.getParameterValues("remove");
		// ��ٱ��� �׸� ���� ����Ͻ� ������ ó���ϴ� ���� ��ü�� ����.
		MdCartRemoveService mdCartRemoveService = new MdCartRemoveService();
		// ��ٱ��� �׸� ���� ��û�� ó���ϴ� �޼ҵ带 ȣ��. ���� ������ �����Ǿ� �ִ� ��ٱ��� �׸� ������ �����ؾ� �ϱ� ������ ���ǿ� �����ϱ� ���ؼ� request ��ü�� ���ڷ� ����.
		mdCartRemoveService.cartRemove(request,kindArray);
		// ��ٱ��� �׸� ���� ��û ó���� ������ �� ������ ������ ActionForward ��ü�� ����.
		// ��ٱ��� �׸� ���� ó���� �� �� ��ٱ��� ��Ϻ��� ��û�� �ٽ� �ϱ� ���ؼ� URL��mdCartList.md��, �������� �����̷�Ʈ ������� ó���ϱ� ���� true�� ����.
		ActionForward forward = new ActionForward("mdCartList.md",true);
		
		return forward;
	}
	
}