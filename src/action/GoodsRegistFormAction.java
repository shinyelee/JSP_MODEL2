package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;


// ���ο� ���� ��ǰ ���� ��� �������� �����ִ� ��û�� ó���ϴ� Action Ŭ����.
public class GoodsRegistFormAction implements Action {
	
	// �� Ŭ���� ��ü�� Ư���� ����Ͻ� ������ ó���� �ʿ䰡 ���� ������ �ٷ� ActionForward ��ü�� �����ؼ� goodsRegistForm.jsp�� ������ ó���� �Ѵ�.
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward("goodsRegistForm.jsp", false);
		return forward;
	}
	
}