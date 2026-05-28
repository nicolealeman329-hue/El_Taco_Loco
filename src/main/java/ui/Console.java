package ui;

import java.util.Scanner;

public class Console {
    private Scanner scanner = new Scanner(System.in);

    public int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    public int readIntInRange(int min, int max) {
        while (true) {
            int value = readInt();
            if (value >= min && value <= max) {
                return value;
            }
            System.out.print("Please enter a number from " + min + " to " + max + ": ");
        }
    }

    public String readString() {
        return scanner.nextLine();
    }

    public boolean readYesNo() {
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
                return true;
            }
            if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) {
                return false;
            }
            System.out.print("Please enter y or n: ");
        }
    }
}
