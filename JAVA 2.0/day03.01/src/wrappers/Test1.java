package wrappers;

import java.util.Date;

public class Test1 {

	public static void main(String[] args) {
		Integer i1=Integer.valueOf(12345);//boxing
		//new Integer(100): DEPRECATED 
		int data=i1.intValue();//un boxing
		
//		float f = (float)12.5;
		
		Float f1 = Float.valueOf(12.2f);
		float f2 = f1.floatValue();
		System.out.println("f1 : "+f1);
		System.out.println("f2 : "+f2);
		
		f1 = 13.5f; //auto boxing
		f1++; //auto unboxing then---> float value ++ ---->then auto boxing
		
		
		//seq : boxing    wrapper float w double  
		
		
		i1=1000;//auto boxing (int --> Integer)
		data=i1;//auto un boxing (Integer --> int)
		String s="123456";
	//	s++; javac err
		Date d1=new Date();
	//	d1++;//javac err
		i1++;//auto un boxing --> inc --> auto boxing
		System.out.println(i1);
		double d2=12.34F;//javac : widening conversion
		Double d3=123.45;//auto boxing
	//	d3=12.34F;//javac -- auto boxing(float --> Float) --> can't be cast to Double
		d3=(double)12.34F;//explicit : float --> double , impl : double --> Double
		Number n1=12.3456f;//auto box (float --> Float) --> up casting --> Number
		System.out.println(n1.getClass());//java.lang.Float
		n1=12345;
		System.out.println(n1.getClass());
		n1=12345678l;
		System.out.println(n1.getClass());
		Object o=true;//auto boxing --> up casting
		System.out.println(o.getClass());//java.lang.Boolean
		o=123.45;//double --> Double --> Number --> Object
		System.out.println(o.getClass());//java.lang.Double
	}

}
