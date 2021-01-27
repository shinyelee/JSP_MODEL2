package dao;

// 데이터베이스 작업을 JdbcUtil 클래스에 정의돼 있는 static 메소드를 사용해 편리하게 처리하기 위해
// JdbcUtil 클래스의 static 메소드나 속성을 임포트함.
import static db.JdbcUtil.*;
import java.sql.*;
import java.util.ArrayList;
import vo.Md;

public class MdDAO {
	
	Connection con;
	private static MdDAO boardDAO;
	
	// 생성자의 접근 제한자를 외부 클래스에서 직접 호출할 수 없도록 private으로 지정.
	// (외부 클래스에서 GoodsDAO 객체의 메소드를 사용할 때마다 객체를 계속 생성하지 않고
	// 싱글톤 패턴을 사용해 처음 생성된 객체를 공유해서 사용하도록 처리하기 위해서임.)	
	private MdDAO() {
		
	}
	
	// 데이터베이스 작업을 하기 위해서 필요한 Connection 객체를 멤버 변수 값으로 설정.
	public void setConnection(Connection con){
		this.con = con;
	}
	
	// 외부 클래스에서 GoodsDAO 클래스에 정의된 메소드를 사용하기 위해 객체를 얻어갈 때
	// 첫 번째 요청에서만 객체를 생성해주고 다음에 객체를 사용할 때는 처음 생성된 객체의 레퍼런스 값을 공유.
	// 생성자의 접근 제한자를 private으로 지정했으므로 외부 클래스에서 GoodsDAO 객체의 레퍼런스 값을 얻어갈 땐
	// 반드시 getInstance() 메소드를 호출해서 얻어가야 함.
	public static MdDAO getInstance(){
		
		if(boardDAO == null){
		   boardDAO = new MdDAO();
		}
		
		return boardDAO;
	}
	
	// 데이터베이스에 저장돼 있는 모든 상품 정보를 반환하는 메소드를 정의.
	public ArrayList<Md> selectMdList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Md> mdList = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM md");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				mdList = new ArrayList<Md>();
				
				do {
					mdList.add(new Md(
							 rs.getInt("mdid")
							,rs.getString("item")
							,rs.getInt("price")
							,rs.getString("image")
							,rs.getString("cate1")
							,rs.getString("cate2")
							,rs.getString("cate3")
							,rs.getString("content")
							,rs.getInt("hit")));
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return mdList;
	}
	
	// 데이터베이스에 저장돼 있는 상품 정보 중 파라미터로 전송된 id 값을 가지고 있는 상품의 정보를 반환하는 메소드를 정의.
	public Md selectMd(int mdid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Md md = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM md WHERE mdid=?");
			pstmt.setInt(1, mdid);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				md = new Md(
						 rs.getInt("mdid")
						,rs.getString("item")
						,rs.getInt("price")
						,rs.getString("image")
						,rs.getString("cate1")
						,rs.getString("cate2")
						,rs.getString("cate3")
						,rs.getString("content")
						,rs.getInt("hit"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return md;
	}
	
	// 상세 내용 보기 요청이 된 상품 정보의 조회수를 증가시키는 메소드를 정의.
	public int updateHit(int mdid) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "";
		
		try {
			sql = "UPDATE md SET hit = hit + 1 WHERE mdid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mdid);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
	// 새로운 상품 정보를 데이터베이스에 추가하는 메소드를 정의.
	public int insertMd(Md md) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";
		
		try {
			sql = "INSERT INTO md VALUES(md_seq.nextval,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, md.getItem());
			pstmt.setInt(2, md.getPrice());
			pstmt.setString(3, md.getImage());
			pstmt.setString(4, md.getCate1());
			pstmt.setString(5, md.getCate2());
			pstmt.setString(6, md.getCate3());
			pstmt.setString(7, md.getContent());
			pstmt.setInt(8, md.getHit());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	
}
