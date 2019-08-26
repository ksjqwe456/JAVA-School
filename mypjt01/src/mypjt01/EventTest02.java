package mypjt01;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EventTest02 {

   public static void main(String[] args) {
      myEvent me = new myEvent();
      me.display();
   }
}
/*
 * 텍스트 필드에 엔터 치면 인치 변환
 * 
 * 
 */
class myEvent extends JFrame implements ActionListener,FocusListener,KeyListener,MouseListener,MouseWheelListener,MouseMotionListener
{
   JButton close, yellow, pink, clear;
   JPanel p;
   JTextArea ta;
   JTextField tf;
   JCheckBox[] ch;   //배열선언
   JRadioButton[] gender;
   ButtonGroup group;
   JComboBox<String> combo;
   String fruit[] = {"바나나","포도","토마토","수박","참외"};
   myEvent()
   {
      close = new JButton("Close");
      close.addActionListener(this);
      add(close);
      
      p = new JPanel();
      p.setBackground(Color.cyan);
      
      yellow = new JButton("YELLOW");
      yellow.addActionListener(this);
      
      pink = new JButton("PINK");
      pink.addActionListener(this);
      
      clear = new JButton("Clear");
      clear.addActionListener(this);
   
      ta = new JTextArea(10,40);
      tf = new JTextField(40);
      tf.addActionListener(this);
      tf.addMouseMotionListener(this);
      
      ch= new JCheckBox[5];
      tf.addFocusListener(this);
      tf.addKeyListener(this);
      tf.addMouseListener(this);
      tf.addMouseWheelListener(this);
      p.add(close);
      p.add(yellow);
      p.add(pink);
      p.add(clear);
      p.add(ta);
      p.add(tf);
      for(int i=0; i<ch.length; i++)
      {
         ch[i] = new JCheckBox(""+(i+1)+"번");
         ch[i].addActionListener(this);
         p.add(ch[i]);
      }
      gender = new JRadioButton[3];
      group = new ButtonGroup();
      for(int i= 0; i<gender.length; i++)
      {
         gender[i] = new JRadioButton();
         gender[i].addActionListener(this);
         group.add(gender[i]);
         p.add(gender[i]);
      }
      gender[0].setText("Male");
      gender[1].setText("Female");
      gender[2].setText("Other");
      
      combo = new JComboBox<>(fruit);
      p.add(combo);
      combo.addActionListener(this);
      
   }
   public void display()
   {
//      setLayout(new FlowLayout());
      add(p);
      setSize(500,500);
      setTitle("나의 이벤트");
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   public void actionPerformed(ActionEvent a)
   {
      if(a.getSource()==close)
         System.exit(0);
      if(a.getSource()==pink)
         p.setBackground(Color.pink);
      if(a.getSource()==yellow)
         p.setBackground(Color.yellow);
      if(a.getSource()==clear)
         ta.setText("");
      if(a.getSource()==tf)
      {
         ta.append(tf.getText()+"\n");
         tf.setText("");
      }
      for(int i=0;i<ch.length;i++)
      {
         if(a.getSource()==ch[i])
            if(ch[i].isSelected())
               ta.append(ch[i].getText()+"선택되었습니다.\n");
            else
               ta.append(ch[i].getText()+"해제되었습니다.\n");
      }
      for(int i=0; i<gender.length;i++)
      {
         if(a.getSource()==gender[i])
         {
            ta.append(gender[i].getText()+"선택되었습니다.\n");
         }
      }
      
      if(a.getSource()==combo)
         ta.append(combo.getSelectedItem()+"선택!\n");
   }
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	ta.append(e.getKeyChar()+"입력\n");
	tf.setText("");
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	ta.append(e.getX()+","+e.getY()+"\n");
	
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void focusGained(FocusEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void focusLost(FocusEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseWheelMoved(MouseWheelEvent e) {
	// TODO Auto-generated method stub
	ta.append("마우스를 휠 움직였습니다");
}
@Override
public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	ta.append("하이하이");
}
   
}
