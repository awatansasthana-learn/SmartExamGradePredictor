import java.util.Scanner;

public class InputValidator {

    public static double getMarks(Scanner scanner, String message, double maximum) {

        while (true) {
            System.out.print(message);

            try {
                double marks = Double.parseDouble(scanner.nextLine());

                if (marks < 0 || marks > maximum) {
                    System.out.println("Invalid marks! Enter between 0 and " + maximum);
                } else {
                    return marks;
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static String getNonEmptyInput(Scanner scanner, String message) {

        while (true) {
            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty.");
        }
    }
}