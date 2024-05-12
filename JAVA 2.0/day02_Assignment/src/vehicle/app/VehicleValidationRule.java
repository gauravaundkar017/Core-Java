package vehicle.app;

import color_enum.Color;
import custom_exception.InvalidVehicleException;

public class VehicleValidationRule {
	public static final int POLLUTION_LEVEL;
	static {
		POLLUTION_LEVEL = 20;
	}
	
	public static void pollutionLevel(double pollutionLevel) throws InvalidVehicleException{
		if (pollutionLevel < POLLUTION_LEVEL) {
			throw new InvalidVehicleException("Pollution level exceeds 20%");
		}
	}
	
	
//	public static void validateColor(Color color) throws InvalidVehicleException {
//	    // Check if the given color is present in the Color enum
//	    for (Color supportedColor : Color.values()) {
//	        if (supportedColor.equals(color)) {
//	            return; // Color is valid, so return without throwing an exception
//	        }
//	    }
//	    // If no match found, throw an exception
//	    throw new InvalidVehicleException("Invalid color specified!");
//	}

}
