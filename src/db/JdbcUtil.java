package db;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// DB ���� �⺻ ��� Ŭ����.
// Connection(����), Close(�ڿ���ȯ), Commit(�۾��Ϸ�), Rollback(���) ���� ���.
public class JdbcUtil {

	// Connection Pool���� Connection ��ü�� ���ͼ� ��ȯ�ϴ� �޼ҵ带 ����.
	public static Connection getConnection() {
		Connection con = null;
		
		try { // ��Ĺ ��ü�� ���ؽ�Ʈ�� ����.
			Context initCtx = new InitialContext();
			// Resource ���ǿ� ���� ���ؽ�Ʈ�� ����. lookup �޼ҵ��� ��ȯ Ÿ���� Object�̹Ƿ� Context Ÿ������ �ٿ�ĳ�����ؾ� ��.
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			// context.xml���� ������ DataSource ��ü�� ����.
			DataSource ds = (DataSource)envCtx.lookup("jdbc/MySQLDB");
			// Connection Pool���� Connection ��ü�� ����.
			con = ds.getConnection();
			// Connection ��ü�� Ʈ������� ����.
			con.setAutoCommit(false);
			System.out.println("connect success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	// Connection ��ü �ݾ��ִ� �޼ҵ� ����.
	public static void close(Connection con) {
		
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// Statement ��ü �ݾ��ִ� �޼ҵ� ����.
	public static void close(Statement stmt) {
		
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// ResultSet ��ü �ݾ��ִ� �޼ҵ� ����.
	public static void close(ResultSet rs) {
		
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// Ʈ����� �� ����� �۾��� �Ϸ��Ű�� �޼ҵ� ����.
	public static void commit(Connection con) {
		
		try {
			con.commit();
			System.out.println("commit success");
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	// Ʈ����� �� ����� �۾��� ��ҽ�Ű�� �޼ҵ� ����.
	public static void rollback(Connection con) {
		
		try {
			con.rollback();
			System.out.println("rollback success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
