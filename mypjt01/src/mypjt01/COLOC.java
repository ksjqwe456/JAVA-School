package mypjt01;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class COLOC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
PizzaPanel pp = new PizzaPanel();
pp.display();

	}
	
}

class PizzaPanel extends JFrame
{
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JLabel lb ,ob;
	JTextField tf;
	JPanel p1,p2;
	
	
	PizzaPanel()
	{
		lb = new JLabel("자바 피자에 오신것을 환영합니다. 피자의 종류를 선택하세요");
		add(lb);
		btn1 = new JButton("1번 피자");
		add(btn1);
		
		btn2 = new JButton("2번 피자");
		add(btn2);
		
		btn3 = new JButton("3번 피자");
		add(btn3);
		ob = new JLabel("개수");
		add(ob);
	
		tf = new JTextField("", 10);
		add(tf);

		p1.add(lb);
		p2.add(btn1);
		p2.add(btn2);
		p2.add(btn3);
		p2.add(ob);
		add(p1);
		add(p2);
		
		
		
		


	}
	
	void display() {
		setLayout(new FlowLayout());
		setSize(300, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PIZZA SCHOOL");
		}
}


