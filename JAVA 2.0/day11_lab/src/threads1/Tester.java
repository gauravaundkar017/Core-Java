package threads1;

public class Tester {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// display details of the main threads (name, prio, thrd drp)
//		System.out.println(Thread.currentThread());//tostring -- thread[main,5,main]

		// create multiple child threds (extends thread)
		MyClass t1 = new MyClass("one");
		MyClass t2 = new MyClass("two");
		MyClass t3 = new MyClass("three");
		MyClass t4 = new MyClass("four");

		// how many runnable thrds ? 1(main)
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		// how many runnable thrds ? 1(main) + 4(child)
		System.out.println(t1.isAlive() + " " + t4.isAlive());
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread()/* to get invoker name -> main */.getName() + " exec count "+ i);
			Thread.sleep(1000);
		}
		System.out.println(t1.isAlive() + " " + t4.isAlive());
		System.out.println("Main Over");

	}

}