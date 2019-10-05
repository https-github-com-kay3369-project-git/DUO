package mapper;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class mysqlTest1 {
private static final String DRIVER ="com.mysql.jdbc.Driver";
private static final String URL="jdbc:mysql://localhost:3306/duo?useSSL=false&serverTimezone=UTC&PublickeyRetieval=true";
private static final String USER="root";
private static final String PW="1234";
	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL,USER,PW);
		try {
			System.out.println("데이터베이스에 연결하였습니다");
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("데이터베이스 연결 실패");
		}
	}

}
