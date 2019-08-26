package DatabastTest;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JDBCFrame01 {

	public static void main(String[] args) throws SQLException {
		JDBCForm jf = new JDBCForm();

		jf.display();

	}

}

class JDBCForm extends JFrame implements ActionListener {
	// JTextField id, title, p, year, price, author;
	JLabel lb[]; // 레이블 이름
	JTextField tf[];
//	JButton previousButton, nextButton, InsertButton, deleteButton,
//			searchButton;
	JPanel p1, p2;
	JButton btn[];
	ResultSet rs;
	Statement stmt;

	JDBCForm() {
		tf = new JTextField[5];

		lb = new JLabel[5];
		p1 = new JPanel(new GridLayout(5, 2));
		p2 = new JPanel(new GridLayout(1, 0));
		for (int i = 0; i < 5; i++) {
			lb[i] = new JLabel("" + i);
			tf[i] = new JTextField();
			tf[i].setHorizontalAlignment(4); // 오른쪽정렬
			p1.add(lb[i]);
			p1.add(tf[i]);
		}
		lb[0].setText("ID");
		lb[1].setText("Title");
		lb[2].setText("puplisher");
		lb[3].setText("Year");
		lb[4].setText("Price");

		btn = new JButton[4];

		for (int i = 0; i < 4; i++) {
			btn[i] = new JButton("" + i);
			btn[i].addActionListener(this);
			p2.add(btn[i]);
		}

		btn[0].setText("Pre");
		btn[1].setText("Next");
		btn[2].setText("First");
		btn[3].setText("Last");

		try {
		dbConn();
		}
		catch(SQLException se)
		{
			
		}
	}

	void display() {
		setLayout(new BorderLayout(10, 10));
		add(BorderLayout.CENTER, p1);
		add(BorderLayout.SOUTH, p2);
		setSize(400, 300);
		setVisible(true);
		setTitle("내가만든 JDBC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void dbConn() throws SQLException {

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버연결
			String url = "jdbc:mysql://localhost:3306/book_db?serverTimezone=Asia/Seoul"; // DB연결
			System.out.println("드라이버 적재 성공");
			con = DriverManager.getConnection(url, "root", "1234");
			System.out.println("데이터베이스 연결 성공");
			// statement 문장수행
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM books");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("연결에 실패하였습니다.");
		}

	}

	public void actionPerformed(ActionEvent e) {
		
		//btn[0].setEnabled(false);
		
		if (e.getSource() == btn[0]) {
			try {

				if(rs.previous()) {
				tf[0].setText("" + rs.getInt("book_id"));
				tf[1].setText("" + rs.getString("title"));
				tf[2].setText("" + rs.getString("publisher"));
				tf[3].setText("" + rs.getString("year"));
				tf[4].setText("" + rs.getString("price"));
				}

			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		if (e.getSource() == btn[1]) {
			try {

				if(rs.next()) {
				tf[0].setText("" + rs.getInt("book_id"));
				tf[1].setText("" + rs.getString("title"));
				tf[2].setText("" + rs.getString("publisher"));
				tf[3].setText("" + rs.getString("year"));
				tf[4].setText("" + rs.getString("price"));
				}

			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		////////// 맨처음 레코드
		if (e.getSource() == btn[2]) {
			try {

				if(rs.first()) {
				tf[0].setText("" + rs.getInt("book_id"));
				tf[1].setText("" + rs.getString("title"));
				tf[2].setText("" + rs.getString("publisher"));
				tf[3].setText("" + rs.getString("year"));
				tf[4].setText("" + rs.getString("price"));
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		//////////////// 맨 마지막
		if (e.getSource() == btn[3]) {
			try {

				if(rs.last()) {
				tf[0].setText("" + rs.getInt("book_id"));
				tf[1].setText("" + rs.getString("title"));
				tf[2].setText("" + rs.getString("publisher"));
				tf[3].setText("" + rs.getString("year"));
				tf[4].setText("" + rs.getString("price"));
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}


	}
}
