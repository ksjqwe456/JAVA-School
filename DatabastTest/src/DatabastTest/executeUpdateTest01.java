package DatabastTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class executeUpdateTest01 {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // ����̹�����
			String url = "jdbc:mysql://localhost:3306/book_db?serverTimezone=Asia/Seoul"; // DB����
			System.out.println("����̹� ���� ����");
			con = DriverManager.getConnection(url, "root", "1234");
			System.out.println("�����ͺ��̽� ���� ����");
			String title = "Artificial Intellegence";
			String publisher = "Addison Wesley";
			String year = "2002";
			int price = 35000;
			Statement stmt = con.createStatement();
			String s = "INSERT INTO books (title, publisher, year, price) VALUES ";
			s += " (' " + title + " ',' " + publisher + " ', ' " + year + " ' ,' " + price + " ') ";
			System.out.println(s);
			int i = stmt.executeUpdate(s);
			if (i == 1)
				System.out.println("���ڵ� �߰� ����");
			else
				System.out.println("���ڵ� �߰� ����");

		} catch (ClassNotFoundException e) {
			System.out.println("����̹��� ã�� �� �����ϴ�.");
		} catch (SQLException e) {
			System.out.println("���ῡ �����Ͽ����ϴ�.");
		}

	}

}
