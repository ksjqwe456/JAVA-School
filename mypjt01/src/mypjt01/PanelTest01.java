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
	JButton btn;// ��ư
	JLabel lb;//
	JTextField tf;// �ؽ�Ʈ �ʵ�(���� �ۻ���)
	JTextArea ta;// ������ �ۻ���
	JCheckBox ch1, ch2;// üũ�ڽ�
	JRadioButton r1, r2;// ���׶�� üũ �ڽ�
	ButtonGroup group;// ���ϼ����� �����ϵ��� ���� �׷�
	JList<String> lst;
	String items[] = { "���", "�ٳ���", "����", "���", "���ξ���" };
	Integer count[] = { 5, 2, 1, 10, 7 };
	JComboBox<Integer> combo;

	// JPanel p1,P2;//1)�гμ���
	// JButton btn1,btn2,btn3,btn4;
	MyPanel() // ������
	{
		btn = new JButton("���������ư");
		add(btn);
		lb = new JLabel("���� ��ĥ�� �����ϴ�");
		add(lb);
		tf = new JTextField("���� ���� �ۻ���", 20);
		add(tf);
		ta = new JTextArea("���� ������ �ۻ���", 10, 20);
		add(ta);
		ch1 = new JCheckBox("�ڹ�");
		add(ch1);
		ch2 = new JCheckBox("�ȵ���̵�");
		add(ch2);
		r1 = new JRadioButton("����");
		add(r1);
		r2 = new JRadioButton("����");
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
		setTitle("�г����� ��ư�ִ�");
	}
}
