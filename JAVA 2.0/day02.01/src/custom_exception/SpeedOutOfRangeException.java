package custom_exception;

@SuppressWarnings("serial")
public class SpeedOutOfRangeException extends Exception{
	public SpeedOutOfRangeException(String msg) {
		super(msg);
	}
}
