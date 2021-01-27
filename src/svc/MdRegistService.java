package svc;

// JdbcUtil 클래스에 static으로 정의되어 있는 속성과 메소드를 편리하게 사용하기 위해서 static import를 처리.
import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.MdDAO;
import vo.Md;

public class MdRegistService {

	public boolean registMd(Md md) {
		
		MdDAO mdDAO = MdDAO.getInstance();
		// 데이터베이스 작업을 처리할 MdDAO 객체를 얻어옴.
		Connection con = getConnection();
		// 데이터베이스 작업에 사용될 Connection 객체를 MdDAO의 멤버 변수로 삽입.
		mdDAO.setConnection(con);		
		// 등록 작업 성공 여부를 저장할 변수를 정의.
		boolean isRegistSuccess = false;		
		// 데이터베이스에 새로운 굿즈 상품 정보를 추가하는 메소드를 호출.
		int insertCount = mdDAO.insertMd(md);
		
		// 등록 작업이 성공했을 때 트렌잭션 작업을 완성시킴.
		if(insertCount>0) {
			commit(con);
			isRegistSuccess=true;
		// 등록 작업이 실패했을 때 트렌잭션 작업을 취소시킴.
		} else {
			rollback(con);
		}
		
		// 사용한 Connection 객체를 닫아줌.
		close(con);
		return isRegistSuccess;
	}

}