package mypjt01;

import java.util.Random;

import javax.swing.JFrame;

public class Sam0530 {

	public static void main(String[] args) {
		MyFrame001 mf1 = new MyFrame001();
		mf1.display();

	}

}

class MyFrame001 extends JFrame implements Runnable

{
	Thread t1;

	MyFrame001() {
		t1 = new Thread(this);
		t1.start();

	}

	void display() {
		setTitle("멀미나는 프레임");
		setSize(300, 300);
		setLocation(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void run() {
		Random r = new Random();
		while (true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException ie) {

			}

			int x = getX() + r.nextInt() % 30;
			int y = getY() + r.nextInt() % 30;

			setLocation(x, y);

		}
	}
}
