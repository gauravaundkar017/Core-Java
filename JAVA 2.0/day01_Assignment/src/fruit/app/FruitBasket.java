package fruit.app;

import java.util.Scanner;

public class FruitBasket {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of basket : ");
        int size = sc.nextInt();
        Fruit[] fruits = new Fruit[size];
        int count = 0;

        while (true) {
            System.out.println("Menu : ");
            System.out.println("1. Add Mango\n2. Add Apple\n3. Add Orange\n4. Display names of Fruits\n5. Display name, color, weight, and taste of all fresh fruits\n6. Mark a fruit as stale\n7. Mark all sour fruits as stale\n8. Invoke fruit specific functionality\n9. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String mangoName = sc.next();
                    System.out.print("Color: ");
                    String mangoColor = sc.next();
                    System.out.print("Weight: ");
                    double mangoWeight = sc.nextDouble();
                    fruits[count++] = new Mango(mangoColor, mangoWeight, mangoName, true);
                    break;

                case 2:
                    System.out.print("Name: ");
                    String appleName = sc.next();
                    System.out.print("Color: ");
                    String appleColor = sc.next();
                    System.out.print("Weight: ");
                    double appleWeight = sc.nextDouble();
                    fruits[count++] = new Apple(appleColor, appleWeight, appleName, true);
                    break;

                case 3:
                    System.out.print("Name: ");
                    String orangeName = sc.next();
                    System.out.print("Color: ");
                    String orangeColor = sc.next();
                    System.out.print("Weight: ");
                    double orangeWeight = sc.nextDouble();
                    fruits[count++] = new Orange(orangeColor, orangeWeight, orangeName, true);
                    break;

                case 4:
                    System.out.println("Names of Fruits in the Basket:");
                    for (int i = 0; i < count; i++) {
                        System.out.println(fruits[i].getName());
                    }
                    break;

                case 5:
                    System.out.println("Details of all fresh fruits in the basket:");
                    for (int i = 0; i < count; i++) {
                        if (fruits[i].isFresh()) {
                            System.out.println(fruits[i].getName() + " - Color: " + fruits[i].getColor() + ", Weight: " + fruits[i].getWeight() + "kg, Taste: " + fruits[i].taste());
                        }
                    }
                    break;

                case 6:
                    System.out.print("Enter index of the fruit to mark as stale: ");
                    int staleIndex = sc.nextInt();
                    if (staleIndex >= 0 && staleIndex < count) {
                        fruits[staleIndex].setFresh(false);
                        System.out.println(fruits[staleIndex].getName() + " marked as stale.");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 7:
                    System.out.println("Marking all sour fruits as stale:");
                    for (int i = 0; i < count; i++) {
                        if (fruits[i].taste().equals("sour")) {
                            fruits[i].setFresh(false);
                            System.out.println(fruits[i].getName() + " marked as stale.");
                        }
                    }
                    break;

                case 8:
                    System.out.print("Enter index of the fruit to invoke specific functionality: ");
                    int funcIndex = sc.nextInt();
                    if (funcIndex >= 0 && funcIndex < count) {
                        Fruit selectedFruit = fruits[funcIndex];
                        if (selectedFruit instanceof Mango) {
                            ((Mango) selectedFruit).pulp();
                        } else if (selectedFruit instanceof Apple) {
                            ((Apple) selectedFruit).jam();
                        } else if (selectedFruit instanceof Orange) {
                            ((Orange) selectedFruit).juice();
                        }
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 9.");
            }
        }
    }
}