package dao;

// �����ͺ��̽� �۾��� JdbcUtil Ŭ������ ���ǵ� �ִ� static �޼ҵ带 ����� ���ϰ� ó���ϱ� ����
// JdbcUtil Ŭ������ static �޼ҵ峪 �Ӽ��� ����Ʈ��.
import static db.JdbcUtil.*;
import java.sql.*;
import java.util.ArrayList;
import vo.Md;

public class MdDAO {
	
	Connection con;
	private static MdDAO boardDAO;
	
	// �������� ���� �����ڸ� �ܺ� Ŭ�������� ���� ȣ���� �� ������ private���� ����.
	// (�ܺ� Ŭ�������� GoodsDAO ��ü�� �޼ҵ带 ����� ������ ��ü�� ��� �������� �ʰ�
	// �̱��� ������ ����� ó�� ������ ��ü�� �����ؼ� ����ϵ��� ó���ϱ� ���ؼ���.)	
	private MdDAO() {
		
	}
	
	// �����ͺ��̽� �۾��� �ϱ� ���ؼ� �ʿ��� Connection ��ü�� ��� ���� ������ ����.
	public void setConnection(Connection con){
		this.con = con;
	}
	
	// �ܺ� Ŭ�������� GoodsDAO Ŭ������ ���ǵ� �޼ҵ带 ����ϱ� ���� ��ü�� �� ��
	// ù ��° ��û������ ��ü�� �������ְ� ������ ��ü�� ����� ���� ó�� ������ ��ü�� ���۷��� ���� ����.
	// �������� ���� �����ڸ� private���� ���������Ƿ� �ܺ� Ŭ�������� GoodsDAO ��ü�� ���۷��� ���� �� ��
	// �ݵ�� getInstance() �޼ҵ带 ȣ���ؼ� ���� ��.
	public static MdDAO getInstance(){
		
		if(boardDAO == null){
		   boardDAO = new MdDAO();
		}
		
		return boardDAO;
	}
	
	// �����ͺ��̽��� ����� �ִ� ��� ��ǰ ������ ��ȯ�ϴ� �޼ҵ带 ����.
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
	
	// �����ͺ��̽��� ����� �ִ� ��ǰ ���� �� �Ķ���ͷ� ���۵� id ���� ������ �ִ� ��ǰ�� ������ ��ȯ�ϴ� �޼ҵ带 ����.
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
	
	// �� ���� ���� ��û�� �� ��ǰ ������ ��ȸ���� ������Ű�� �޼ҵ带 ����.
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
	
	// ���ο� ��ǰ ������ �����ͺ��̽��� �߰��ϴ� �޼ҵ带 ����.
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
