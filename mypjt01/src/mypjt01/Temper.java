package mypjt01;

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

public class Temper {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      ConvertLenght1 cl = new ConvertLenght1();
      cl.display();
   }

}

class ConvertLenght1 extends JFrame implements ActionListener
{
   JLabel num,result,aa;
   JPanel p1,p2,p3;
   JTextField tf1, tf2;
   JButton btn;
   JComboBox<String> combo;
   String unit[] = {"cm","inch"};
   ConvertLenght1()
   {
      p1 = new JPanel(new GridLayout(1,2));
      p2 = new JPanel(new GridLayout(1,2));
      num = new JLabel("길이를 입력");
      result = new JLabel("선택한 길이 출력");
      btn = new JButton("변환");
      tf1 = new JTextField();
      tf2 = new JTextField();
      combo = new JComboBox<>(unit);
      aa = new JLabel("cm -> inch , inch -> cm");
      
      
      num.setForeground(Color.white);
      result.setForeground(Color.black);
      p1.setBackground(Color.gray);
      p2.setBackground(Color.yellow);   
      p1.add(num);
      p1.add(tf1);
      p2.add(result);
      p2.add(tf2);
      btn.addActionListener(this);
      
      
      add(combo);
      add(p1);
      add(p2);
      add(btn);
      add(aa);
   }
   
   
   void display()
   {
      setLayout(new FlowLayout());
      setSize(250,200);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("거리계산하기");
   }


   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      if(e.getSource() == btn)
      {
         if(combo.getSelectedItem().equals("inch"))
            tf2.setText(""+String.format("%.3f",Double.parseDouble(tf1.getText())*2.54));
         if(combo.getSelectedItem().equals("cm"))
            tf2.setText(""+String.format("%.3f",Double.parseDouble(tf1.getText())*0.39));
      }
   }
}

