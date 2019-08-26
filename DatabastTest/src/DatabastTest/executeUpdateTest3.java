package DatabastTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class executeUpdateTest3 {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버연결
			String url = "jdbc:mysql://localhost:3306/book_db?serverTimezone=Asia/Seoul"; // DB연결
			System.out.println("드라이버 적재 성공");
			con = DriverManager.getConnection(url, "root", "1234");
			System.out.println("데이터베이스 연결 성공");
	
			Statement stmt = con.createStatement();
			String s = "update books set publisher='Wiley' where   publisher='wiley' ";
		
			System.out.println(s);
			int i = stmt.executeUpdate(s);
			if (i == 1)
				System.out.println("레코드 수정 성공");
			else
				System.out.println("레코드 수정 실패");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("연결에 실패하였습니다.");
		}

	}

}
