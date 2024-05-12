package tester;

import java.util.Scanner;

import static utils.VehicleValidationRules.validateSpeed;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)){
			System.out.println("Enter Speed : ");
			validateSpeed(sc.nextInt());
			System.out.println("end of try....");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println("main over...");

	}

}
