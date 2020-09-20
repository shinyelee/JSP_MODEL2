package svc;

import java.sql.Connection;
import dao.BoardDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;

// 글 수정하기 요청을 처리하는 비즈니스 로직을 구현하는 Service 클래스.
public class BoardModifyProService { 
	
	public boolean isArticleWriter(int board_num, String pass) throws Exception {
		// 수정 시 입력한 비밀번호를 비교하여 수정 작업을 하는 사용자가 해당 글을 작성한 사용자인지를 판단하는 메소드를 정의.
		boolean isArticleWriter = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		// 데이터베이스에 저장된 데이터를 사용하여 수정 작업을 하는 사용자가 글을 작성한 사용자인지를 판단하는 메소드를 호출.
		isArticleWriter = boardDAO.isArticleBoardWriter(board_num, pass);
		close(con);
		return isArticleWriter;
		
	}

	public boolean modifyArticle(BoardBean article) throws Exception {
		// 글 수정 작업을 처리하는 비즈니스 로직이 구현되는 메소드를 정의.
		boolean isModifySuccess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		// 수정 정보를 파라미터 값으로 전송받아 데이터베이스에서 글 정보를 수정하는 메소드를 호출.
		int updateCount = boardDAO.updateArticle(article);
		
		// 트랜잭션을 처리.
		if(updateCount > 0) {
			commit(con);
			isModifySuccess=true;
		}
		else {
			rollback(con);
		}
		
		close(con);
		return isModifySuccess;
		
	}
	
}