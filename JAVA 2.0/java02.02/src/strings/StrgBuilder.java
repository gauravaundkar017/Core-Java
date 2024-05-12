package strings;

import java.sql.Date;

public class StrgBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb1 = new StringBuilder("hello");
		System.out.println(sb1.capacity() + " " + sb1.length());
		StringBuilder sb2 = sb1.append("123.46");
		System.out.println(sb1);
		System.out.println(sb2);
		sb1.append(true).
		append(45.67F).
		append(new Date(0));
		System.out.println(sb1);
		sb1.insert(0, new char[] {'a','b','c','d'},0,4);
		System.out.println(sb1);
		System.out.println(sb1.length()+"  "+sb1.capacity());
		sb1.delete(0,sb1.length());
		System.out.println("after delete "+sb1);
		System.out.println(sb1.length() + " " + sb1.capacity());//0 curnt
		sb1.trimToSize();
		System.out.println(sb1.length() + " " + sb1.capacity());//0 0

	}

}
  