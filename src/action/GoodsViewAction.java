package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.GoodsViewService;
import vo.ActionForward;
import vo.Goods;

// Ư�� ���� ��ǰ�� �� �������� ��û�� ó���ϴ� Action Ŭ����.
public class GoodsViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		GoodsViewService goodsViewService = new GoodsViewService(); // ���� ��ǰ ���� �� ���� ����Ͻ� ������ ó���ϴ� ���� ��ü�� ����.
		int id = Integer.parseInt(request.getParameter("id")); // �� ������ ����� ��� ���� ��ǰ�� id ���� �Ķ���ͷ� ����.
		Goods goods = goodsViewService.getGoodsView(id); // �Ķ���� ������ ���۵� id ���� ������ �ִ� ������ ������ Goods Ŭ���� ��ü Ÿ������ ��ȯ����.
		request.setAttribute("goods", goods); // request ������ goods ��ü�� �Ӽ����� ����.
		// ���� ��ǰ ������ �̹��� �̸� ���ڿ��� today ���ڿ� �ڿ� �ش� ���� ��ǰ�� id ���� �����Ͽ� ("today"+id) ��Ű �̸��� ������ �� ��Ű ��ü�� �����Ͽ� ����.
		Cookie todayImageCookie = new Cookie("today"+id, goods.getImage());
		todayImageCookie.setMaxAge(60*60*24); // ���� �� ��ǰ �̹����� ������ ��Ű ��ü�� Ŭ���̾�Ʈ �ý��ۿ� ����Ǿ� ���� �Ⱓ�� 24�ð����� ����.
		response.addCookie(todayImageCookie); // ���信 ��Ű ��ü�� �߰�.
		// ������ ������ ActionForward ��ü�� ����. �������� URL�� goodsView.jsp�� �����ϰ� ������ ����� ����ġ ������� ����.
		ActionForward forward = new ActionForward("goodsView.jsp", false);
		return forward;
	}
	
}