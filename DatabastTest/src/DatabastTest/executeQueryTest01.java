package DatabastTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class executeQueryTest01 {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // ����̹�����
			String url = "jdbc:mysql://localhost:3306/book_db?serverTimezone=Asia/Seoul"; // DB����
			System.out.println("����̹� ���� ����");
			con = DriverManager.getConnection(url, "root", "1234");
			System.out.println("�����ͺ��̽� ���� ����");
			// statement �������
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM books");
			while (rs.next()) { // �������ڵ�� �̵�
				int id = rs.getInt("book_id"); // �ʵ尪�� �����´�
				String title = rs.getString("title");
				String publisher = rs.getString("publisher");// �ʵ尪�� �����´�
				System.out.println(id + " " + title+""+publisher);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("����̹��� ã�� �� �����ϴ�.");
		} catch (SQLException e) {
			System.out.println("���ῡ �����Ͽ����ϴ�.");
		}
	}
}
