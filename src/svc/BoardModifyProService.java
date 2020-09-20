package svc;

import java.sql.Connection;
import dao.BoardDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;

// �� �����ϱ� ��û�� ó���ϴ� ����Ͻ� ������ �����ϴ� Service Ŭ����.
public class BoardModifyProService { 
	
	public boolean isArticleWriter(int board_num, String pass) throws Exception {
		// ���� �� �Է��� ��й�ȣ�� ���Ͽ� ���� �۾��� �ϴ� ����ڰ� �ش� ���� �ۼ��� ����������� �Ǵ��ϴ� �޼ҵ带 ����.
		boolean isArticleWriter = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		// �����ͺ��̽��� ����� �����͸� ����Ͽ� ���� �۾��� �ϴ� ����ڰ� ���� �ۼ��� ����������� �Ǵ��ϴ� �޼ҵ带 ȣ��.
		isArticleWriter = boardDAO.isArticleBoardWriter(board_num, pass);
		close(con);
		return isArticleWriter;
		
	}

	public boolean modifyArticle(BoardBean article) throws Exception {
		// �� ���� �۾��� ó���ϴ� ����Ͻ� ������ �����Ǵ� �޼ҵ带 ����.
		boolean isModifySuccess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		// ���� ������ �Ķ���� ������ ���۹޾� �����ͺ��̽����� �� ������ �����ϴ� �޼ҵ带 ȣ��.
		int updateCount = boardDAO.updateArticle(article);
		
		// Ʈ������� ó��.
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