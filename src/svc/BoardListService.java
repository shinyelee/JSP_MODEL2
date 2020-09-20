package svc;

import java.util.ArrayList;
import java.sql.Connection;
import dao.BoardDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;

// 글 목록 보기 요청을 처리하는 비즈니스 로직을 구현하는 Service 클래스.
public class BoardListService {
	
	public int getListCount() throws Exception {
		
		int listCount = 0; // 총 글의 개수를저장할 변수를 선언.
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		listCount = boardDAO.selectListCount(); // 데이터베이스에서 총 게시판 글의 개수를 반환하는 기능을 하는 메소드를 호출.
		close(con);
		return listCount;
		
	}
	
	public ArrayList<BoardBean> getArticleList(int page, int limit) throws Exception {
	
		ArrayList<BoardBean> articleList = null; // 해당 페이지에 출력될 글 목록을 저장할 ArrayList 타입의 레퍼런스 변수를 선언.
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		articleList = boardDAO.selectArticleList(page,limit); // 데이터베이스에서 해당 페이지에 출력될 글 목록을 반환하는 메소드를 호출.
		close(con);
		return articleList;
		
	}

}