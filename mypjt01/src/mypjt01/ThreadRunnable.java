package mypjt01;

public class ThreadRunnable {
	public static void main(String[] args) {
		Thread t9=new Thread(new Thread09("A"));
		Thread t10=new Thread(new Thread09("B"));
		
		t9.start();//run()»£√‚
		t10.start();
		
		
	}

}
class Thread09 implements Runnable{
	
		String mynName;
		Thread09(String name){
			mynName = name;
		}
		public void run()
		{
			for(int i=1;i<10;i++) {
				System.out.print(mynName+":"+i+"  ");
			}
	}
		
}

