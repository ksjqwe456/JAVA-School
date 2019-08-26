package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class intro1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		intro01 it = new intro01();
		it.makeMenu();
		it.display();
		

	}
}

class intro01 extends JFrame implements ActionListener {
	

	JPanel p1;
	JButton btn1, btn2;
	ImageIcon img, img1;
	JLabel tt;
	JMenuBar mb;
	JMenu gmenu;
	JMenuItem Board, Restart, Level, Help;

	intro01() {
	


		setLayout(null);

		p1 = new JPanel();
		p1.setOpaque(false);
		// getContentPane().setBackground(Color.BLACK);
		// img = new ImageIcon("src/btn15.png");

		tt = new JLabel(" Project ");
		// setBackground(Color.BLACK);
		p1.setSize(550, 510);

		btn1 = new JButton("start");
		btn1.addActionListener(this);
		btn2 = new JButton("Cancel");
		btn2.addActionListener(this);
		btn1.setSize(150, 40);
		btn2.setSize(150, 40);
		btn1.setBounds(200, 230, 160, 85);
		btn2.setBounds(200, 330, 160, 85);

		btn1.setIcon(img);
		btn2.setIcon(img);
		// btn1.set("btn1.jpg");

		add(p1);

		add(btn1);
		add(btn2);
		p1.add(tt);
		tt.setFont(new Font("Serif", Font.BOLD, 70));
		tt.setForeground(Color.BLACK);
		tt.setHorizontalAlignment(SwingConstants.CENTER);
		mb = new JMenuBar();
		p1 = new JPanel();
		gmenu = new JMenu("�޴�");
		Board = new JMenuItem("��������");
		Board.addActionListener(this);
		//Restart = new JMenuItem("RESTART");
		//Level = new JMenuItem("���̵�");
		Help = new JMenuItem("����");
		Help.addActionListener(this);

	}

	void makeMenu()// �޴����� �ٿ� �ִ� �۾�����
	{
		mb.add(gmenu);
		add(p1);
		// �޴��ٿ� �޴��� �߰��Ѵ�
		gmenu.add(Board);
		//gmenu.add(Restart);
		//gmenu.add(Level);
		gmenu.add(Help);
		setJMenuBar(mb);
	}

	void display() {

		// setBackground(Color.CYAN);
		setTitle("intro");
		// setBackground();
		setSize(570, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btn1) {

			ddd ff = new ddd();
			ff.display();
			dispose();

		}
		if (e.getSource() == btn2) {
			dispose();

		}

		// TODO Auto-generated method stub
		if (e.getSource() == Board) {

			MyBoard zl = new MyBoard();
		}

		if (e.getSource() == Help) {
			
			Myhp hp = new Myhp();
		}
		
		
			
/*			JLabel abc;
			JButton hd;
			abc = new JLabel("<html>����Ű<br/>w-��<br/>s-�� <br/> a-��<br/> d ��  </html>");
			hd = new JButton("�ݱ�");

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
			});*/

			// invalidate();

		}

	}

	class Recordf {
		String a;
		int b;

		Recordf(String a, int b) {
			this.a = a;
			this.b = b;

		}
	}

	class MyBoard extends JDialog {
		textIOE G2 = new textIOE();
		JLabel scores;
		public JLabel fir, sec, thir, four, five,sco;
		public JPanel panel;
		public JPanel panel1, panel2;
		

		textIOE nums1;
		Recordf recordR[];

		MyBoard() {
			nums1 = new textIOE();
			
			panel = new JPanel(new GridLayout(6, 2));// �����г�

			panel1 = new JPanel(new FlowLayout());//
			panel2 = new JPanel(new FlowLayout());
//		panel.setBorde                                         r(Color.black);
			fir = new JLabel();
			fir.setText(G2.nums[0].a + " : " + G2.nums[0].b);
			fir.setFont(new Font("Serif", Font.BOLD, 20));

			sec = new JLabel(G2.nums[1].a + ":" + G2.nums[1].b);
			sec.setFont(new Font("Serif", Font.BOLD, 20));
			thir = new JLabel(G2.nums[2].a + ":" + G2.nums[2].b);
			thir.setFont(new Font("Serif", Font.BOLD, 20));
			four = new JLabel(G2.nums[3].a + ":" + G2.nums[3].b);
			four.setFont(new Font("Serif", Font.BOLD, 20));
			five = new JLabel(G2.nums[4].a + ":" + G2.nums[4].b);
			five.setFont(new Font("Serif", Font.BOLD, 20));
			sco = new JLabel("����");
			sco.setFont(new Font("Serif", Font.CENTER_BASELINE, 40));

			panel.add(sco);
			panel.add(fir);
			panel.add(sec);
			panel.add(thir);
			panel.add(four);
			panel.add(five);
			add(panel);
			
		

			 
						

			// nums1.asd();

			// int dad= recordR[0].b;

			// Recordf[] a = nums1.nums2;

			// String to = Integer.toString(a[0].b);

			// scores = new JLabel(recordR[0].a+":"+ recordR[0].b);

			setLayout(new FlowLayout());
			setVisible(true);
			setSize(400, 400);
			setTitle("RECORD");
			setResizable(false);
			setLocationRelativeTo(null);
			
		


			
		}

	}
	class Myhp extends JDialog{
		JLabel q,w,e,r,t,y,u,i,o,p;
		JPanel h;
		Myhp(){
			h= new JPanel(new GridLayout(10,2));
			q = new JLabel("����");
			q.setFont(new Font("Serif", Font.CENTER_BASELINE, 40));		
			w = new JLabel("w-��");
			e = new JLabel("a-��");
			r = new JLabel("s-��");
			t = new JLabel("d ��");
			y= new JLabel("������ ���");
			u=new JLabel("HP:�� ȸ��");
			i=new JLabel("����:�Ѿ��� �ѹ��� 3�� �߻�");
			o=new JLabel("�����:�Ѿ��� ���� ������ �߻�");
			p=new JLabel("����:���� �ѹ濡 ����");
			
			
			
			
			
			
			h.add(q);
			h.add(w);
			h.add(e);
			h.add(r);
			h.add(t);
			h.add(y);
			h.add(u);
			h.add(i);
			h.add(o);
			h.add(p);
			
			add(h);
			
			
			
			
			
			
			
			
			setLayout(new FlowLayout());
			setVisible(true);
			setSize(400, 600);
			setTitle("RECORD");
			setResizable(false);
			setLocationRelativeTo(null);
		
		}
	}

