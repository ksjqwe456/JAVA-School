package TEST01;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pra0823 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pra p1 = new pra();
		p1.display();
	}

}

class pra extends JFrame implements ActionListener{
	JButton btn[];
	JPanel panel;
	JTextField jf;
	String cl;

	pra() {
		panel = new JPanel(new GridLayout(4,4));
		btn = new JButton[12];
		jf = new JTextField(20);
		add(jf);
		
		for (int i = 0; i < 10; i++) {
			btn[i] = new JButton("" + i);
			panel.add(btn[i]);
			btn[i].addActionListener(this);
		}
		btn[10] = new JButton("=");
		panel.add(btn[10]);
		btn[10].addActionListener(this);
		btn[11] = new JButton("���찳");
		panel.add(btn[11]);
		btn[11].addActionListener(this);
	
		

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
		// TODO Auto-generated method stub
		if(e.getSource()==btn[11]) {
	
		}
		
	}
}