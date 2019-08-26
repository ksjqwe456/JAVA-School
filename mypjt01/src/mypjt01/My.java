package mypjt01;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class My {

	public static void main(String[] args) {
		Dotprint as = new Dotprint();
		as.display();

	}

}

class Dotprint extends JFrame {
	JLabel num[];

	Dotprint() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screensize = kit.getScreenSize();

		int x = screensize.width;
		int y = screensize.height;
		// setSize(x/2,y/2);
		Dimension dim = new Dimension(x / 2, y / 2);
		setPreferredSize(dim);
		pack();

		// num = new JLabel(""+rt);
		num = new JLabel[100];
		for (int i = 0; i < 100; i++) {
			int rx = (int) (Math.random() * (x / 2));
			int ry = (int) (Math.random() * (y / 2));

			num[i] = new JLabel("" + ((int) (Math.random() * 100) + 1));
			num[i].setLocation(rx, ry);
			num[i].setSize(100, 20);
			num[i].setForeground(Color.GREEN);
			getContentPane().setBackground(Color.yellow);
			add(num[i]);

		}

	}

	void display() {
		setLayout(null);
		setTitle("점을보자");
		// setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
