package common;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {

	public static void main(String[] args) {
        Connection con = null; // DB와 연결 설정.
        
        String className = "org.gjt.mm.mysql.Driver"; // MySQL연결 드라이버.
        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&useUnicode=true&characterEncoding=utf-8"; // 호스트 주소.
        String user = "root"; // MySQL ID.
        String passwd = "1234"; // MySQL PW.
        
        try {
            Class.forName(className); // 드라이버 로드.
            con = DriverManager.getConnection(url, user, passwd); // 드라이버 식별.
            System.out.println("Connect Success!"); // 연결 성공.
        } catch(Exception e) {
            System.out.println("Connect Failed!"); //연결 실패(예외 발생).
            e.printStackTrace();
        } finally {
                try {
                    if(con != null && !con.isClosed()) {
                        con.close(); // 자원해제.
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
        }
        
    }

}
