package vehicle.app;

import java.util.Scanner;

import vehicle.app.Color;
import vehicle.app.InvalidVehicleException;
import vehicle.app.Vehicle;
import static vehicle.app.VehicleValidationRule.pollutionLevel;

public class UserInput {
    public static void menu() {
        System.out.println("Menu:");
        System.out.println("1. Add new vehicle");
        System.out.println("2. Drive a vehicle");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

//    public static Vehicle addNewVehicle() throws InvalidVehicleException {
//        System.out.println("Enter vehicle details:");
//
//        try (Scanner sc = new Scanner(System.in)) {
//            System.out.print("Chassis No: ");
//            String chassisNo = sc.nextLine();
//            System.out.print("Color (WHITE, SILVER, BLACK, RED, BLUE): ");
//            String colorStr = sc.nextLine();
//            Color color = Color.valueOf(colorStr.toUpperCase());
//            // validateColor(color); // This method is not used anymore
//            System.out.print("Price: ");
//            double price = sc.nextDouble();
//            System.out.print("Pollution Level: ");
//            double pollutionLevelInPer = sc.nextDouble();
////            pollutionLevel(pollutionLevelInPer);
////            return new Vehicle(chassisNo, price, color, pollutionLevelInPer);
////            System.out.println("Vehicle added successfully!");
////            System.out.println(vehicle);
//        }

//    }
}
