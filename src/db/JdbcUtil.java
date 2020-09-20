package db;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// DB ���� ���� ��� Ŭ����.
public class JdbcUtil {

	// Connection Pool���� Connection ��ü�� ���ͼ� ��ȯ�ϴ� �޼ҵ带 ����.
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Context initCtx = new InitialContext(); // ��Ĺ ��ü�� ���ؽ�Ʈ�� ����.
			Context envCtx = (Context)initCtx.lookup("java:comp/env"); // Resource ���ǿ� ���� ���ؽ�Ʈ�� ����. lookup �޼ҵ��� ��ȯ Ÿ���� Object�̹Ƿ� Context Ÿ������ �ٿ�ĳ�����ؾ� ��.
			DataSource ds = (DataSource)envCtx.lookup("jdbc/MySQLDB"); // context.xml���� ������ DataSource ��ü�� ����.
			con = ds.getConnection(); // Connection Pool���� Connection ��ü�� ����.
			con.setAutoCommit(false); // Connection ��ü�� Ʈ������� ����.
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
