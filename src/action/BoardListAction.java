package action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardListService;
import vo.ActionForward;
import vo.BoardBean;
import vo.PageInfo;

// 글 목록 보기 요청을 처리하는 Action 클래스.
public class BoardListAction implements Action {
	
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		// 각 페이지당 출력될 전체 글 목록을 저장할 ArrayList 객체를 생성.
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		int page = 1; // 목록 보기 요청에서 출력될 페이지의 기본값 = 1페이지.
		int limit = 10; // 한 페이지당 출력될 글의 개수 = 10개.
		
		// 목록 보기에 출력될 페이지가 파라미터로 전송된 경우 page 변수의 값을 변경하는 부분.
		// 목록 보기 페이지에서 조회할 페이지 번호를 클릭하고 요청한 경우는 페이지 번호가 파라미터로 전송되어 옴.
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		BoardListService boardListService = new BoardListService();
		int listCount = boardListService.getListCount(); // 총 글의 개수를 반환하는 메소드 호출.
		articleList = boardListService.getArticleList(page,limit); // 지정한 페이지에 출력될 글 목록을 반환하는 메소드 호출.
		int maxPage = (int)((double)listCount/limit+0.95); // 총 페이지 수 계산 -> 0.95를 더해서 올림 처리.
		int startPage = (((int)((double)page/10+0.9))-1)*10+1; // 시작 페이지 번호(1/11/21...).
		int endPage = startPage+10-1; // 마지막 페이지 번호(10/20/30...).
		
		if(endPage > maxPage) endPage = maxPage; // 페이지가 10단위로 안 나누어 떨어질 때.
		
		PageInfo pageInfo = new PageInfo(); // 페이징에 관한 정보를 저장할 PageInfo 객체 생성.
		// pageInfo 객체에 페이징 관련 정보들을 속성 값으로 설정.
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		request.setAttribute("pageInfo", pageInfo); // pageInfo 객체를 request 영역에 속성 값으로 공유.
		request.setAttribute("articleList", articleList); // 해당 페이지에 출력될 글의 목록 정보를 request 영역에 공유.
		ActionForward forward = new ActionForward();
		forward.setPath("/board/qna_board_list.jsp");
		return forward;
		
	}
	
}