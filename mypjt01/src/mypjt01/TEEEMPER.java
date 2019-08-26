package mypjt01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TEEEMPER {

   public static void main(String[] args) {
      changeTemperature1 ct = new changeTemperature1();
      ct.display();
   }
}

class changeTemperature1 extends JFrame implements ActionListener, KeyListener
{
   JPanel p1, p2, p3, p4, pa;;
   JLabel l1, l2, l3;
   JTextField tf1, tf2, tf3;
   JButton bt1, bt2;
   
   changeTemperature1()
   {
      pa = new JPanel(new GridLayout(4,2));
      p1 = new JPanel(new GridLayout(1,1));
      p2 = new JPanel(new GridLayout(1,1));
      p3 = new JPanel(new GridLayout(1,1));
      p4 = new JPanel(new GridLayout(1,1));
      
      l1 = new JLabel("¼·¾¾¿Âµµ");
      l2 = new JLabel("È­¾¾¿Âµµ");
      l3 = new JLabel("Àý´ë¿Âµµ");
      
      tf1 = new JTextField(7);
      tf2 = new JTextField(7);
      tf3 = new JTextField(7);
      
      bt1 = new JButton("ÃÊ±âÈ­");
      bt2 = new JButton("´Ý±â");
      
      tf1.addActionListener(this);
      tf1.addKeyListener(this);
      
      bt1.addActionListener(this);
      bt2.addActionListener(this);
      
      pa.add(p1); pa.add(p2); pa.add(p3); pa.add(p4);
      p1.add(l1);   p1.add(tf1);
      p2.add(l2); p2.add(tf2);
      p3.add(l3); p3.add(tf3);
      p4.add(bt1); p4.add(bt2);
      
      add(pa);
//      add(p1); add(p2); add(p3); add(p4);
      
   }
   void display()
   {
      setLayout(new FlowLayout());
      setSize(250, 250);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("¼·¾¾ È­¾¾ º¯È¯");
   }
   
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      /*
      if(e.getSource() == tf1)
      {
         int c = Integer.parseInt(tf1.getText());
         double f = c*1.8+32;  //¼·¾¾->È­¾¾
         double k = c+273.15;  //¼·¾¾->Àý´ë
         tf2.setText(""+f);
         tf3.setText(""+k);
      }
      */
      if(e.getSource() == bt1)
      {
         tf1.setText("");
         tf2.setText("");
         tf3.setText("");
      }
      if(e.getSource() == bt2)
      {
         System.exit(0);
      }
   }
   
   
   @Override
   public void keyPressed(KeyEvent arg0) {
      
   }
   @Override
   public void keyReleased(KeyEvent arg0) {
      if(arg0.getSource() == tf1)
      {
         int c = Integer.parseInt(tf1.getText());
         double f = c*1.8+32;  //¼·¾¾->È­¾¾
         double k = c+273.15;  //¼·¾¾->Àý´ë
         tf2.setText(""+f);
         tf3.setText(""+k);
      }
   }
   @Override
   public void keyTyped(KeyEvent arg0) {
      
   }
}

