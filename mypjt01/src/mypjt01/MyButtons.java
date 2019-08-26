package mypjt01;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyButtons {

	public static void main(String[] args) {
		Buttons btns = new Buttons();
		btns.display();

	}
}

class Buttons extends JFrame {
	JButton bts[];

	Buttons() {
		bts = new JButton[10];
		for (int i = 0; i < 10; i++) {
			bts[i] = new JButton("" + i);
			add(bts[i]);
		}

	}

	
		void display() {
			setLayout(new GridLayout(2,5,1,40));
			setSize(300, 300);
			setVisible(true);
			setTitle("내가 만든 버튼들");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}
}