import java.util.Scanner;

public class InputHandler {
    public static int getIntInput(Scanner scanner, String prompt) {
        int input = 0;
        try {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                throw new InvalidInputException("Please enter a valid number!");
            }
        } catch (InvalidInputException e) {
            System.out.println("\t\t" + e.getMessage());
            JobPortal.waitForKey();
            return getIntInput(scanner, prompt);
        } catch (Exception e) {
            System.out.println("\t\tUnexpected error: " + e.getMessage());
            JobPortal.waitForKey();
        } finally {
            System.out.println("\t\tInput processing complete.");
        }
        return input;
    }

    public static double getDoubleInput(Scanner scanner, String prompt) {
        double input = 0;
        try {
            System.out.print(prompt);
            try {
                input = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                throw new InvalidInputException("Please enter a valid number!");
            }
        } catch (InvalidInputException e) {
            System.out.println("\t\t" + e.getMessage());
            JobPortal.waitForKey();
            return getDoubleInput(scanner, prompt);
        } catch (Exception e) {
            System.out.println("\t\tUnexpected error: " + e.getMessage());
            JobPortal.waitForKey();
        } finally {
            System.out.println("\t\tInput processing complete.");
        }
        return input;
    }
}