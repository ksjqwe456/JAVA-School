package project;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class test1 {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		test01 me = new test01();
		me.display();
		me.makeMenu();

	}

}

class test01 extends JFrame implements ActionListener {
	JPanel p1;
	JMenuBar mb;
	JMenu gmenu;
	JMenuItem Board, Restart, Level, Help;

	test01() {
		mb = new JMenuBar();
		p1 = new JPanel();
		gmenu = new JMenu("메뉴");
		Board = new JMenuItem("리더보드");
		Board.addActionListener(this);
		Restart = new JMenuItem("RESTART");
		Level = new JMenuItem("난이도");
		Help = new JMenuItem("도움말");
		Help.addActionListener(this);
	}

	void makeMenu()// 메뉴들을 붙여 넣는 작업정의
	{
		mb.add(gmenu);
		add(p1);
		// 메뉴바에 메뉴를 추가한다
		gmenu.add(Board);
		gmenu.add(Restart);
		gmenu.add(Level);
		gmenu.add(Help);
		setJMenuBar(mb);
	}

	void display() {
		setTitle("GAME");
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == Board) {

			MyBoard zl = new MyBoard();
		}

		if (e.getSource() == Help) {
		
			JLabel abc;
			JButton hd;
			abc = new JLabel("<html>단축키<br/>w-↑<br/>s-↓ <br/> a-←<br/> d →  </html>");
			hd = new JButton("닫기");

			p1.add(abc);
			p1.add(hd);
			hd.setBounds(200, 230, 50, 50);
			setVisible(true);
			hd.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					abc.setVisible(false);
					hd.setVisible(false);

				}
			});

			// invalidate();

		}

	}

	class Recordf  {
		String a;
		int b;
		
		Recordf(String a,int b)
		{
			this.a=a;
			this.b=b;
			
		}
	}
	
	
	
	
	class MyBoard extends JDialog {
		textIOE G2=new textIOE();
		JLabel scores;
		public JLabel fir,sec,thir,four,five;
		public JPanel panel;
		public JPanel panel1,panel2;
		
		

		textIOE nums1;
		Recordf recordR[];
		
		
		MyBoard() {
			nums1 = new textIOE();
		
		panel = new JPanel(new GridLayout(5, 2));//점수패널
		panel1 = new JPanel(new FlowLayout());//
		panel2 = new JPanel(new FlowLayout());
//		panel.setBorde                                         r(Color.black);
		fir = new JLabel();
		fir.setText(G2.nums[0].a + " : " + G2.nums[0].b);
		
		sec = new JLabel(G2.nums[1].a+":"+G2.nums[1].b);
		thir = new JLabel(G2.nums[2].a+":"+G2.nums[2].b);
		four = new JLabel(G2.nums[3].a+":"+G2.nums[3].b);
		five =new JLabel(G2.nums[4].a+":"+G2.nums[4].b);
		
		panel.add(fir);
		panel.add(sec);
		panel.add(thir);
		panel.add(four);
		panel.add(five);
		add(panel);
		panel.add(panel1);
		panel.add(panel2);
		//nums1.asd();
		
			//int dad= recordR[0].b;
			
			//Recordf[] a = nums1.nums2;
			
			//String to = Integer.toString(a[0].b);
			 
				
			//scores = new JLabel(recordR[0].a+":"+ recordR[0].b);

			
			setLayout(new FlowLayout());
			setVisible(true);
			setSize(300, 300);
			setTitle("RECORD");
			 
		

	}
		
	}
}
