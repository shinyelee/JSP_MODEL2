package svc;

import java.sql.Connection;
import dao.BoardDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;

// �� ��� ��û�� ó���ϴ� ����Ͻ� ������ �����ϴ� Service Ŭ����.
public class BoardWriteProService {

	public boolean registArticle(BoardBean boardBean) throws Exception {
		
		// �� ��� �۾� ���� ���θ� ������ ������ ����.
		boolean isWriteSuccess = false;
		Connection con = getConnection();
		// �̱��� ������� BoardDAO Ŭ������ �ν��Ͻ��� ����.
		BoardDAO boardDAO = BoardDAO.getInstance();
		// BoardDAO Ŭ�������� �����ͺ��̽� �۾��� ������ �� ����� Connection ��ü�� ����.
		boardDAO.setConnection(con);
		// �����ͺ��̽��� ���ο� �� ������ �����ϴ� ����� �����ϴ� �޼ҵ带 ȣ��.
		int insertCount = boardDAO.insertArticle(boardBean);
		
		// ���ο� �� ������ �����ͺ��̽��� ���������� ������ ��� Ʈ������� �ϼ���Ű�� isWriteSuccess �������� true�� ����.
		if(insertCount > 0) {
			commit(con);
			isWriteSuccess = true;
		}
		// ���ο� �� ������ �����ͺ��̽��� �����ϴ� �۾��� �������� �� Ʈ����� �۾��� ��ҽ�Ŵ.
		else {
			rollback(con);
		}
		
		close(con);
		return isWriteSuccess;

	}

}