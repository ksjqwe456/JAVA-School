package test;

import java.util.Vector;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.util.Timer;
import javax.swing.*;




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
{  //Vector<Point> bullet=new Vector<Point>();

//Vector<Thread> Tbullet=new Vector<Thread>();
//Vector<Point> enenmy=new Vector<Point>();
//Vector<Thread> Tenenmy=new Vector<Thread>();	
  ddd(){setContentPane(new mypan1());}

	void display() {
		
		setSize(3000,3000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	
	
	public class mypan1 extends JPanel implements MouseListener,MouseMotionListener,Runnable,KeyListener{
		Vector<bulletR> bulletq=new Vector<bulletR>();//메인캐 총알 
		Vector<enemyR> enemyq=new Vector<enemyR>();//적군
		Vector<itemR> itemq=new Vector<itemR>();//아이템
		
		int mainpx,mainpy;
		int x=0; int y=0;
		int x1=0; int y1=0;
		double x2=0; double y2=0;
		double k; double k1;
		double bulletk=0;
		double tri1k=0;
		double tri1k2=0;
		int xt1=0;int yt1=0;
		int xt2=0;int yt2=0;
		int reload=0;int maxreload=50;//재장전
		int gunmode=0;//총모드
		Thread fg; //그리기(jpanel 메인 스레드)
		Thread enp;//적군 추가
		Thread mov;//스레드 메인 캐 무빙
		Thread ite;//아이템 소환
		int hp=100;
		int spround=0;
		double xp=0;double yp=0;
		int f=0;
		int enn=100;
		int r=0;int[] movement= {0,0};
		int gamemode=0;
		int score=0;
		public void gameinit(){
			mainpx=300;mainpy=300;score=0;
			if(!bulletq.isEmpty())
			{for(int i=0;i<bulletq.size();i++){
				bulletq.elementAt(i).position.x=-22;
				bulletq.elementAt(i).position.y=-22;
			}
			
			bulletq.clear();
			}
			if(!enemyq.isEmpty())
			{for(int i=0;i<enemyq.size();i++){
				enemyq.elementAt(i).position.x=-22;
				enemyq.elementAt(i).position.y=-22;
			}
			
			enemyq.clear();
			}
			if(!itemq.isEmpty())
			{for(int i=0;i<itemq.size();i++){
				itemq.elementAt(i).position.x=-22;
				itemq.elementAt(i).position.y=-22;
			}
			
			enemyq.clear();
			}
			
			
			 bulletq=new Vector<bulletR>();//메인캐 총알 
			enemyq=new Vector<enemyR>();//적군
			 itemq=new Vector<itemR>();//아이템
			
			 x=0;  y=0;
			 x1=0;  y1=0;
			 x2=0;  y2=0;
			
			bulletk=0;
			 tri1k=0;
			tri1k2=0;
			 xt1=0; yt1=0;
			xt2=0; yt2=0;
			reload=0; maxreload=50;//재장전
			 gunmode=0;//총모드
			//Thread fg; //그리기(jpanel 메인 스레드)
			//Thread enp;//적군 추가
			//Thread mov;//스레드 메인 캐 무빙
			//Thread ite;//아이템 소환
			 if(fg!=null&&!fg.interrupted())
			 fg.interrupt();
			 if(enp!=null&&!enp.interrupted())
			 enp.interrupt();
			 if(ite!=null&&!ite.interrupted())
			 ite.interrupt();
			 if(mov!=null&&!mov.interrupted())
			 mov.interrupt();
			 
			 fg=new Thread(new Thread(this));
				enp=new Thread(new enemyP());
				mov=new Thread(new mainmove());
				ite=new Thread(new itemP());
				
			 
			 hp=100;
			spround=0;
			 xp=0; yp=0;
			 f=0;
			 enn=100;
			r=0; movement[0]= 0;
			movement[1]=0;
			fg.start();
			ite.start();
			enp.start();
			mov.start();
			gamemode=1;
			repaint();
		}
		public void losegame(){
			if(gamemode==1&&hp<0) {
			gamemode=0;
			//fg.stop();
			ite.stop();
			enp.stop();
			mov.stop();
			}
		}
		
		
		
		mypan1(){
			mainpx=300;mainpy=300;
			addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		this.setFocusable(true);
		/*fg=new Thread(new Thread(this));
		enp=new Thread(new enemyP());
		mov=new Thread(new mainmove());
		ite=new Thread(new itemP());
		fg.start();
		ite.start();
		enp.start();
		mov.start();
		*/
		//this.getParent().setC
		gameinit();
		}
		int xtt[]= {10,30,40};
		int ytt[]= {50,60,70};
		public void paintComponent(Graphics g)
		{super.paintComponent(g);
		//bullet.add(new Point((int)x2,(int)y2,0,0));
			g.setColor(Color.black);
			
		
			k=getAngle(x,y,mainpx,mainpy);
			
			 k1=Math.toRadians(k);//메인캐와 마우스 각
			x1=(int) (Math.cos(k1)*50+mainpx);//총신 위치x(이 값을 바꾸면 실제값도 변화)
			y1=(int) (Math.sin(k1)*50+mainpy);//총신 위치y(이 값을 바꾸면 실제값도 변화)
			
			
			///삼각형
			
			tri1k=k+120;
			tri1k2=Math.toRadians(tri1k);
			xt1=(int) (Math.cos(tri1k2)*50+mainpx);
			yt1=(int) (Math.sin(tri1k2)*50+mainpy);
			xt2=xt1;yt2=yt1;
			
			xtt[0]=xt1;xtt[1]=mainpx; xtt[2]=x1;
			ytt[0]=yt1;ytt[1]=mainpy; ytt[2]=y1;
			g.fillPolygon(xtt, ytt, 3);
			g.drawLine(xt1,yt1,x1,y1);
			
			tri1k+=120;tri1k2=Math.toRadians(tri1k);
			xt1=(int) (Math.cos(tri1k2)*50+mainpx);
			yt1=(int) (Math.sin(tri1k2)*50+mainpy);
			
			g.drawLine(xt1,yt1,x1,y1);
			xtt[0]=xt1;ytt[0]=yt1;
			g.setColor(Color.WHITE);
			g.fillPolygon(xtt, ytt, 3);
			g.setColor(Color.BLACK);
			//g.drawLine(xt1,yt1,xt2,yt2);
			g.drawLine(xt1,yt1,mainpx,mainpy);
			g.drawLine(xt2,yt2,mainpx,mainpy);

			
			
			//main캐 (총신)
			
			g.drawLine(mainpx, mainpy,x1,y1);
			
			//총알
			try {
				
				 
				int fillx[]= {0,0,0,0,0};
				int filly[]= {0,0,0,0,0};
	    	   
	    	   for (int i=0;i<bulletq.size();i++)
	    	   {
	    		   int bx1=(int)(bulletq.get(i).position.x+(Math.cos(bulletq.get(i).position.z+Math.toRadians(90))*3));
	    			int by1=(int)(bulletq.get(i).position.y+(Math.sin(bulletq.get(i).position.z+Math.toRadians(90))*3));
	    			int bx2=(int)(bulletq.get(i).position.x+(Math.cos(bulletq.get(i).position.z+Math.toRadians(270))*3));
	    			int by2=(int)(bulletq.get(i).position.y+(Math.sin(bulletq.get(i).position.z+Math.toRadians(270))*3));
	    			int bx3=bx1+(int)(Math.cos(bulletq.get(i).position.z)*7);
	    			int by3=by1+(int)(Math.sin(bulletq.get(i).position.z)*7);
	    			int bx4=bx2+(int)(Math.cos(bulletq.get(i).position.z)*7);;
	    			int by4=by2+(int)(Math.sin(bulletq.get(i).position.z)*7);;
	    			int bx5=(int)(bulletq.get(i).position.x+(Math.cos(bulletq.get(i).position.z)*10));
	    			int by5=(int)(bulletq.get(i).position.y+(Math.sin(bulletq.get(i).position.z)*10));
	    			
	    		   
	    		 //  g.drawLine((int)(bulletq.get(i).position.x), (int)bulletq.get(i).position.y,(int)bulletq.get(i).position.x+(int)(Math.cos(bulletq.get(i).position.z)*10), (int)bulletq.get(i).position.y+(int)(Math.sin(bulletq.get(i).position.z)*10));
	    	//g.drawLine((int)bulletq.get(i).position.x+(int)(Math.cos(bulletq.get(i).position.z+Math.toRadians(90))*3),(int)bulletq.get(i).position.y+(int)(Math.sin(bulletq.get(i).position.z+Math.toRadians(90))*3),(int)bulletq.get(i).position.x+(int)(Math.cos(bulletq.get(i).position.z+Math.toRadians(90))*3),(int)bulletq.get(i).position.y+(int)(Math.sin(bulletq.get(i).position.z+Math.toRadians(90))*3));
	    			fillx[0]=bx1;fillx[1]=bx2;fillx[2]=bx4;fillx[3]=bx5;fillx[4]=bx3;
	    	    	filly[0]=by1;filly[1]=by2;filly[2]=by4;filly[3]=by5;filly[4]=by3;
	    	    	g.setColor(Color.YELLOW);
	    	    	g.fillPolygon(fillx, filly,5);
	    	    	g.setColor(Color.BLACK);
	    	g.drawLine(bx1, by1, bx2, by2);
	    	g.drawLine(bx1, by1, bx3, by3);//오른쪽 밑
	    	g.drawLine(bx2, by2, bx4, by4);//왼쪽밑
	    	g.drawLine(bx4, by4, bx5, by5);//왼쪽위
	    	g.drawLine(bx3, by3, bx5, by5);	//오른쪽 위
	    	
	    	g.drawLine(bx4,by4, bx3,by3);








	    		//g.drawLine((int)bulletq.get(i).position.x, (int)bulletq.get(i).position.y, (int)bulletq.get(i).position.x, (int)bulletq.get(i).position.y);    	   
	    		
	    	   }
	    	   }catch(Exception e1) {}
			
			
			
			////적

		try {	
			
			for(int i=0; i<enemyq.size()-1;i++) {
				g.setColor(Color.BLUE);
				if(enemyq.get(i).hp==2)
				{
					g.fillArc((int)enemyq.get(i).position.x, (int)enemyq.get(i).position.y, 20, 20, 0, 360);
					g.drawArc((int)enemyq.get(i).position.x, (int)enemyq.get(i).position.y, 20, 20, 0, 360);
				}
				g.setColor(Color.RED);
				if(enemyq.get(i).hp==1)
					{
					g.fillArc((int)enemyq.get(i).position.x, (int)enemyq.get(i).position.y, 20, 20, 0, 360);
					g.drawArc((int)enemyq.get(i).position.x, (int)enemyq.get(i).position.y, 20, 20, 0, 360);
					}
				g.setColor(Color.BLACK);
				
			}
	   }catch(Exception e1) {}
		
		//아이템
 for(int i=0;i<itemq.size()-1;i++) {		
if(itemq.get(i).inum==1)		
 { g.setColor(Color.green);
	g.fillArc((int)itemq.get(i).position.x,(int)itemq.get(i).position.y, 15, 15, 0, 360);
	g.setColor(Color.BLACK);
	g.drawString("샷건", (int)itemq.get(i).position.x, (int)itemq.get(i).position.y+9);
	
 }
if(itemq.get(i).inum==2)		
{ g.setColor(Color.LIGHT_GRAY);
g.fillArc((int)itemq.get(i).position.x,(int)itemq.get(i).position.y, 15, 15, 0, 360);
g.setColor(Color.BLACK);
	g.drawString("기관총", (int)itemq.get(i).position.x, (int)itemq.get(i).position.y+9);

}
if(itemq.get(i).inum==3)		
	 {
	g.setColor(Color.WHITE);
	g.fillArc((int)itemq.get(i).position.x,(int)itemq.get(i).position.y, 15, 15, 0, 360);
	g.setColor(Color.BLACK);
	g.drawString("HP", (int)itemq.get(i).position.x, (int)itemq.get(i).position.y+9);
	 
	 }
	 if(itemq.get(i).inum==4)		
	 {g.setColor(Color.ORANGE);
		g.fillArc((int)itemq.get(i).position.x,(int)itemq.get(i).position.y, 15, 15, 0, 360);
		g.setColor(Color.BLACK);
		 g.drawString("저격총", (int)itemq.get(i).position.x, (int)itemq.get(i).position.y+9);
	 }
 }
		
//UI
 g.setFont(new Font(null,Font.BOLD,30));
 if(gunmode==1)
 {g.drawString("탄환:"+spround,1270,30);g.drawString("모드:샷건", 1430, 30);}
 else if(gunmode==0)
	 {g.drawString("탄환:무한",1270,30);g.drawString("모드:권총", 1430, 30);}
 else if(gunmode==2)
 {g.drawString("탄환:"+spround,1270,30);g.drawString("모드:기관총", 1430, 30);}
 else if(gunmode==3)
 {g.drawString("탄환:"+spround,1270,30);g.drawString("모드:저격총", 1430, 30);}

 
 g.drawString("체력:"+hp, 1125, 30);g.drawString("적수 :"+enemyq.size(), 1430, 60);
 
 if(gamemode==0&&hp<0)
 {g.drawString("게임을 져었드아 점수:"+score, 500,500);
  g.drawString("R:Game", 500,550);
 }
 
		}

		
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
    int mousepushed=0;
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			if(gamemode==1) {
			
			mousepushed=1;
			
			if(gunmode==0) {
			if(reload>=maxreload)
			{reload=0;
				try {
			bulletk=k1;
			xp=Math.cos(k1)*2; yp=Math.sin(k1)*2;
			int tn=bulletq.size();
			
			////////정리된 총알
			bulletq.add(new bulletR(new Point(x1,y1,k1,xp,yp),gunmode));
			bulletq.get(tn).move.start();
			
			
			}catch(Exception e){}
			}}
			else if(gunmode==1) {
				if(reload>=maxreload)
				{reload=0;
					try {
				////////정리된 총알
						bulletk=k1;
				xp=Math.cos(bulletk)*2; yp=Math.sin(bulletk)*2;
				int tn=bulletq.size();
				bulletq.add(new bulletR(new Point(x1,y1,bulletk,xp,yp),gunmode));
				bulletq.get(tn).move.start();
				
				bulletk=k1+Math.toRadians(10);
				xp=Math.cos(bulletk)*2; yp=Math.sin(bulletk)*2;
				 tn=bulletq.size();
				bulletq.add(new bulletR(new Point(x1,y1,bulletk,xp,yp),gunmode));
				bulletq.get(tn).move.start();
				bulletk=k1-Math.toRadians(10);
				xp=Math.cos(bulletk)*2; yp=Math.sin(bulletk)*2;
				 tn=bulletq.size();
				bulletq.add(new bulletR(new Point(x1,y1,bulletk,xp,yp),gunmode));
				bulletq.get(tn).move.start();
				spround--;
				if(spround==0)
				{maxreload=50;gunmode=0; }
				
				}catch(Exception e){}
				}}
			else if(gunmode==2) {
				if(reload>=maxreload)
				{reload=0;
					try {
				bulletk=k1;
				xp=Math.cos(k1)*2; yp=Math.sin(k1)*2;
				int tn=bulletq.size();
				
				////////정리된 총알
				bulletq.add(new bulletR(new Point(x1,y1,k1,xp,yp),gunmode));
				bulletq.get(tn).move.start();
				spround--;
				if(spround==0)
				{maxreload=50;gunmode=0; }
				
				}catch(Exception e){}
				}}else if(gunmode==3) {
					if(reload>=maxreload)
					{reload=0;
						try {
					bulletk=k1;
					xp=Math.cos(k1)*3; yp=Math.sin(k1)*4;
					int tn=bulletq.size();
					
					////////정리된 총알
					bulletq.add(new bulletR(new Point(x1,y1,k1,xp,yp),gunmode));
					bulletq.get(tn).move.start();
					spround--;
					if(spround==0)
					{maxreload=50;gunmode=0; }
					
					}catch(Exception e){}
					}}
			
			
			
			
			}
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
				mousepushed=0;
		
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
			
			//this.getParent().repaint();
			
			
		
		}
		double getAngle(double x1, double y1, double x2, double y2){
			double Angle =  Math.atan((y2-y1)/(x2-x1))*180/Math.PI;
		    if (x1 <= x2)
		    {
		        Angle = -180 + Angle;
		// atan 취급 쥐의 0~180 도는 구할 수 있지만, y1 > y2 인 경우.. 즉
		// 3사분면 4사분면은 360 - (180~360) 를 해줘서 [0,180] 
		// 값으로 보정해준다.
		    }

		    return Angle;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true)	{
			//x2+=xp;y2+=yp;
			if(reload<maxreload)
			{
				reload++;
			}
			
			if(gunmode==2&&mousepushed==1) {
				if(reload>=maxreload)
				{reload=0;
					try {
				bulletk=k1;
				xp=Math.cos(k1)*2; yp=Math.sin(k1)*2;
				int tn=bulletq.size();
				
				////////정리된 총알
				bulletq.add(new bulletR(new Point(x1,y1,k1,xp,yp),gunmode));
				bulletq.get(tn).move.start();
				spround--;
				if(spround==0)
				{maxreload=50;gunmode=0; }
				
				}catch(Exception e){}
				}}
			
			
			for(int i=0;i<bulletq.size();i++)
			{
				if(bulletq.get(i).position.x<0&&bulletq.get(i).position.y<0)
				{   bulletq.get(i).move.stop();
					bulletq.remove(i);
				}
			}
			for(int i=0;i<itemq.size();i++)
			{
				if(itemq.get(i).position.x<0&&itemq.get(i).position.y<0)
				{   itemq.get(i).gettem.stop();
				 itemq.remove(i);
				}
			}
			
			for(int i=0;i<enemyq.size();i++)
			{
				if(enemyq.get(i).position.x<0&&enemyq.get(i).position.y<0)
				{   enemyq.get(i).move.stop();
				
				enemyq.remove(i);
				i--;
				}
			}
			
			losegame();
			repaint();
			//getParent().repaint();
			try {
				Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
				}
			
			//bullet=new Point(x1,y1,0,0);
			
		}
		class bulletR implements Runnable{
			Point position; Thread move;
			int gunmode;
			bulletR(Point position,int gunmode){this.gunmode=gunmode;
	this.position=position;
	move=new Thread(this);
}
			@Override
			public void run() {
				// TODO Auto-generated method stub
				boolean f=true;
				while(f) {
					 if(position.x<0&&position.y<0)
					 {f=false;}
					//bullet.get(roa).x+=(bullet.get(roa)).xp;bullet.get(roa).y+=(bullet.get(roa)).yp;
					position.x+=position.xp;position.y+=position.yp;
					
					try {
						for(int i=0;i<enemyq.size()-1;i++)
						{double dir=(position.x-enemyq.get(i).position.x)*(position.x-enemyq.get(i).position.x)+(position.y-enemyq.get(i).position.y)*(position.y-enemyq.get(i).position.y);
							if(dir<400)
							{
								//enemyq.get(i).move.interrupt();
								if(gunmode!=3)
								{    if(enemyq.get(i).hp==1)
									{enemyq.get(i).position.x=-22;
									enemyq.get(i).position.y=-22;
									score+=100;
									}
								else if(enemyq.get(i).hp==2)
								{
									enemyq.get(i).hp=1;
								}
								position.x=-22;position.y=-22;
								}else
								{enemyq.get(i).position.x=-22;
								enemyq.get(i).position.y=-22;
								 score+=100;	
								}
								//System.out.println("hit:"+dir);
							    
							}	
							
							if((position.x<0)||(position.y<0)||(position.x>3000)||(position.y>3000))
							{
								position.x=-22;position.y=-22;
							}
							
						}
						Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						
					}
				}
			}
			
		}
		
		class itemP implements Runnable{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					
				itemq.add(new itemR(new Point(Math.random()*1000,Math.random()*1000,0,0,0),(int) (Math.random()*4+1)));
				itemq.lastElement().gettem.start();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				}

			
			
		}
			
	class itemR implements Runnable{
		Point position;int inum; Thread gettem;
		itemR(Point position,int inum){
			this.position=position;
			gettem=new Thread(this);
this.inum=inum; 
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				try {
					for(int i=0;i<itemq.size()-1;i++)
					{double dir=(position.x-mainpx)*(position.x-mainpx)+(position.y-mainpy)*(position.y-mainpy);
						if(dir<4225)
						{if(inum==1) {
							//enemyq.get(i).move.interrupt();
							position.x=-33;position.y=-33;
						spround=10;maxreload=90;gunmode=1;
						//itemq.removeElementAt(i);
						//i--;
						}
						if(inum==2) {
							//enemyq.get(i).move.interrupt();
							position.x=-33;position.y=-33;
						spround=30;maxreload=20;gunmode=2;
						//itemq.removeElementAt(i);
						//i--;
						}
						if(inum==3) {
							//enemyq.get(i).move.interrupt();
							position.x=-33;position.y=-33;
						
							if(hp<90)
							{hp+=10;}
							else{hp=100;}
							
							
						//itemq.removeElementAt(i);
						//i--;
						}
						if(inum==4) {
							//enemyq.get(i).move.interrupt();
							position.x=-33;position.y=-33;
						spround=10; maxreload=60; gunmode=3;
						//itemq.removeElementAt(i);
						//i--;
						}
						    
							
							//System.out.println("hit:"+dir);
						repaint();
						}	
					}
					Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
				}
				
			}
		}
		
	}
		
		class enemyP implements Runnable{
			@Override
			public void run() {
				while(true)	{
					//x2+=xp;y2+=yp;
					
					
						//x2+=1;y2+=1;
						//bullet.get(bullet.size()-1).x+=(int)(bullet.get(bullet.size()-1)).xp;bullet.get(bullet.size()-1).y+=(int)(bullet.get(bullet.size()-1)).yp;
					
					//System.out.println(bullet.get(bullet.size()-1).x+" "+xp);
					if(enn==1000) {
					try { enn=0;
					int separ=(int)(Math.random()*4);
					if(separ==0)
					{
					enemyq.add(new enemyR(new Point(Math.random()*1000,1000,k1,0,0)));}
					else if(separ==1) {
					//enenmy.add(new Point(1000,Math.random()*1000,k1,0,0));
					enemyq.add(new enemyR(new Point(1000,Math.random()*1000,k1,0,0)));}
					else if(separ==2) {
						//enenmy.add(new Point(0,Math.random()*1000,k1,0,0));
						enemyq.add(new enemyR(new Point(0,Math.random()*1000,k1,0,0)));}
					else if(separ==3) {
						//enenmy.add(new Point(Math.random()*1000,0,k1,0,0));
						enemyq.add(new enemyR(new Point(Math.random()*1000,0,k1,0,0)));}
					//int tv=Tenenmy.size();
					
					//Tenenmy.add(new Thread(new enemymove()));
					//Tbullet.get(Tbullet.size()-1).setPriority(Thread.MAX_PRIORITY);
					//Tenenmy.get(tv).start();
					//enemyq.get(tv).move.start();
					enemyq.lastElement().move.start();
					}catch(Exception e){}
					//System.out.println("적의 수:"+enemyq.size()+"움직임:"+enemyq.lastElement().move.isAlive());
					
					
						
					try {
						Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else
					{enn++;}
						}
				
			}
		}
		class enemyR implements Runnable{
			Point position; Thread move;
			double fg; int hp=2;
			enemyR(Point position){
				this.position=position;
				move=new Thread(this);}
			@Override
			public void run() {
				// TODO Auto-generated method stub
				double ex;double ey;boolean f= true;
				while(f) {
					try {
						
						/*if(bullethit(enenmy.get(roa).x,enenmy.get(roa).y))
						{
							
						}*/
						fg=getAngle(position.x,position.y,mainpx,mainpy);
					ex=(Math.cos(Math.toRadians(fg+180))*10);
					ey=(Math.sin(Math.toRadians(fg+180))*10);
					
					
					if(!(position.x<0&&position.y<0))
					{position.x+=ex;position.y+=ey;}
					
					//enenmy.get(roa).y-=8;
					
					for(int i=0;i<enemyq.size()-1;i++)
					{double dir=(position.x-mainpx)*(position.x-mainpx)+(position.y-mainpy)*(position.y-mainpy);
						if((dir<4225)&&(position.x>0&&position.y>0))
						{  mypan1.this.hp-=5;
							position.x=-44;
							position.y=-44;
							
						}
						
					}
					
					if((position.x<0&&position.y<0))
						{f=false;}
					
					
						Thread.sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						
					}
				}
			}
		}
	
		class mainmove implements Runnable{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
				for(int i=0;i<2;i++)
				switch(movement[i]){
				case 0:
					break;
				case 1:
					mainpx-=2;
					break;
				case 2:
					mainpx+=2;
					break;
				case 3:
					mainpy-=2;
					break;
				case 4:
					mainpy+=2;
					break;
				
				
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
			}
			
		}
		
		@Override
		public void keyPressed(KeyEvent arg0) {
			
			// TODO Auto-generated method stub
			
			if(arg0.getKeyChar()=='a')
				{if(movement[0]==0){movement[0]=1;}
				else if(movement[0]!=1){movement[1]=1;}
				}
				if(arg0.getKeyChar()=='d')
				{if(movement[0]==0){movement[0]=2;}
				else if(movement[0]!=2){movement[1]=2;}
				}
				if(arg0.getKeyChar()=='w')
				{if(movement[0]==0){movement[0]=3;}
				else if(movement[0]!=3){movement[1]=3;}
				}
					if(arg0.getKeyChar()=='s')
					{if(movement[0]==0){movement[0]=4;}
					else if(movement[0]!=4){movement[1]=4;}
					}
				
					
					if(gamemode==0&&hp<0){
						if(arg0.getKeyChar()=='r')
						{
							gameinit();
						}
						
					}
					
		}
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getKeyChar()=='a')
			{if(movement[1]==1){movement[1]=0;}
			 if(movement[0]==1){movement[0]=movement[1];movement[1]=0;}
			}
			if(arg0.getKeyChar()=='d')
			{if(movement[1]==2){movement[1]=0;}
			 if(movement[0]==2){movement[0]=movement[1];movement[1]=0;}
			}
			if(arg0.getKeyChar()=='w')
			{if(movement[1]==3){movement[1]=0;}
			 if(movement[0]==3){movement[0]=movement[1];movement[1]=0;}
			}
				if(arg0.getKeyChar()=='s')
				{if(movement[1]==4){movement[1]=0;}
				 if(movement[0]==4){movement[0]=movement[1];movement[1]=0;}
				}
		}
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	
	}
	
	
	}