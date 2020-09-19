/*

package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;
import java.sql.Connection;
import dao.BoardDAO;

public class BoardDeleteProService {
	
	public boolean isArticleWriter(int board_num, String pass) throws Exception {
		// 글 삭제 요청한 사용자가 글을 작성한 사용자인지를 판단하는 메소드를 정의.
		boolean isArticleWriter = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		isArticleWriter = boardDAO.isArticleBoardWriter(board_num,pass);
		close(con);
		return isArticleWriter;
		
	}
	
	public boolean removeArticle(int board_num) throws Exception {
		// 글 삭제 요청을 처리하는 메소드를 정의.
		boolean isRemoveSuccess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int deleteCount = boardDAO.deleteArticle(board_num);
		
		if(deleteCount > 0) { // 트랜잭션을 처리.
			commit(con);
			isRemoveSuccess=true;
		}
		else {
			rollback(con);
		}
		
		close(con);
		return isRemoveSuccess;
	}
	
}

*/