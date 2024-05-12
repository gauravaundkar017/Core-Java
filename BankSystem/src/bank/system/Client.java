package bank.system;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank c1 = new Bank(1,"asd", 110);
		Bank c2 = new Bank(2,"Tatya", 5000);
		System.out.println(c1);
		System.out.println(c2);
		c2.depositeMoney(1000);
		c2.withdrawMoney(50000);
		System.out.println(c2);
		

	}

}
