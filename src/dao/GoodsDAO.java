package dao;

// �����ͺ��̽� �۾��� JdbcUtil Ŭ������ ���ǵ� �ִ� static �޼ҵ带 ����� ���ϰ� ó���ϱ� ����
// JdbcUtil Ŭ������ static �޼ҵ峪 �Ӽ��� ����Ʈ��.
import static db.JdbcUtil.*;
import java.sql.*;
import java.util.ArrayList;
import vo.Goods;

public class GoodsDAO {

	Connection con;
	private static GoodsDAO boardDAO;
	
	// �������� ���� �����ڸ� �ܺ� Ŭ�������� ���� ȣ���� �� ������ private���� ����.
	// (�ܺ� Ŭ�������� GoodsDAO ��ü�� �޼ҵ带 ����� ������ ��ü�� ��� �������� �ʰ�
	// �̱��� ������ ����� ó�� ������ ��ü�� �����ؼ� ����ϵ��� ó���ϱ� ���ؼ���.)
	private GoodsDAO() {}
	
	// �����ͺ��̽� �۾��� �ϱ� ���ؼ� �ʿ��� Connection ��ü�� ��� ���� ������ ����.
	public void setConnection(Connection con){
		this.con = con;
	}
	
	// �ܺ� Ŭ�������� GoodsDAO Ŭ������ ���ǵ� �޼ҵ带 ����ϱ� ���� ��ü�� �� ��
	// ù ��° ��û������ ��ü�� �������ְ� ������ ��ü�� ����� ���� ó�� ������ ��ü�� ���۷��� ���� ����.
	// �������� ���� �����ڸ� private���� ���������Ƿ� �ܺ� Ŭ�������� GoodsDAO ��ü�� ���۷��� ���� �� ��
	// �ݵ�� getInstance() �޼ҵ带 ȣ���ؼ� ���� ��.
	public static GoodsDAO getInstance(){
		
		if(boardDAO == null){
		   boardDAO = new GoodsDAO();
		}
		
		return boardDAO;
	}
	
	// �����ͺ��̽��� ����� �ִ� ��� ��ǰ ������ ��ȯ�ϴ� �޼ҵ带 ����.
	public ArrayList<Goods> selectGoodsList() {
		
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		ArrayList<Goods> goodsList = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM goods");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				goodsList = new ArrayList<Goods>();
				
				do {
					goodsList.add(new Goods(
							rs.getInt("id")
							,rs.getString("name")
							,rs.getInt("price")
							,rs.getString("image")
							,rs.getString("category")
							,rs.getString("category2")
							,rs.getInt("version")
							,rs.getString("content")
							,rs.getInt("readcount")));
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return goodsList;
	}
	
	// �����ͺ��̽��� ����� �ִ� ��ǰ ���� �� �Ķ���ͷ� ���۵� id ���� ������ �ִ� ��ǰ�� ������ ��ȯ�ϴ� �޼ҵ带 ����.
	public Goods selectGoods(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Goods goods = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM goods WHERE id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				goods = new Goods(
						rs.getInt("id")
						,rs.getString("name")
						,rs.getInt("price")
						,rs.getString("image")
						,rs.getString("category")
						,rs.getString("category2")
						,rs.getInt("version")
						,rs.getString("content")
						,rs.getInt("readcount"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return goods;
	}
	
	// �� ���� ���� ��û�� �� ��ǰ ������ ��ȸ���� ������Ű�� �޼ҵ带 ����.
	public int updateReadCount(int id) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "";
		
		try {
			sql = "UPDATE goods SET readcount = readcount + 1 WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
	// ���ο� ��ǰ ������ �����ͺ��̽��� �߰��ϴ� �޼ҵ带 ����.
	public int insertGoods(Goods goods) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";
		
		try {
			sql = "INSERT INTO goods VALUES(goods_seq.nextval,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goods.getName());
			pstmt.setInt(2, goods.getPrice());
			pstmt.setString(3, goods.getImage());
			pstmt.setString(4, goods.getCategory());
			pstmt.setString(5, goods.getCategory2());
			pstmt.setInt(6, goods.getVersion());
			pstmt.setString(7, goods.getContent());
			pstmt.setInt(8, goods.getReadcount());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	
}
