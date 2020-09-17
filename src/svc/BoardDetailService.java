package svc;

import java.sql.Connection;
import dao.BoardDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;

public class BoardDetailService { // 글 상세 내용 보기 요청을 처리하는 비즈니스 로직을 구현하는 Service 클래스.

	public BoardBean getArticle(int board) throws Exception {
		
		BoardBean article = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int updateCount = boardDAO.updateReadCount(board_num); // 상세 글 내용을 볼 글의 조회수를 증가시키는 메소드를 호출.
		// 조회수 증가 update 작업의 트랜잭션을 처리해 줌.
		// 오라클에서는 데이터를 조작하는 작업을 실행할 때는 내부적으로 암시적 트랜잭션이 적용되므로 반드시 트랜잭션을 처리하는 부분이 존재해야 한다.
		if(updateCount > 0) {
			commit(con);
		}
		else {
			rollback(con);
		}
		
		article = boardDAO.selectArticle(board_num); // 인자로 지정한 글번호의 정보를 반환하는 메소드를 호출.
		close(con);
		return article;
		
	}
	
}