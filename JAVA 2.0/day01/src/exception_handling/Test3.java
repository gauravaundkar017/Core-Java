package exception_handling;

public class Test3 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		System.out.println("Before");
		try {
		Thread.sleep(3000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("After");

	}
//	public static void main(String[] args) throws InterruptedException{
//		// TODO Auto-generated method stub
//		System.out.println("Before");
//		Thread.sleep(5000);
//		System.out.println("After");
//
//	}

}
