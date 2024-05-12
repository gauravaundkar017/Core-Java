package utils;
import java.util.Scanner;
import static utils.VehicleValidationRule.pollutionLevel;
import static utils.VehicleValidationRule.validateColor;

import color_enum.Color;
import custom_exception.InvalidVehicleException;
import vehicle_package.Vehicle;

public class UserInput {
	public static void menu() {
		
		System.out.println("Menu:");
        System.out.println("1. Add new vehicle");
        System.out.println("2. Drive a vehicle");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        
	}
	
	public static void addNewVehicle()  {
        System.out.println("Enter vehicle details:");
		try(Scanner sc = new Scanner(System.in)){
			System.out.print("Chassis No: ");
            String chassisNo = sc.nextLine();
            System.out.print("Color (WHITE, SILVER, BLACK, RED, BLUE): ");
            String colorStr = sc.nextLine();
            Color color = Color.valueOf(colorStr.toUpperCase());
            validateColor(color);
            System.out.print("Price: ");
            double price = sc.nextDouble();
            System.out.print("Pollution Level: ");
            double pollutionLevelInPer = sc.nextDouble();
            pollutionLevel(pollutionLevelInPer);
            Vehicle vehicle = new Vehicle(chassisNo, price, color, pollutionLevelInPer);
            System.out.println("Vehicle added successfully!");
            System.out.println(vehicle);


		}catch(InvalidVehicleException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
