package threads1;

public class MyClass extends Thread {
	// mandatory to override run()
	/*
	 * Rule : Method overriding n exception handling Overriding form of the method
	 * (sub class version) CANNOT throw any NEW or BROADER CHECKED exception
	 */

	public MyClass(String threadName) {
		super(threadName);
	}

	@Override
	public void run() /* throws InterruptedException */ {
		System.out.println(getName() + "Started");
		// BL -- for loop (10)
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(getName() + " exec count " + i);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println(getName() + " got exc " + e);
		}
		System.out.println(getName() + "Over");
	}
}
