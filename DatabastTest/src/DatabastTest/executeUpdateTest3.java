package DatabastTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class executeUpdateTest3 {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // ����̹�����
			String url = "jdbc:mysql://localhost:3306/book_db?serverTimezone=Asia/Seoul"; // DB����
			System.out.println("����̹� ���� ����");
			con = DriverManager.getConnection(url, "root", "1234");
			System.out.println("�����ͺ��̽� ���� ����");
	
			Statement stmt = con.createStatement();
			String s = "update books set publisher='Wiley' where   publisher='wiley' ";
		
			System.out.println(s);
			int i = stmt.executeUpdate(s);
			if (i == 1)
				System.out.println("���ڵ� ���� ����");
			else
				System.out.println("���ڵ� ���� ����");

		} catch (ClassNotFoundException e) {
			System.out.println("����̹��� ã�� �� �����ϴ�.");
		} catch (SQLException e) {
			System.out.println("���ῡ �����Ͽ����ϴ�.");
		}

	}

}
