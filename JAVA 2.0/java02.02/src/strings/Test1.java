package strings;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s1 = new String("hello");
//		s1 += " Hi there ";
//		String s2 = new String(s1.substring(0, 3));
//		System.out.println(s1);
//		System.out.println(s2.toUpperCase());
//		s2 = s1.replace('h', 'f');
//		System.out.println(s2);
		String s1="hello";
		String s2=new String(s1);
		String s3="hello";
		String s4="HELLO";
		System.out.println(s1==s2);//f
		System.out.println(s1==s3);//t
		System.out.println(s1==s4);//f
		System.out.println(s1.equals(s2));//t
		System.out.println(s1.equals(s3));//t
		System.out.println(s1.equals(s4));//f
		System.out.println(s1.equalsIgnoreCase(s4));//t
		s1=s2=s3=s4=null;
		String s5="hello";
		System.out.println(s1);
		System.out.println(s5);
		System.out.println("length "+s1.length());

		
	}

}
