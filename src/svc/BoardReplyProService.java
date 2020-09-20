package svc;

import java.sql.Connection;
import dao.BoardDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;

// 답변하기 요청을 처리하는 비즈니스 로직을 구현하는 Service 클래스.
public class BoardReplyProService {
	
	public boolean replyArticle(BoardBean article) throws Exception {
		
		boolean isReplySuccess = false;
		int insertCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		// 답변글 정보를 파라미터 값으로 전송받아 데이터베이스에 답변글을 등록하는 메소드를 호출.
		insertCount = boardDAO.insertReplyArticle(article);
		
		if(insertCount > 0) {
			commit(con);
			isReplySuccess = true;
		}
		else {
			rollback(con);
		}
		
		close(con);
		return isReplySuccess;
		
	}

}