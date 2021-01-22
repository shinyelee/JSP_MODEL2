package svc;

// JdbcUtil 클래스에 static으로 정의되어 있는 속성과 메소드를 편리하게 사용하기 위해서 static import를 처리.
import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.GoodsDAO;
import vo.Goods;

public class GoodsRegistService {

	public boolean registGoods(Goods goods) {
		
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		Connection con = getConnection(); // 데이터베이스 작업을 처리할 GoodsDAO 객체를 얻어옴.
		goodsDAO.setConnection(con); // 데이터베이스 작업에 사용될 Connection 객체를 GoodsDAO의 멤버 변수로 삽입.
		boolean isRegistSuccess = false; // 등록 작업 성공 여부를 저장할 변수를 정의.
		int insertCount = goodsDAO.insertGoods(goods); // 데이터베이스에 새로운 굿즈 상품 정보를 추가하는 메소드를 호출.
		
		// 등록 작업이 성공했을 때 트렌잭션 작업을 완성시킴.
		if(insertCount>0){
			commit(con);
			isRegistSuccess=true;
		// 등록 작업이 실패했을 때 트렌잭션 작업을 취소시킴.
		}else{
			rollback(con);
		}
		
		close(con); // 사용한 Connection 객체를 닫아줌.
		return isRegistSuccess;
	}

}