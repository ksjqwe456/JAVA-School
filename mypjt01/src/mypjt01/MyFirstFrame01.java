package mypjt01;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFirstFrame01 {

	public static void main(String[] args) {

		MyFrame1 mf = new MyFrame1();
		mf.display();
	}
}

class MyFrame1 extends JFrame {
	JButton btn, btn2, btn3, btn4,btn5;// 버튼 선언

	MyFrame1() {
		super("asdg");
		btn = new JButton();
		btn.setText("나버튼1");
		btn2 = new JButton("내가만든버트2");
		btn3 = new JButton("내가만든버트3");
		btn4 = new JButton("내가만든버트4");
		btn5 = new JButton("내가만든버트5");

		add(btn);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
	}

	void display() {

		setLayout(new FlowLayout());
/*		add(BorderLayout.EAST, btn);
		add(BorderLayout.WEST, btn2);
		add(BorderLayout.NORTH, btn3);
		add(BorderLayout.CENTER, btn4);
		add(BorderLayout.SOUTH, btn5);*/
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
