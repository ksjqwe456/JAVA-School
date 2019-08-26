package mypjt01;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CLasss {

	public static void main(String[] args) {
		ConvertLenght1 cl = new ConvertLenght1();
		cl.display();
	}
}

class ConvertLenght1 extends JFrame implements ActionListener {
	JLabel num, result;
	JPanel p1, p2, p3;
	JTextField tf1, tf2;
	JButton btn;

	ConvertLenght1() {
		p1 = new JPanel(new GridLayout(1, 2));
		p2 = new JPanel(new GridLayout(1, 2));
		num = new JLabel("길이를 입력");
		result = new JLabel("RESULT");
		btn = new JButton("BUTTON");
		tf1 = new JTextField();
		tf2 = new JTextField();
		num.setForeground(Color.white);
		result.setForeground(Color.black);
		p1.setBackground(Color.RED);
		p2.setBackground(Color.yellow);
		p1.add(num);
		p1.add(tf1);
		p2.add(result);
		p2.add(tf2);
		btn.addActionListener(this);
		add(p1);
		add(p2);
		add(btn);
	}

	void display() {
		setLayout(new FlowLayout());
		setSize(250, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("거리계산하기");
	}

	
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btn) {

			tf2.setText("" + Double.parseDouble(tf1.getText()) / 2.54);

		}
	}
}