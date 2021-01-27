package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.MdViewService;
import vo.ActionForward;
import vo.Md;

// Ư�� ��ǰ�� �� �������� ��û�� ó���ϴ� Action Ŭ����.
public class MdViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// ��ǰ ���� �� ���� ����Ͻ� ������ ó���ϴ� ���� ��ü�� ����.
		MdViewService mdViewService = new MdViewService();
		// �� ������ ����� ��� ��ǰ�� id ���� �Ķ���ͷ� ����.
		int id = Integer.parseInt(request.getParameter("id"));
		// �Ķ���� ������ ���۵� id ���� ������ �ִ� ��ǰ�� ������ Md Ŭ���� ��ü Ÿ������ ��ȯ����.
		Md md = mdViewService.getMdView(id);
		// request ������ md ��ü�� �Ӽ����� ����.
		request.setAttribute("md", md);
		// ��ǰ ������ �̹��� �̸� ���ڿ��� today ���ڿ� �ڿ� �ش� ��ǰ�� id ���� �����Ͽ� ("today"+id) ��Ű �̸��� ������ �� ��Ű ��ü�� �����Ͽ� ����.
		Cookie todayImageCookie = new Cookie("today"+id, md.getImage());
		// ���� �� ��ǰ �̹����� ������ ��Ű ��ü�� Ŭ���̾�Ʈ �ý��ۿ� ����Ǿ� ���� �Ⱓ�� 24�ð����� ����.
		todayImageCookie.setMaxAge(60*60*24);
		// ���信 ��Ű ��ü�� �߰�.
		response.addCookie(todayImageCookie);
		// ������ ������ ActionForward ��ü�� ����. �������� URL�� mdView.jsp�� �����ϰ� ������ ����� ����ġ ������� ����.
		ActionForward forward = new ActionForward("mdView.jsp", false);
		
		return forward;
	}
	
}