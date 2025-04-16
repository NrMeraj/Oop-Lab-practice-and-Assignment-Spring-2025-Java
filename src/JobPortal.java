import java.util.Scanner;

public class JobPortal {
    private static Scanner scanner = new Scanner(System.in);
    static AuthManager authManager = new AuthManager();
    private static JobManager jobManager = new ConcreteJobManager();
    private static ApplicationManager appManager = new ApplicationManager();
    private static ProfileManager profileManager = new ProfileManager();
    private static SystemSummary summary = new SystemSummary();

    public static void main(String[] args) {
        while (true) {
            displayBanner();
            showMainMenu();
            int choice = InputHandler.getIntInput(scanner, "\t\tEnter choice: ");
            handleMenuChoice(choice);
        }
    }
    

    private static void displayBanner() {
        clearScreen();
        System.out.println("\t\t====================================");
        System.out.println("\t\t|   Job Portal Management System   |");
        System.out.println("\t\t====================================");
        System.out.println();
    }

    private static void showMainMenu() {
        System.out.println("\t\t------------- Main Menu ------------");
        System.out.println("\t\t1. User Login");
        System.out.println("\t\t2. Admin Login");
        System.out.println("\t\t3. Register User");
        System.out.println("\t\t4. Exit");
        System.out.println("\t\t------------------------------------");
    }

    private static void handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                authManager.userLogin(scanner, jobManager, appManager, profileManager);
                break;
            case 2:
                authManager.adminLogin(scanner, jobManager, appManager, summary);
                break;
            case 3:
                authManager.registerUser(scanner, profileManager);
                break;
            case 4:
                System.out.println("\t\tThank you for using the Job Portal!");
                System.exit(0);
            default:
                System.out.println("\t\tInvalid choice! Please try again.");
                waitForKey();
        }
    }

    public static void clearScreen() {
        System.out.println("\n".repeat(50));
    }

    public static void waitForKey() {
        System.out.println("\t\tPress Enter to go back...");
        scanner.nextLine();
    }
}