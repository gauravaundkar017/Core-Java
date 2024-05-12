package utils;


import custom_exception.SpeedOutOfRangeException;

public class VehicleValidationRules {
	public static final int MIN_SPEED;
	public static final int MAX_SPEED;
	static {
		MIN_SPEED = 40;
		MAX_SPEED = 80;
	}
	public static void validateSpeed(int speed) throws SpeedOutOfRangeException {
		if (speed > MAX_SPEED) {
			throw new SpeedOutOfRangeException("Too fast");
		}
		if (speed < MIN_SPEED) {
			throw new SpeedOutOfRangeException("Too slow");
		}
		System.out.println("speed within range .....");

	}
}
