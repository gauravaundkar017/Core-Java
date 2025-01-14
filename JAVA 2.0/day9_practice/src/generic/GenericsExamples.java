package generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class Fruit {
	   @Override
	   public String toString() {
	      return "I am a Fruit !!";
	   }
	}
	class Apple extends Fruit {
	   @Override
	   public String toString() {
	      return "I am an Apple !!";
	   }
	}
	class AsianApple extends Apple {
	   @Override
	   public String toString() {
	      return "I am an AsianApple !!";
	   }
	}
	class IndianApple extends AsianApple {
		   @Override
		   public String toString() {
		      return "I am an Indian !!";
		   }
		}
	class ChinaApple extends AsianApple {
		   @Override
		   public String toString() {
		      return "I am an chinaApple !!";
		   }
		}
	public class GenericsExamples
	{
	   public static void main(String[] args)
	   {
	      //List of apples
	      List<Apple> apples = new ArrayList<Apple>();
	      apples.add(new Apple());
	      //We can assign a list of apples to a basket of apples
	      List<? super Apple> basket = apples;
//	      basket.add(new Apple());    //Successful
	      basket.add(new AsianApple()); //Successful
	      
//	      public static<AsianApple> boolean addAll(List <? super AsianApple> list, asianApples..AsianApple.); 
	      
	      List<? super AsianApple> basket1 = apples;
//	      basket1.addAll(basket);
//	      basket1.addAll(new Apple());
	      basket1.add(new IndianApple());   
	      basket1.add(new ChinaApple());
	      basket.addAll(apples);
	      for (Object a : basket) {
			System.out.println(a);
		}
	   }
	}