package mypjt01;

public class Toilet {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
class Toy{
	synchronized void use(String name) {
		System.out.println(name+"��");
		System.out.println(name+"�����...");
		System.out.println(name+" ����");
		
	}
}
class FamilyThread extends Thread{
	Toilet toilet;
	String who;
	
	FamilyThread(String name,Toilet to){
		who = name;
		toilet =to;
	}
	
	public void run() {
		toilet.use(who);
	}
	
}
	
