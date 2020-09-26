package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import vo.BoardBean;

public class BoardDAO {

	DataSource ds;
	Connection con;
	private static BoardDAO boardDAO; // 외부 클래스에서 BoardDAO 변수에 직접 접근할 수 없도록 접근 제한자를 private으로 지정함.

	private BoardDAO() {
		// 외부 클래스에서 생성자를 사용해서 객체를 새로 생성할 수 없도록 생성자의 접근 제한자를 private으로 지정함.
	}
	
	// 싱글톤 패턴으로 BoardDAO 객체를 생성해서 리턴해 주는 메소드를 정의.
	public static BoardDAO getInstance() {
		if(boardDAO == null) {
			boardDAO = new BoardDAO();
		}
		return boardDAO;
	}
	
	// BoardDAO 객체에 Connection 객체를 주입하는 메소드를 정의.
	public void setConnection(Connection con) {
		this.con = con;
	}

	// 게시판 전체 글 개수를 반환해 주는 메소드를 정의.
	public int selectListCount() {

		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			System.out.println("getConnection");
			// COUNT 함수를 사용해서 전체 글의 개수를 조회하는 SQL 구문으로 PreparedStatement 객체를 생성.
			pstmt=con.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();

			// 데이터베이스에서 조회한 전체 글의 개수를 listCount 변수에 할당.
			if(rs.next()) {
				listCount=rs.getInt(1);
			}
		} catch(Exception e) {
			System.out.println("getListCount 에러: "+e);			
		} finally {
			close(rs);
			close(pstmt);
		}

		return listCount;

	}

	// 해당 페이지에 출력될 글 목록을 데이터베이스에서 조회하여 반환하는 메소드를 정의.	
	public ArrayList<BoardBean> selectArticleList(int page,int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// limit ?, 10  해당 페이지의 시작 레코드 인덱스를 ? 부분에 매핑하여 해당 페이지에 출력될 첫번째 글부터 10개를 조회하게 함.
		String board_list_sql="select * from board order by BOARD_RE_REF desc,BOARD_RE_SEQ asc limit ?,10";
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		BoardBean board = null;
		int startrow = (page-1)*10; // 해당 페이지에서 출력되어야 하는 시작 레코드의 인덱스 번호를 구함.

		try {
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				board = new BoardBean();
				board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				board.setBOARD_NAME(rs.getString("BOARD_NAME"));
				board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				board.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				board.setBOARD_FILE(rs.getString("BOARD_FILE"));
				board.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				board.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				board.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				board.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				board.setBOARD_DATE(rs.getDate("BOARD_DATE"));
				articleList.add(board);
			}

		} catch(Exception e) {
			System.out.println("getBoardList 에러 : "+e);
		} finally {
			close(rs);
			close(pstmt);
		}

		return articleList;

	}

	// 파라미터 값으로 지정된 글 번호를 가지고 있는 글의 정보를 데이터베이스에서 조회하여 반환하는 메소드를 정의.
	public BoardBean selectArticle(int board_num) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardBean boardBean = null;

		try {
			// 조회하는 글의 조건값으로 board_num 컬럼 값을 사용.
			pstmt = con.prepareStatement("select * from board where BOARD_NUM = ?");
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				boardBean = new BoardBean();
				boardBean.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				boardBean.setBOARD_NAME(rs.getString("BOARD_NAME"));
				boardBean.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				boardBean.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				boardBean.setBOARD_FILE(rs.getString("BOARD_FILE"));
				boardBean.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				boardBean.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				boardBean.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				boardBean.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				boardBean.setBOARD_DATE(rs.getDate("BOARD_DATE"));
			}
		} catch(Exception e) {
			System.out.println("getDetail 에러 : "+e);
		} finally {
			close(rs);
			close(pstmt);
		}

		return boardBean;

	}

	// 새로운 글을 데이터베이스에 등록하는 역할을 하는 메소드를 정의.
	public int insertArticle(BoardBean article) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		String sql="";
		int insertCount = 0;

		try {
			pstmt=con.prepareStatement("select max(board_num) from board");
			rs = pstmt.executeQuery();

			// 새로 글이 등록될 때 부여될 관련글 번호 값을 구함.
			// 목록 보기에 글이 출력될 때 이 관련글 번호에 의해서 원글과 해당 글의 답변글이 하나로 묶인다.
			// 따라서 답글을 달 때는 자신이 답변을 하는 원글의 관련글 번호가 자신의 관련글 번호로 지정된다.
			if(rs.next())
				num =rs.getInt(1)+1;
			else
				num=1;

			sql="insert into board (BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,";
			sql+="BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF,"+
					"BOARD_RE_LEV,BOARD_RE_SEQ,BOARD_READCOUNT,"+
					"BOARD_DATE) values(?,?,?,?,?,?,?,?,?,?,now())"; // ? 10개

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getBOARD_NAME());
			pstmt.setString(3, article.getBOARD_PASS());
			pstmt.setString(4, article.getBOARD_SUBJECT());
			pstmt.setString(5, article.getBOARD_CONTENT());
			pstmt.setString(6, article.getBOARD_FILE());
			pstmt.setInt(7, num);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);

			insertCount=pstmt.executeUpdate();

		} catch(Exception e) {
			System.out.println("boardInsert 에러 : "+e);
		} finally {
			close(rs);
			close(pstmt);
		}

		return insertCount;

	}

	// 답변글을 등록하는 기능을 하는 메소드를 정의.
	public int insertReplyArticle(BoardBean article) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_max_sql="select max(board_num) from board";
		String sql="";
		int num = 0;
		int insertCount = 0;
		int re_ref=article.getBOARD_RE_REF();
		int re_lev=article.getBOARD_RE_LEV();
		int re_seq=article.getBOARD_RE_SEQ();

		try {
			pstmt=con.prepareStatement(board_max_sql);
			rs = pstmt.executeQuery();
			if(rs.next())
				num = rs.getInt(1)+1;
			else
				num = 1;
			// 자신이 답변을 다는 글과 같은 글 그룹에 속하고 자신이 답변들 다는 글보다 뒤에 출력되는 글들의 출력순서를 하나씩 증가시키는 SQL 구문.
			sql="update board set BOARD_RE_SEQ=BOARD_RE_SEQ+1 where BOARD_RE_REF=? ";
			sql+="and BOARD_RE_SEQ>?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,re_ref);
			pstmt.setInt(2,re_seq);
			int updateCount=pstmt.executeUpdate();

			if(updateCount > 0) {
				commit(con);
			}

			// 답변글의 re_lev 값과 re_seq 값을 원글보다 하나 증가시킴.
			re_seq = re_seq+1;
			re_lev = re_lev+1;
			sql="insert into board (BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,";
			sql+="BOARD_CONTENT, BOARD_FILE,BOARD_RE_REF,BOARD_RE_LEV,BOARD_RE_SEQ,";
			sql+="BOARD_READCOUNT,BOARD_DATE) values(?,?,?,?,?,?,?,?,?,?,now())"; // ? 10개
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getBOARD_NAME());
			pstmt.setString(3, article.getBOARD_PASS());
			pstmt.setString(4, article.getBOARD_SUBJECT());
			pstmt.setString(5, article.getBOARD_CONTENT());
			pstmt.setString(6, ""); //답장에는 파일을 업로드하지 않음.
			pstmt.setInt(7, re_ref);
			pstmt.setInt(8, re_lev);
			pstmt.setInt(9, re_seq);
			pstmt.setInt(10, 0);
			insertCount = pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("boardReply 에러 : "+e);
		} finally {
			close(rs);
			close(pstmt);
		}

		return insertCount;

	}

	// 글 수정하기 요청을 처리하는 메소드를 정의.
	public int updateArticle(BoardBean article) {

		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql="update board set BOARD_SUBJECT=?,BOARD_CONTENT=? where BOARD_NUM=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getBOARD_SUBJECT());
			pstmt.setString(2, article.getBOARD_CONTENT());
			pstmt.setInt(3, article.getBOARD_NUM());
			updateCount = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("boardModify 에러 : "+e);
		} finally {
			close(pstmt);
		}

		return updateCount;

	}

	// 글 삭제하기 요청을 처리하는 메소드를 정의.
	public int deleteArticle(int board_num) {

		PreparedStatement pstmt = null;
		String board_delete_sql="delete from board where BOARD_NUM=?";
		int deleteCount = 0;

		try {
			pstmt=con.prepareStatement(board_delete_sql);
			pstmt.setInt(1, board_num);
			deleteCount=pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("boardDelete 에러 : "+e);
		} finally {
			close(pstmt);
		}

		return deleteCount;

	}

	// 글의 조회수를 증가시키는 기능을 하는 메소드를 정의.
	public int updateReadCount(int board_num) {

		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql="update board set BOARD_READCOUNT = "+
				"BOARD_READCOUNT+1 where BOARD_NUM = "+board_num;

		try {
			pstmt=con.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("setReadCountUpdate 에러 : "+e);
		}
		finally {
			close(pstmt);

		}

		return updateCount;

	}

	// 현재 사용자가 글을 작성한 사용자인지를 확인하는 메소드를 정의.
	public boolean isArticleBoardWriter(int board_num,String pass) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_sql="select * from board where BOARD_NUM=?";
		boolean isWriter = false;

		try {
			pstmt=con.prepareStatement(board_sql);
			pstmt.setInt(1, board_num);
			rs=pstmt.executeQuery();
			rs.next();

			if(pass.equals(rs.getString("BOARD_PASS"))) {
				isWriter = true;
			}
		} catch(SQLException e) {
			System.out.println("isBoardWriter 에러 : "+e);
		}
		finally {
			close(pstmt);
		}

		return isWriter;

	}

}
