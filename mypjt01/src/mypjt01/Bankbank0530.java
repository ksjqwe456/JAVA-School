package mypjt01;

public class Bankbank0530 {
	public static void main(String[] args) {		
		Bank bank= new Bank();
		Thread threadA = new user(bank,"인터넷뱅킹");
		Thread threadB = new user(bank,"스마트 뱅킹");
		Thread threadC = new user(bank,"ATM");
		threadA.start();
		threadB.start();
		threadC.start();
		
	}

}
class Bank
{
	int sum = 0;
	void add(int value,String loc) {
		System.out.println(loc+"으로"+value+"입금");
		sum +=value;
	}
	void minus(int value,String loc) {
		System.out.println(loc+"으로"+value+"출금");
		sum -=value;
		
	}   
	void display() {
		System.out.println("total="+sum);
	}
}
class user extends Thread
{
	Bank bank = null;
	String name="";
	public user(Bank bank,String loc) {
		this.bank = bank;
		this.name = loc;
	}
	public void run() {
		
		bank.add(10,name);
		bank.minus(10,name);
		bank.display();
	}
}