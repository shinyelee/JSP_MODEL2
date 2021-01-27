package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import vo.Md;
import dao.MdDAO;

// 굿즈 상품 상세 정보보기 요청을 처리하는 비즈니스 로직을 구현하는 Service 클래스.
public class MdViewService {

	public Md getMdView(int mdid) {
		
		Connection con = getConnection();
		MdDAO mdDAO = MdDAO.getInstance();
		mdDAO.setConnection(con);
		// 상세 정보를 요청하는 굿즈 상품의 조회수를 증가시킴.
		int updateCount = mdDAO.updateHit(mdid);
		
		// 조회수 증가가 성공했을 때 트렌젝션 작업을 완성시킴.
		if(updateCount>0) {
			commit(con);
		// 조회수 증가 작업이 실패했을 때 트렌젝션 작업을 취소시킴.
		} else {
			rollback(con);
		}
		
		// 파라미터로 전송된 id값을 가지고 있는 굿즈 상품 정보 하나를 얻어옴.
		Md md = mdDAO.selectMd(mdid);
		close(con);
		
		return md;
	}

}
