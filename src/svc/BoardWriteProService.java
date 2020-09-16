package svc;

import java.sql.Connection;
import dao.BoardDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;

public class BoardWriteProService {

	public boolean registArticle(BoardBean boardBean) throws Exception {
		
		boolean isWriteSuccess = false; // 글 등록 작업 성공 여부를 저장할 변수를 정의.
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance(); // 싱글톤 방식으로 BoardDAO 클래스의 인스턴스를 얻어옴.
		boardDAO.setConnection(con); // BoardDAO 클래스에서 데이터베이스 작업을 수행할 때 사용할 Connection 객체를 주입.
		int insertCount = boardDAO.insertArticle(boardBean); // 데이터베이스에 새로운 글 정보를 삽입하는 기능을 수행하는 메소드를 호출.
		
		if(insertCount > 0) { // 새로운 글 정보를 데이터베이스에 성공적으로 삽입한 경우 트랜잭션을 완성시키고 isWriteSuccess 변수값을 true로 설정.
			commit(con);
			isWriteSuccess = true;
		}
		else { // 새로운 글 정보를 데이터베이스에 삽입하는 작업이 실패했을 때 트랜잭션 작업을 취소시킴.
			rollback(con);
		}
		
		close(con);
		return isWriteSuccess;

	}

}