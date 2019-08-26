package midtest1602100346;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;

public class Game2 {

	public static void main(String[] args) {
		MyPuzzle1 mp1 = new MyPuzzle1();
		mp1.display();
		// TODO Auto-generated method stub

	}

}

class MyPuzzle1 extends JFrame implements ActionListener {
	JButton abc;
	JMenu mEdit;
	JButton btn[];
	JPanel panel, panel2;
	JButton reset;
	Font myFont;
	Color mycolor;
	ImageIcon img[] = new ImageIcon[12];
	ImageIcon kk;
	
Image dd;
ImageIcon img_result = new ImageIcon("img_result.jpg");

JLabel label_result = new JLabel(img_result);
	MyPuzzle1() {
		for(int i=0;i<12;i++) {
		img[i] = new ImageIcon("img"+i+".png.jpg");

	
		}
		myFont = new Font("±¼¸²Ã¼", Font.BOLD, 30);
		panel = new JPanel(new GridLayout(4, 4));
		btn = new JButton[12];
		mycolor = new Color(255, 0, 127);
	      panel2 = new JPanel(new FlowLayout());

		

		for (int i = 0; i < 12; i++) {
			

			btn[i] = new JButton();
			btn[i].setFont(myFont);
			btn[i].setBackground(mycolor);
			btn[i].setForeground(Color.blue);
			if(i==11) {
				btn[11].setIcon(null);
			}else {
			Toolkit kit = Toolkit.getDefaultToolkit();
			dd=kit.getImage("img"+i+".png.jpg");
			int x=btn[i].getSize().width;
			int y=btn[i].getSize().height;
			dd.getScaledInstance(100,100,Image.SCALE_SMOOTH);
			kk= new ImageIcon(dd);
			   panel2.add(label_result);
			 
			
			btn[i].setIcon(kk);
			}
			
			
			//img[i] = new ImageIcon("img"+i+".png.jpg");
			btn[i].addActionListener(this);
			//btn[i].setIcon(img[i]);
			panel.add(btn[i]);
			

		}
		  abc = new JButton("Á¤´ä");
			abc.setFont(myFont);
			abc.setBackground(mycolor);
			abc.setForeground(Color.blue);
			

		  
		

		btn[11].setText("");
		reset = new JButton("Reset");
		reset.setFont(myFont);
		reset.setBackground(mycolor);
		reset.setForeground(Color.blue);
		reset.addActionListener(this);


	}
	
	

	void display() {
		setLayout(new BorderLayout(5, 5));
		
		add(panel, BorderLayout.CENTER);
		add(panel2, BorderLayout.EAST);
		add(reset, BorderLayout.SOUTH);
		
		setTitle("GAME");

		setSize(780, 430);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btn[8].getIcon()==null) {

			if (e.getSource() == btn[5]) {
				btn[8].setIcon(btn[5].getIcon());// 8
				btn[5].setIcon(null);

			}
			if (e.getSource() == btn[7]) {
				btn[8].setIcon(btn[7].getIcon());
				btn[7].setIcon(null);
			}
			if (e.getSource() == btn[11]) {
				btn[8].setIcon(btn[11].getIcon());
				btn[11].setIcon(null);
			}
			
		}
		if (btn[5].getIcon()==null) {
			if (e.getSource() == btn[4]) {
				btn[5].setIcon(btn[4].getIcon());// 5
				btn[4].setIcon(null);

			}
			if (e.getSource() == btn[2]) {
				btn[5].setIcon(btn[2].getIcon());//
				btn[2].setIcon(null);
			}
			if (e.getSource() == btn[8]) {
				btn[5].setIcon(btn[8].getIcon());
				btn[8].setIcon(null);
			}
		}
		if (btn[7].getIcon()==null) {
			if (e.getSource() == btn[4]) {
				btn[7].setIcon(btn[4].getIcon());// 7
				btn[4].setIcon(null);
			}
			if (e.getSource() == btn[6]) {
				btn[7].setIcon(btn[6].getIcon());
				btn[6].setIcon(null);
			}
			if (e.getSource() == btn[8]) {
				btn[7].setIcon(btn[8].getIcon());
				btn[8].setIcon(null);
			}
			if (e.getSource() == btn[10]) {
				btn[7].setIcon(btn[10].getIcon());
				btn[10].setIcon(null);
			}
		}

		if (btn[6].getIcon()==(null)) {
			if (e.getSource() == btn[3]) {
				btn[6].setIcon(btn[3].getIcon());// 6
				btn[3].setIcon(null);
			}
			if (e.getSource() == btn[7]) {
				btn[6].setIcon(btn[7].getIcon());
				btn[7].setIcon(null);
			}
			if (e.getSource() == btn[9]) {
				btn[6].setIcon(btn[9].getIcon());
				btn[9].setIcon(null);
			}
			
		}
		if (btn[3].getIcon()==(null)) {
			if (e.getSource() == btn[6]) {
				btn[3].setIcon(btn[6].getIcon());// 3
				btn[6].setIcon(null);
			}
			if (e.getSource() == btn[4]) {
				btn[3].setIcon(btn[4].getIcon());
				btn[4].setIcon(null);
			}
			if (e.getSource() == btn[0]) {
				btn[3].setIcon(btn[0].getIcon());
				btn[0].setIcon(null);
			}
		}
		if (btn[0].getIcon()==(null)) {
			if (e.getSource() == btn[3]) {
				btn[0].setIcon(btn[3].getIcon());// 0
				btn[3].setIcon(null);
			}
			if (e.getSource() == btn[1]) {
				btn[0].setIcon(btn[1].getIcon());
				btn[1].setIcon(null);
			}
		}
		if (btn[1].getIcon()==(null)) {
			if (e.getSource() == btn[0]) {
				btn[1].setIcon(btn[0].getIcon());// 1
				btn[0].setIcon(null);
			}
			if (e.getSource() == btn[4]) {
				btn[1].setIcon(btn[4].getIcon());
				btn[4].setIcon(null);
			}
			if (e.getSource() == btn[2]) {
				btn[1].setIcon(btn[2].getIcon());
				btn[2].setIcon(null);
			}
		}
		if (btn[4].getIcon()==(null)) {
			if (e.getSource() == btn[1]) {
				btn[4].setIcon(btn[1].getIcon());// 4
				btn[1].setIcon(null);
			}
			if (e.getSource() == btn[3]) {
				btn[4].setIcon(btn[3].getIcon());
				btn[3].setIcon(null);
			}
			if (e.getSource() == btn[5]) {
				btn[4].setIcon(btn[5].getIcon());
				btn[5].setIcon(null);
			}
			if (e.getSource() == btn[7]) {
				btn[4].setIcon(btn[7].getIcon());
				btn[7].setIcon(null);
			}
		}
		if (btn[2].getIcon()==(null)) {
			if (e.getSource() == btn[1]) {
				btn[2].setIcon(btn[1].getIcon());// 2
				btn[1].setIcon(null);
			}
			if (e.getSource() == btn[5]) {
				btn[2].setIcon(btn[5].getIcon());
				btn[5].setIcon(null);
			}

		}
		if (btn[9].getIcon()==(null)) {
			if (e.getSource() == btn[6]) {
				btn[9].setIcon(btn[6].getIcon());// 9
				btn[9].setIcon(null);
			}
			if (e.getSource() == btn[10]) {
				btn[9].setIcon(btn[10].getIcon());
				btn[10].setIcon(null);
			}
			if (e.getSource() == btn[6]) {
				btn[9].setIcon(btn[6].getIcon());
				btn[6].setIcon(null);
			}

		}
		if (btn[10].getIcon()==(null)) {
			if (e.getSource() == btn[6]) {
				btn[10].setIcon(btn[11].getIcon());// 10
				btn[10].setIcon(null);
			}
			if (e.getSource() == btn[7]) {
				btn[10].setIcon(btn[7].getIcon());
				btn[7].setIcon(null);
			}
			if (e.getSource() == btn[11]) {
				btn[10].setIcon(btn[11].getIcon());
				btn[11].setIcon(null);
			}
			if (e.getSource() == btn[9]) {
				btn[10].setIcon(btn[9].getIcon());
				btn[9].setIcon(null);
			}

		}
		if (btn[11].getIcon()==null) {
			if (e.getSource() == btn[10]) {
				btn[11].setIcon(btn[10].getIcon());// 11
				btn[11].setIcon(null);
			}
			if (e.getSource() == btn[10]) {
				btn[11].setIcon(btn[10].getIcon());
				btn[10].setIcon(null);
			}
			if (e.getSource() == btn[8]) {
				btn[11].setIcon(btn[8].getIcon());
				btn[8].setIcon(null);
			}
		
		
		
		
		}	
		
		
		
		
		if (e.getSource() == reset) {
			int u[] = MyPuzzle1.makeRnum();
			for (int i = 0; i < 11; i++) {
				btn[i].setIcon(img[u[i]]);
				btn[11].setIcon(null);
			}
	
			
			

		}

	}

	static int[] makeRnum() {
	
		Random r = new Random();
		int result[] = new int[11];
		int x = 0;
		for (int i = 0; i < 11; i++) {
			result[i] = r.nextInt(11);
			for (int k = 0; k < i; k++) {
				{
					if (result[i] == result[k]) {
						x = r.nextInt(11);
						result[i] = x;
						i--;
					
						break;

					}
				}
			}
		}
		return result;

	}

}
