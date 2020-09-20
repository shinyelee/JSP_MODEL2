package action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardListService;
import vo.ActionForward;
import vo.BoardBean;
import vo.PageInfo;

// �� ��� ���� ��û�� ó���ϴ� Action Ŭ����.
public class BoardListAction implements Action {
	
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		// �� �������� ��µ� ��ü �� ����� ������ ArrayList ��ü�� ����.
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		int page = 1; // ��� ���� ��û���� ��µ� �������� �⺻�� = 1������.
		int limit = 10; // �� �������� ��µ� ���� ���� = 10��.
		
		// ��� ���⿡ ��µ� �������� �Ķ���ͷ� ���۵� ��� page ������ ���� �����ϴ� �κ�.
		// ��� ���� ���������� ��ȸ�� ������ ��ȣ�� Ŭ���ϰ� ��û�� ���� ������ ��ȣ�� �Ķ���ͷ� ���۵Ǿ� ��.
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		BoardListService boardListService = new BoardListService();
		int listCount = boardListService.getListCount(); // �� ���� ������ ��ȯ�ϴ� �޼ҵ� ȣ��.
		articleList = boardListService.getArticleList(page,limit); // ������ �������� ��µ� �� ����� ��ȯ�ϴ� �޼ҵ� ȣ��.
		int maxPage = (int)((double)listCount/limit+0.95); // �� ������ �� ��� -> 0.95�� ���ؼ� �ø� ó��.
		int startPage = (((int)((double)page/10+0.9))-1)*10+1; // ���� ������ ��ȣ(1/11/21...).
		int endPage = startPage+10-1; // ������ ������ ��ȣ(10/20/30...).
		
		if(endPage > maxPage) endPage = maxPage; // �������� 10������ �� ������ ������ ��.
		
		PageInfo pageInfo = new PageInfo(); // ����¡�� ���� ������ ������ PageInfo ��ü ����.
		// pageInfo ��ü�� ����¡ ���� �������� �Ӽ� ������ ����.
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		request.setAttribute("pageInfo", pageInfo); // pageInfo ��ü�� request ������ �Ӽ� ������ ����.
		request.setAttribute("articleList", articleList); // �ش� �������� ��µ� ���� ��� ������ request ������ ����.
		ActionForward forward = new ActionForward();
		forward.setPath("/board/qna_board_list.jsp");
		return forward;
		
	}
	
}