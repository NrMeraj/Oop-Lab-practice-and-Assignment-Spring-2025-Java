import java.util.Scanner;

public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void displayRole() {
        System.out.println("\t\tRole: Admin");
    }

    public void adminMenu(Scanner scanner, JobManager jobManager, ApplicationManager appManager, SystemSummary summary) {
        while (true) {
            JobPortal.clearScreen();
            System.out.println("\t\t====================================");
            System.out.println("\t\t|          Admin Dashboard          |");
            System.out.println("\t\t====================================");
            System.out.println("\t\t------------- Admin Menu -----------");
            System.out.println("\t\t1. View System Summary");
            System.out.println("\t\t2. Manage Job Categories");
            System.out.println("\t\t3. Manage Job Posts");
            System.out.println("\t\t4. Manage Users");
            System.out.println("\t\t5. Manage Applications");
            System.out.println("\t\t6. Manage Interview Schedules");
            System.out.println("\t\t7. Logout");
            System.out.println("\t\t------------------------------------");
            int choice = InputHandler.getIntInput(scanner, "\t\tEnter choice: ");
            switch (choice) {
                case 1:
                    summary.displaySummary(appManager, jobManager, JobPortal.authManager);
                    break;
                case 2:
                    jobManager.manageCategories(scanner);
                    break;
                case 3:
                    jobManager.manageJobs(scanner);
                    break;
                case 4:
                    JobPortal.authManager.manageUsers(scanner, appManager);
                    break;
                case 5:
                    appManager.manageApplications(scanner);
                    break;
                case 6:
                    appManager.manageInterviews(scanner);
                    break;
                case 7:
                    System.out.println("\t\tLogging out...");
                    JobPortal.waitForKey();
                    return;
                default:
                    System.out.println("\t\tInvalid choice! Please try again.");
                    JobPortal.waitForKey();
            }
        }
    }
}