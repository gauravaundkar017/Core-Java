package functional_streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] data = { 1, 2, 3, 55, 45, -100, 10 };
		//attach Instream to array n display elems
		//source (int[]) --> trminal forEach
		Arrays.stream(data)./*src IntStream*/
		forEach(i->System.out.print(i+" "));
		
		

	}

}