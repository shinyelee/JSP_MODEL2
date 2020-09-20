package svc;

import java.util.ArrayList;
import java.sql.Connection;
import dao.BoardDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;

// �� ��� ���� ��û�� ó���ϴ� ����Ͻ� ������ �����ϴ� Service Ŭ����.
public class BoardListService {
	
	public int getListCount() throws Exception {
		
		int listCount = 0; // �� ���� ������������ ������ ����.
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		listCount = boardDAO.selectListCount(); // �����ͺ��̽����� �� �Խ��� ���� ������ ��ȯ�ϴ� ����� �ϴ� �޼ҵ带 ȣ��.
		close(con);
		return listCount;
		
	}
	
	public ArrayList<BoardBean> getArticleList(int page, int limit) throws Exception {
	
		ArrayList<BoardBean> articleList = null; // �ش� �������� ��µ� �� ����� ������ ArrayList Ÿ���� ���۷��� ������ ����.
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		articleList = boardDAO.selectArticleList(page,limit); // �����ͺ��̽����� �ش� �������� ��µ� �� ����� ��ȯ�ϴ� �޼ҵ带 ȣ��.
		close(con);
		return articleList;
		
	}

}