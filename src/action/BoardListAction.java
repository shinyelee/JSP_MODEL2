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
	
	@Override
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		// �� �������� ��µ� ��ü �� ����� ������ ArrayList ��ü�� ����.
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		// ��� ���� ��û���� ��µ� �������� �⺻�� = 1������.
		int page = 1;
		// �� �������� ��µ� ���� ���� = 10��.
		int limit = 10;
		
		// ��� ���⿡ ��µ� �������� �Ķ���ͷ� ���۵� ��� page ������ ���� �����ϴ� �κ�.
		// ��� ���� ���������� ��ȸ�� ������ ��ȣ�� Ŭ���ϰ� ��û�� ���� ������ ��ȣ�� �Ķ���ͷ� ���۵Ǿ� ��.
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		BoardListService boardListService = new BoardListService();
		// �� ���� ������ ��ȯ�ϴ� �޼ҵ� ȣ��.
		int listCount = boardListService.getListCount();
		// ������ �������� ��µ� �� ����� ��ȯ�ϴ� �޼ҵ� ȣ��.
		articleList = boardListService.getArticleList(page,limit);
		// �� ������ �� ��� -> 0.95�� ���ؼ� �ø� ó��.
		int maxPage = (int)((double)listCount/limit+0.95);
		// ���� ������ ��ȣ(1/11/21...).
		int startPage = (((int)((double)page/10+0.9))-1)*10+1;
		// ������ ������ ��ȣ(10/20/30...).
		int endPage = startPage+10-1;
		
		if (endPage > maxPage)
			// �������� 10������ �� ������ ������ ��, ������ ������ ��ȣ=�ִ� ������ ��ȣ.
			// [���� ] [31][32][33][34] [����] �̷� ������.
			endPage = maxPage;
		
		// ����¡�� ���� ������ ������ PageInfo ��ü ����.
		PageInfo pageInfo = new PageInfo();
		// pageInfo ��ü�� ����¡ ���� �������� �Ӽ� ������ ����.
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		// pageInfo ��ü�� request ������ �Ӽ� ������ ����.
		request.setAttribute("pageInfo", pageInfo);
		// �ش� �������� ��µ� ���� ��� ������ request ������ ����.
		request.setAttribute("articleList", articleList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/board/qna_board_list.jsp");
		return forward;
		
	}
	
}