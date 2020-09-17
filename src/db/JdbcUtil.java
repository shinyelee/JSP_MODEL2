package db;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil { // DB ���� ���� ��� Ŭ����.

	public static Connection getConnection() { // Connection Pool���� Connection ��ü�� ���ͼ� ��ȯ�ϴ� �޼ҵ带 ����.
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
	
	public static void close(Connection con) { // Connection ��ü �ݾ��ִ� �޼ҵ� ����.
		
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(Statement stmt) { // Statement ��ü �ݾ��ִ� �޼ҵ� ����.
		
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(ResultSet rs) { // ResultSet ��ü �ݾ��ִ� �޼ҵ� ����.
		
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void commit(Connection con) { // Ʈ����� �� ����� �۾��� �Ϸ��Ű�� �޼ҵ� ����.
		
		try {
			con.commit();
			System.out.println("commit success");
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public static void rollback(Connection con) { // Ʈ����� �� ����� �۾��� ��ҽ�Ű�� �޼ҵ� ����.
		
		try {
			con.rollback();
			System.out.println("rollback success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
