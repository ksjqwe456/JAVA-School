package mypjt01;

public class Thread0523 {
	public static void main(String[] args) {
		Thread t1 = new Thread011("A");
		Thread t2 = new Thread011("B");
		t1.start();
		t2.start();
	}

}
class Thread011 extends Thread{
	String myName;
	Thread011(String name){
		myName = name;
		
	}
	public void run() {
		for(int  i=1;i<10;i++) {
			System.out.print(myName+":"+i+" ");
		}
	}
}
