package mypjt01;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JPanel;




class Point{
	public double x,y,k;
	public double z;
	public double xp; public double yp;
	public Point(double x,double y,double z,double xp,double yp){
		this.x=x;this.y=y;this.z=z;this.k=k;this.xp=xp;this.yp=yp;
		
	}
	
}
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ddd ff=new ddd();
ff.display();
	}

}

class ddd extends JFrame
{  Vector<Point> bullet=new Vector<Point>();
Vector<Thread> Tbullet=new Vector<Thread>();
	
  ddd(){setContentPane(new mypan1());}

	void display() {
		
		setSize(3000,3000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	class mypan1 extends JPanel implements MouseListener,MouseMotionListener,Runnable,KeyListener{
		 int mainpx,mainpy;
		int x=0; int y=0;
		int x1=0; int y1=0;
		double x2=0; double y2=0;
		double k; double k1;
		double bulletk=0;
		Thread fg; //Point bullet;
		mypan1(){
			mainpx=300;mainpy=300;
			addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		this.setFocusable(true);
		}
		public void paintComponent(Graphics g)
		{super.paintComponent(g);
		//bullet.add(new Point((int)x2,(int)y2,0,0));
			g.setColor(Color.black);
			
		
			k=getAngle(x,y,mainpx,mainpy);
			 k1=Math.toRadians(k);
			//setTitle(""+k1);
			x1=(int) (Math.cos(k1)*100+mainpx);
			y1=(int) (Math.sin(k1)*100+mainpy);
			
			g.drawLine(mainpx, mainpy,x1,y1);
	       try {
	    	   for(int i=0; i<bullet.size();i++)
			g.drawLine((int)(bullet.get(i).x), (int)bullet.get(i).y,(int)bullet.get(i).x+(int)(Math.cos(bullet.get(i).z)*10), (int)bullet.get(i).y+(int)(Math.sin(bullet.get(i).z)*10));
	       }catch(Exception e1) {}
		
			
		fg=new Thread(new Thread(this));
		fg.start();
		}

		double xp=0;double yp=0;
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
			
			//System.out.println(arg0.getClickCount()+"");
			
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			
			//x2=x1;y2=y1;
			 //xp=x2/100-300; yp=y2/100-300;
			
			bulletk=k1;
			xp=Math.cos(k1)*2; yp=Math.sin(k1)*2;
			bullet.add(new Point(x1,y1,k1,xp,yp));
			Tbullet.add(new Thread(new shotT()));
			Tbullet.get(Tbullet.size()-1).start();
			
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
				
		
		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
x=arg0.getX();y=arg0.getY();
			
			this.getParent().repaint();
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			x=arg0.getX();y=arg0.getY();
			
			this.getParent().repaint();
			
		
		}
		double getAngle(double x1, double y1, double x2, double y2){
			double Angle =  Math.atan((y2-y1)/(x2-x1))*180/Math.PI;
		    if (x1 <= x2)
		    {
		        Angle = -180 + Angle;
		// 0~180 도는 구할 수 있지만, y1 > y2 인 경우.. 즉
		// 3사분면 4사분면은 360 - (180~360) 를 해줘서 [0,180] 
		// 값으로 보정해준다.
		    }

		    return Angle;
		}
		int f=0;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			
				
			
			//while((x2>0&&x2<this.WIDTH) && (y2>0&&y2<this.HEIGHT)){ 
			while(true)	{
			//x2+=xp;y2+=yp;
			
			
				//x2+=1;y2+=1;
				//bullet.get(bullet.size()-1).x+=(int)(bullet.get(bullet.size()-1)).xp;bullet.get(bullet.size()-1).y+=(int)(bullet.get(bullet.size()-1)).yp;
				//System.out.println(bullet.get(bullet.size()-1).x+" "+xp);
				this.getParent().repaint();
				
			try {
				Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
			}
				
				}
			
			//bullet=new Point(x1,y1,0,0);
			
		}
		int r=0;
		class shotT implements Runnable
		{ int roa=0;

			public void run()
			{r++;
			System.out.println(r);
			roa=bullet.size()-1;
			while(true) {
				bullet.get(roa).x+=(int)(bullet.get(roa)).xp;bullet.get(roa).y+=(int)(bullet.get(roa)).yp;
				
				try {
					Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
				}
			}
			}
			
		}
		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getKeyChar()=='a')
				mainpx--;
				if(arg0.getKeyChar()=='d')
					mainpx++;
				
				if(arg0.getKeyChar()=='w')
					mainpy--;
					if(arg0.getKeyChar()=='s')
						mainpy++;
				
				
		}
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	
	}
	
	
	}