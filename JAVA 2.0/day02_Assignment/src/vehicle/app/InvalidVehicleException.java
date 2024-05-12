package vehicle.app;

@SuppressWarnings("serial")
public class InvalidVehicleException extends Exception{
	public InvalidVehicleException() {
		// TODO Auto-generated constructor stub
		super("Vehicle Exception");
	}
	
	public InvalidVehicleException (String s) {
		super(s);
	}
}
