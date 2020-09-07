package common;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {

	public static void main(String[] args) {
        Connection con = null; // DB�� ���� ����.
        
        String className = "org.gjt.mm.mysql.Driver"; // MySQL���� ����̹�.
        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&useUnicode=true&characterEncoding=utf-8"; // ȣ��Ʈ �ּ�.
        String user = "root"; // MySQL ID.
        String passwd = "1234"; // MySQL PW.
        
        try {
            Class.forName(className); // ����̹� �ε�.
            con = DriverManager.getConnection(url, user, passwd); // ����̹� �ĺ�.
            System.out.println("Connect Success!"); // ���� ����.
        } catch(Exception e) {
            System.out.println("Connect Failed!"); //���� ����(���� �߻�).
            e.printStackTrace();
        } finally {
                try {
                    if(con != null && !con.isClosed()) {
                        con.close(); // �ڿ�����.
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
        }
        
    }

}
