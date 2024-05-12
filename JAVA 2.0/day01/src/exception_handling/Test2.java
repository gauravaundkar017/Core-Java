package exception_handling;

public class Test2 {
	static void testMe(String s) throws InterruptedException {
		System.out.println("In test Me");
		try {
			System.out.println("Parsed int value " + Integer.parseInt(s));
			Thread.sleep(1000);
			boolean flag=true;
			if(flag)
				System.exit(0);
//				return;
			System.out.println("end of meth's try");
		}finally {
			// TODO: handle finally clause
			System.out.println("In method's finally");
		}
		System.out.println("end of method");

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			testMe("3");
			System.out.println("end of try in main");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("in main's catch-all");
			System.out.println(e);
		}finally {
			System.out.println("in main's finally");
		}
		System.out.println("main over....");

	}

}
