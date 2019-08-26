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
	String op1 = "", op2 = "";// �ؽ�Ʈ �ʵ忡 ���� �ǿ�����
	String operator;// +-*/
	float x, y, z;// ������ ���Ѻ���
	Font f;

	Calc() {
		tf = new JTextField(30);
		tf.setHorizontalAlignment(4);
		add(tf);
		panel = new JPanel(new GridLayout(4, 4));
		btn = new JButton[12];// 0~9,=,clear
		opBtn = new JButton[4];// +-*/
		Font f = new Font("�ü�ü",Font.ITALIC,20);
		
			
				
		tf.setFont(f);


		for (int i = 0; i < 10; i++) {
			btn[i] = new JButton("" + i);
			btn[i].addActionListener(this);
			panel.add(btn[i]);// �гο� ��ư �߰�

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
		setTitle("����");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btn[11])// clear ��ư
		{
			op1 = "";
			tf.setText(op1);

		}
		for (int i = 0; i < 10; i++)// 0~9��ư
		{
			if (e.getSource() == btn[i]) {

				op1 += e.getActionCommand();
				tf.setText(op1);
			}
		}
		if ((e.getActionCommand() == "+") | (e.getActionCommand() == "-") | (e.getActionCommand() == "*")
				| (e.getActionCommand() == "/")) {
			operator = e.getActionCommand();
			op2 = op1;// ù��° �ǿ����ڸ� op2 �� �̵��Ѵ�
			op1 = "";
			x = Float.parseFloat(op2);// ù��° �ǿ����ڰ� ��������

		}
		if(e.getActionCommand()=="=") {
			
			y=Float.parseFloat(op1); //�ι�° �ǿ����� ��������
			tf.setText(""+oper(operator,x,y));//�����ϴ� �Լ� ȣ��
			
			
			
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
