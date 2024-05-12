package exception_handling;

public class Test1 {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String[] names = {"abc", "xyz","pqr"};
			System.out.println(names[0]);
			System.out.println(10/1);
			System.out.println("Int val " + Integer.parseInt("123"));
			String s = null;
			System.out.println(s.length() );
		}
//		catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println(1);
//		}catch(ArithmeticException | NullPointerException | NumberFormatException e) {
//			System.out.println(2);
//		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("CAtch in all");
		}
		System.out.println("Hello");
	}

}
