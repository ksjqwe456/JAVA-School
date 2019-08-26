package mypjt01;

public class ThreadTimer10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread14 t14 = new Thread14();
				t14.start();
	}

}
class Thread14 extends Thread
{
	public void run()
	{
		
			
		
		for(int i=0;i<=10;i++) {
			try {	
			Thread.sleep(1000);
			System.out.println(i);
		}
		catch(InterruptedException ir) {
			
		}
	}
		System.out.println("finish");
	}
}
