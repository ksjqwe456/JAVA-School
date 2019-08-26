package mypjt01;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyCalcTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calc c1 = new Calc();
		c1.display();
	}

}

class Calc extends JFrame implements ActionListener {
	JButton btn[];
	JTextField tf;
	JPanel panel;
	JButton opBtn[];
	String op1 = "", op2 = "";// 텍스트 필드에 보일 피연산자
	String operator;// +-*/
	float x, y, z;// 연산을 위한변수
	Font f;

	Calc() {
		tf = new JTextField(30);
		tf.setHorizontalAlignment(4);
		add(tf);
		panel = new JPanel(new GridLayout(4, 4));
		btn = new JButton[12];// 0~9,=,clear
		opBtn = new JButton[4];// +-*/
		Font f = new Font("궁서체",Font.ITALIC,20);
		
			
				
		tf.setFont(f);


		for (int i = 0; i < 10; i++) {
			btn[i] = new JButton("" + i);
			btn[i].addActionListener(this);
			panel.add(btn[i]);// 패널에 버튼 추가

		}
		btn[10] = new JButton("=");
		
		btn[10].addActionListener(this);
		panel.add(btn[10]);
		btn[11] = new JButton("clear");
		btn[11].addActionListener(this);
		panel.add(btn[11]);
		opBtn[0] = new JButton("+");
		opBtn[1] = new JButton("-");
		opBtn[3] = new JButton("/");
		opBtn[2] = new JButton("*");
		for (int i = 0; i < 4; i++)

		{
			opBtn[i].addActionListener(this);
			panel.add(opBtn[i]);

		}

	}

	void display() {
		setLayout(new FlowLayout());
		add(panel);
		setSize(400, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("계산기");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btn[11])// clear 버튼
		{
			op1 = "";
			tf.setText(op1);

		}
		for (int i = 0; i < 10; i++)// 0~9버튼
		{
			if (e.getSource() == btn[i]) {

				op1 += e.getActionCommand();
				tf.setText(op1);
			}
		}
		if ((e.getActionCommand() == "+") | (e.getActionCommand() == "-") | (e.getActionCommand() == "*")
				| (e.getActionCommand() == "/")) {
			operator = e.getActionCommand();
			op2 = op1;// 첫번째 피연산자를 op2 ㅗ 이동한다
			op1 = "";
			x = Float.parseFloat(op2);// 첫번째 피연산자가 가능해짐

		}
		if(e.getActionCommand()=="=") {
			
			y=Float.parseFloat(op1); //두번째 피연산자 가능해짐
			tf.setText(""+oper(operator,x,y));//연산하는 함수 호출
			
			
			
		}
	}
	public float oper(String operator,float i , float y)
	{
		if(operator.equals("+"))
			z=x+y;
		
		else if(operator.equals("-"))
		{
			z=x-y;
			
		}
		else if(operator.equals("*"))
			{z=x*y;}
		else if(operator.equals("/"))
		{
			z=x/y;
		}
		
			
	
			return z;
		
	}
}
