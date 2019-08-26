package mypjt01;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelTest01 {
	public static void main(String[] args) {
		MyPanel mp = new MyPanel();
		mp.display();
	}
}

class MyPanel extends JFrame {
	JButton btn;// 버튼
	JLabel lb;//
	JTextField tf;// 텍스트 필드(한줄 글상자)
	JTextArea ta;// 여러줄 글상자
	JCheckBox ch1, ch2;// 체크박스
	JRadioButton r1, r2;// 동그라미 체크 박스
	ButtonGroup group;// 단일선택이 가능하도록 만든 그룹
	JList<String> lst;
	String items[] = { "사과", "바나나", "딸기", "멜론", "파인애플" };
	Integer count[] = { 5, 2, 1, 10, 7 };
	JComboBox<Integer> combo;

	// JPanel p1,P2;//1)패널선언
	// JButton btn1,btn2,btn3,btn4;
	MyPanel() // 생성자
	{
		btn = new JButton("내가만든버튼");
		add(btn);
		lb = new JLabel("나는 고칠수 없습니다");
		add(lb);
		tf = new JTextField("나는 한줄 글상자", 20);
		add(tf);
		ta = new JTextArea("나는 여러줄 글상자", 10, 20);
		add(ta);
		ch1 = new JCheckBox("자바");
		add(ch1);
		ch2 = new JCheckBox("안드로이드");
		add(ch2);
		r1 = new JRadioButton("남자");
		add(r1);
		r2 = new JRadioButton("여자");
		group = new ButtonGroup();
		group.add(r1);
		group.add(r2);
		lst = new JList<>(items);
		add(lst);
		combo = new JComboBox<>(count);
		add(combo);

		/*
		 * btns = new JButton[10]; for(int i=0;i<10;i++) { btns[i] = new JButton(i+"");
		 * add(btns[i]);
		 * 
		 * }
		 */
		// JPanel p1,p2;
		// JButton btn1,btn2,btn3,btn4;
		// MyPanel()
		// {
		// Toolkit kit = Toolkit.getDefaultToolkit();
		// Dimension screenSize = kit.getScreenSize();
		// setLocation(screenSize.width /2,screenSize.height/2);
		// Image img = kit.getImage("myimg.jpg");
		// setIconImage(img);
		//
		//
		// p1 = new JPanel();
		// p2 = new JPanel();
		// p1.setBackground(Color.YELLOW);
		// p2.setBackground(Color.RED);
		//
		//
		// btn1= new JButton("Button1");
		// btn2= new JButton("Button2");
		// p1.add(btn1);p1.add(btn2);
		// btn3= new JButton("Button3");
		// btn4= new JButton("Button4");
		// p2.add(btn4);p2.add(btn3);
		// add(p1);add(p2);
	}

	void display() {
		setLayout(new FlowLayout());
		setResizable(false);
		setSize(280, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("패널위에 버튼있다");
	}
}
