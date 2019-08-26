package mypjt01;

public class MyThred0523 {
	
	public static void main(String[] args) {

		Thread01 t1 = new Thread01();
		Thread02 t2 = new Thread02();
		Thread03 t3 = new Thread03();
		t1.start();
		t2.start();
		t3.start();
		
	}

}
class Thread01 extends Thread
{
	public void run()
	{
		
			
		
		for(int i=0;i<=9;i++) {
			try {	
			Thread.sleep(200);
			System.out.print(i);
		}
		catch(InterruptedException ir) {
			
		}
	}
	}
}
class Thread02 extends Thread{
	public void run() {
		for(char ch='a';ch<='z';ch++) {
			System.out.print(ch);
		}
	}
}
class Thread03 extends Thread{
	public void run() {
		for(char ca='A';ca<='z';ca++) {
			System.out.print(ca);
		}
	}
}
