package threads2;

public class MyClass implements Runnable {
	// mandatory to implement run()
	/*
	 * Rule : Method overriding n exception handling Overriding form of the method
	 * (sub class version) CANNOT throw any NEW or BROADER CHECKED exception
	 */


	@Override
	public void run() /* throws InterruptedException */ {
		System.out.println(Thread.currentThread().getName() + " Started ");
		// BL -- for loop (10)
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + " exec count " + i);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + " got exc " + e);
		}
		System.out.println(Thread.currentThread().getName() + "Over");
	}
}
