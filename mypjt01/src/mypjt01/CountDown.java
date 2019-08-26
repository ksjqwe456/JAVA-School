package mypjt01;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountDown {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MycountDown1 mf = new MycountDown1();
		mf.display();

	}

}

class MycountDown1 extends JFrame {
	JLabel count;

	MycountDown1() {
		count = new JLabel("START");
		count.setFont(new Font("±Ã¼­", Font.BOLD, 50));
		add(count);
	}

	void display() {
		setLayout(new FlowLayout());
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread t1 = new Thread(new TimerCount());
		t1.start();
	}

	class TimerCount implements Runnable {
		public void run() {

			while (true) {
				GregorianCalendar gc = new GregorianCalendar();
				try {
					Thread.sleep(1000);
					int sec = gc.get(gc.SECOND);
					int min = gc.get(gc.MINUTE);
					int Hour = gc.get(gc.HOUR);

					count.setText(Hour + "-" + min + "-" + sec);
				} catch (InterruptedException ir) {

				}
			}

		}
	}
}
