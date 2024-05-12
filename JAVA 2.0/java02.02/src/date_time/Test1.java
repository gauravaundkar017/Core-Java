package date_time;

import java.util.Date;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d1 = new Date();
		System.out.println(d1);
		Date d2 = new Date(10000);
		System.out.println(d2);
		System.out.println(d1.before(d2));
		System.out.println(d1.after(d2));
		System.out.println(d2.compareTo(d1));
		System.out.println(d1.compareTo(d2));
		System.out.println(d2.compareTo(d2));


	}

}
