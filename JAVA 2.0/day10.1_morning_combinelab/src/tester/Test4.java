package tester;

import java.util.stream.IntStream;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//crate stream of ints in range 1-50 
		System.out.println("1-50");
		IntStream.range(1, 51). //src
		forEach(i->System.out.print(i + " "));//terminal ops
		System.out.println();
		System.out.println("1-50 Odd Num");
		//display odd num 1-50
		IntStream.rangeClosed(1, 50)//src Int Stream 1-50
		.filter(i -> i % 2 != 0) //new stream -- Int Stream -- odd -- intermediate op
		.forEach(e -> System.out.print(e+" ")); // // terminal op
		
	}

}