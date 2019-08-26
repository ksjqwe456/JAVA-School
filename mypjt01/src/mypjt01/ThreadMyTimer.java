package mypjt01;

import java.util.GregorianCalendar;

public class ThreadMyTimer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread15 t15 = new Thread15();
		t15.start();

	}

}
class Thread15 extends Thread
{
	public void run()
	{
		
			
		
		while(true) {
			GregorianCalendar gc = new GregorianCalendar();
			try {	
			Thread.sleep(1000);
			int sec =gc.get(gc.SECOND);
			int min =gc.get(gc.MINUTE);
			int Hour =gc.get(gc.HOUR);
			System.out.println(Hour+"-"+min+"-"+sec);
		}
		catch(InterruptedException ir) {
		
			
		}
	}
		
	}
}

