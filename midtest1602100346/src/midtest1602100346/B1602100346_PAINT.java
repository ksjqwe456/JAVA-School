package midtest1602100346;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;





public class B1602100346_PAINT {
	 public static void main(String[] args) {
	      // TODO Auto-generated method stub
	       MyDrawFrame d1 = new MyDrawFrame();
	       d1.display();

	   }

	}
	class MyDrawFrame extends JFrame implements MouseMotionListener,ActionListener,KeyListener
	{
	   IMackCanvas myCanvas;
	   JButton a1;
	   
	   MyDrawFrame()
	   {
		   
	      myCanvas = new IMackCanvas();
	      myCanvas.setSize(300,300);
	      myCanvas.setBackground(Color.white);
	      myCanvas.addMouseMotionListener(this);
	      add(myCanvas);
	      a1 =new JButton("Eraser");
	      add(a1);
	      a1.addActionListener(this);
	      
	      
	   }
	   void display()
	   {
	           setLayout(new FlowLayout());
	            setSize(500,500);
	            setVisible(true);
	            //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            setTitle("내가만든 캔버스");
	            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	           
	   }
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		myCanvas.x = e.getX();
		myCanvas.y = e.getY();
		myCanvas.repaint();
	
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	class IMackCanvas extends Canvas //스케치북을 만든다.
	{
	   int x=100, y=100;
	   public void paint(Graphics g)
	   {
	      g.setColor(Color.black);//연필색
	      //g.drawString("재미있는 자바",50,200); 
	      g.fillOval(x, y, 7, 7); //채워진 동그라미
	      g.setColor(Color.white);
	      //g.fillRect(x, y, 50, 100);
	   }
	   public void update(Graphics g) {
		   paint(g);
		// TODO Auto-generated method stub
	   }

	
	}
	   
	   

		
	



	@Override
	public void actionPerformed(ActionEvent g) {
		Graphics g1 = myCanvas.getGraphics();
		g1.clearRect(0, 0, 300, 300);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {

	
			   if(e.getKeyChar()=='r')
			   {
				   myCanvas.x+=10;
				   
			   }
			   if(e.getKeyChar()=='1')
			   {
				   myCanvas.x-=10;
			   }
			   Graphics g = myCanvas.getGraphics();
			   g.clearRect(0, 0, 300, 300);
			   myCanvas.repaint();
			   }
		   }
	
		
		// TODO Auto-generated method stub