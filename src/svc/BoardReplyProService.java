package svc;

import java.sql.Connection;
import dao.BoardDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;

public class BoardReplyProService {
	
	public boolean replyArticle(BoardBean article) throws Exception {
		
		boolean isReplySuccess = false;
		int insertCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		// �亯�� ������ �Ķ���� ������ ���۹޾� �����ͺ��̽��� �亯���� ����ϴ� �޼ҵ带 ȣ��.
		insertCount = boardDAO.insertReplyArticle(article);
		
		if(insertCount > 0) {
			commit(con);
			is ReplySuccess = true;
		}
		else {
			rollback(con);
		}
		
		close(con);
		return isReplySuccess;
		
	}

}