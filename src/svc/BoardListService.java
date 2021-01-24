package svc;

import java.util.ArrayList;
import java.sql.Connection;
import dao.BoardDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;

// �� ��� ���� ��û�� ó���ϴ� ����Ͻ� ������ �����ϴ� Service Ŭ����.
public class BoardListService {
	
	public int getListCount() throws Exception {
		
		// �� ���� ������ ������ ������ ����.
		int listCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		// �����ͺ��̽����� �� �Խ��� ���� ������ ��ȯ�ϴ� ����� �ϴ� �޼ҵ带 ȣ��.
		listCount = boardDAO.selectListCount();
		close(con);
		return listCount;
		
	}
	
	public ArrayList<BoardBean> getArticleList(int page, int limit) throws Exception {
		
		// �ش� �������� ��µ� �� ����� ������ ArrayList Ÿ���� ���۷��� ������ ����.
		ArrayList<BoardBean> articleList = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		// �����ͺ��̽����� �ش� �������� ��µ� �� ����� ��ȯ�ϴ� �޼ҵ带 ȣ��.
		articleList = boardDAO.selectArticleList(page,limit);
		close(con);
		return articleList;
		
	}

}