package svc;

import java.sql.Connection;
import dao.BoardDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;

// �� ��� ��û�� ó���ϴ� ����Ͻ� ������ �����ϴ� Service Ŭ����.
public class BoardWriteProService {

	public boolean registArticle(BoardBean boardBean) throws Exception {
		
		boolean isWriteSuccess = false; // �� ��� �۾� ���� ���θ� ������ ������ ����.
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance(); // �̱��� ������� BoardDAO Ŭ������ �ν��Ͻ��� ����.
		boardDAO.setConnection(con); // BoardDAO Ŭ�������� �����ͺ��̽� �۾��� ������ �� ����� Connection ��ü�� ����.
		int insertCount = boardDAO.insertArticle(boardBean); // �����ͺ��̽��� ���ο� �� ������ �����ϴ� ����� �����ϴ� �޼ҵ带 ȣ��.
		
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