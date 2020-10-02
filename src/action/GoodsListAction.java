/*

package action;

import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.GoodsListService;
import vo.ActionForward;
import vo.Goods;

// ���� ��ǰ ��Ϻ��� ��û�� ó���ϴ� Action Ŭ����.
public class GoodsListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		// ��ü ���� ��ǰ ����� �����ִ� �� ���������� ���� �� ��ǰ�� �̹����� ����ϹǷ� ���� �� ��ǰ�� �̹����� ������ ArrayList ��ü�� ����.
		ArrayList<String> todayImageList = new ArrayList<String>();
		// Ŭ���̾�Ʈ���� �Ѿ�� Cookie ��ü���� �迭 ���·� ��ȯ ����. ����Ʈ���� ���� �� ��ǰ�� �ִٸ� �� ��ǰ�� �̹����� ��Ű�� ����Ǿ� �ִ�.
		Cookie[] cookieArray = request.getCookies();

		// ��û�� �Ѿ�� ��Ű ��ü �� ���� �� ��ǰ �̹��� �̸��� �����ϰ� �ִ� ��Ű ��ü�� ã�Ƽ� todayImageList ArrayList ��ü�� ��Ű ��ü�� �� ��, �̹��� �̸��� ��ҷ� �߰�.
		// Ư�� ��ǰ�� �ڼ��� ������ �� �� GoodsViewAction Ŭ�������� ������ �� ��ǰ�� �̹����� today ���ڿ� �ڿ� �ش� ��ǰ�� ���̵� ���� �̸����� ��Ű ��ü�� �����Ѵ�.
		if (cookieArray != null) {
			for (int i = 0; i < cookieArray.length; i++) {
				if (cookieArray[i].getName().startsWith("today")) {
					todayImageList.add(cookieArray[i].getValue());
				}
			}
		}
		
		GoodsListService goodsListService = new GoodsListService(); // ���� ��ǰ ��Ϻ��� ��û�� ó���ϴ� ���� ��ü�� ����.
		ArrayList<Goods> goodsList = goodsListService.getGoodsList(); // ��ϵǾ��ִ� �� ��ǰ ������ ArrayList Ÿ������ ����.
		request.setAttribute("goodsList", goodsList); // request ������ �� ��ǰ ��� ������ �Ӽ����� ������.
		request.setAttribute("todayImageList", todayImageList); // request ������ ���� �� ���� ��ǰ �̹��� ��� ������ �Ӽ����� ������.
		// ������ ������ ActionForward ��ü�� ����. �������� �������� GoodsList.jsp �������� ���������� ������ ����� ����ġ ������� ����.
		ActionForward forward = new ActionForward("goodsList.jsp", false);

		return forward;

	}
}

*/