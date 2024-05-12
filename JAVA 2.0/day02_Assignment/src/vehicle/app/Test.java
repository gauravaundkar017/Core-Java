package vehicle.app;

import java.util.Scanner;
import color_enum.Color;
import vehicle_package.Vehicle;
import static utils.UserInput.menu;
import static utils.UserInput.addNewVehicle;;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch;
		boolean exit = false;
		while (!exit) {
			menu();
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				addNewVehicle();
				break;

			case 2:
				System.out.println("Drive");
				break;
			case 3:

				System.out.println("Exiting...");
				exit = true;
				break;

			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}

	}

}
