package mypjt01;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EventTest01 {

	public static void main(String[] args) {
		MyEvent01 me = new MyEvent01();
		me.display();

	}
}

class MyEvent01 extends JFrame {
	JButton close;
	JPanel p;
	
	JButton r;
	JButton Y;
	JTextArea ta;
	JButton clear;
	JTextField tf;
	JCheckBox ch[];
	JRadioButton gender[];
	ButtonGroup group;
	JComboBox<String> combo;
	String fruit[] = { "바나나", "포도", "복숭아", "토마토", "참외" };

	MyEvent01() {
		close = new JButton("close");
		close.addActionListener(new ActionH());
		add(close);

		p = new JPanel();
		p.setBackground(Color.BLUE);
		p.add(close);
		r = new JButton("PINK");
		p.add(r);
		r.addActionListener(new ActionP());
		Y = new JButton("YELLOW");
		Y.addActionListener(new ActionY());
		clear = new JButton("Clear");
		p.add(clear);
		ta = new JTextArea(10, 40);
		p.add(Y);
		p.add(ta);
		clear.addActionListener(new Actionta());
		tf = new JTextField(40);
		p.add(tf);
		tf.addActionListener(new Actiontf());
		ch = new JCheckBox[5];


		for (int i = 0; i < ch.length; i++) {
			ch[i] = new JCheckBox("" + (i + 1) + "번");
			p.add(ch[i]);

		}
		gender = new JRadioButton[3];
		group = new ButtonGroup();
		for (int i = 0; i < gender.length; i++) {
			gender[i] = new JRadioButton();
			gender[i].addActionListener(new Actionge());
			group.add(gender[i]);
			p.add(gender[i]);
		}
		gender[0].setText("male");
		gender[1].setText("female");
		gender[2].setText("other");
		combo = new JComboBox<>(fruit);
		p.add(combo);
		combo.addActionListener(new Actionfr());

	}

	public void display() {
		// setLayout(new FlowLayout());

		add(p);
		setSize(500, 500);
		setTitle("재미있는 이벤트");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class ActionY implements ActionListener {

		public void actionPerformed(ActionEvent a) {
			p.setBackground(Color.YELLOW);
		}
	}

	class ActionP implements ActionListener {

		public void actionPerformed(ActionEvent a) {
			p.setBackground(Color.PINK);
		}
	}

	class ActionH implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			System.exit(0);
		}

	}

	class Actionta implements ActionListener {

		public void actionPerformed(ActionEvent o) {
			// TODO Auto-generated method stub
			ta.setText("");
		}
	}

	class Actiontf implements ActionListener {

		public void actionPerformed(ActionEvent o) {

			ta.setText(tf.getText() + "\n");

		}
	}

	class Actionfr implements ActionListener {

		public void actionPerformed(ActionEvent o) {
			ta.append((String) combo.getSelectedItem());

		}

	}

	class Actionge implements ActionListener {

		public void actionPerformed(ActionEvent o) {

			for (int i = 0; i < gender.length; i++) {
				if (o.getSource() == gender[i]) {
					ta.append(gender[i].getText() + "선택\n");
				}

			}

		}
	}
}
