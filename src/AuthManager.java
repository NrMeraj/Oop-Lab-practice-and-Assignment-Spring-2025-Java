import java.util.ArrayList;
import java.util.Scanner;

public class AuthManager implements Auth {
    private ArrayList<User> users = new ArrayList<>();
    private Admin admin = new Admin("admin", "admin123");

    @Override
    public void login(String username, String password) throws InvalidCredentialsException {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return;
            }
        }
        throw new InvalidCredentialsException("Invalid username or password!");
    }

    public void userLogin(Scanner scanner, JobManager jobManager, ApplicationManager appManager, ProfileManager profileManager) {
        JobPortal.clearScreen();
        System.out.println("\t\t====================================");
        System.out.println("\t\t|           User Login             |");
        System.out.println("\t\t====================================");
        try {
            System.out.print("\t\tEnter username: ");
            String username = scanner.nextLine();
            System.out.print("\t\tEnter password: ");
            String password = scanner.nextLine();
            login(username, password);
            User user = getUser(username);
            System.out.println("\t\tLogin successful! Welcome, " + username + "!");
            JobPortal.waitForKey();
            userMenu(user, scanner, jobManager, appManager, profileManager);
        } catch (InvalidCredentialsException e) {
            System.out.println("\t\t" + e.getMessage());
            JobPortal.waitForKey();
        }
    }

    public void adminLogin(Scanner scanner, JobManager jobManager, ApplicationManager appManager, SystemSummary summary) {
        JobPortal.clearScreen();
        System.out.println("\t\t====================================");
        System.out.println("\t\t|           Admin Login            |");
        System.out.println("\t\t====================================");
        try {
            System.out.print("\t\tEnter admin username: ");
            String username = scanner.nextLine();
            System.out.print("\t\tEnter admin password: ");
            String password = scanner.nextLine();
            if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                System.out.println("\t\tAdmin login successful!");
                JobPortal.waitForKey();
                admin.adminMenu(scanner, jobManager, appManager, summary);
            } else {
                throw new InvalidCredentialsException("Invalid admin credentials!");
            }
        } catch (InvalidCredentialsException e) {
            System.out.println("\t\t" + e.getMessage());
            JobPortal.waitForKey();
        }
    }

    public void registerUser(Scanner scanner, ProfileManager profileManager) {
        JobPortal.clearScreen();
        System.out.println("\t\t====================================");
        System.out.println("\t\t|         Register User            |");
        System.out.println("\t\t====================================");
        System.out.print("\t\tEnter username: ");
        String username = scanner.nextLine();
        System.out.print("\t\tEnter password: ");
        String password = scanner.nextLine();
        System.out.print("\t\tEnter email: ");
        String email = scanner.nextLine();
        System.out.print("\t\tEnter skills: ");
        String skills = scanner.nextLine();
        User user = new User(username, password, email, skills);
        users.add(user);
        profileManager.addProfile(user);
        System.out.println("\t\tUser registered successfully!");
        JobPortal.waitForKey();
    }

    public void manageUsers(Scanner scanner, ApplicationManager appManager) {
        while (true) {
            JobPortal.clearScreen();
            System.out.println("\t\t====================================");
            System.out.println("\t\t|         Manage Users             |");
            System.out.println("\t\t====================================");
            System.out.println("\t\t---------- User Menu --------------");
            System.out.println("\t\t1. View All Users");
            System.out.println("\t\t2. Delete User");
            System.out.println("\t\t3. Back");
            System.out.println("\t\t------------------------------------");
            int choice = InputHandler.getIntInput(scanner, "\t\tEnter choice: ");
            switch (choice) {
                case 1:
                    viewUsers(appManager);
                    break;
                case 2:
                    deleteUser(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("\t\tInvalid choice! Please try again.");
                    JobPortal.waitForKey();
            }
        }
    }

    private void viewUsers(ApplicationManager appManager) {
        JobPortal.clearScreen();
        System.out.println("\t\t====================================");
        System.out.println("\t\t|         Registered Users         |");
        System.out.println("\t\t====================================");
        if (users.isEmpty()) {
            System.out.println("\t\tNo registered users.");
        } else {
            System.out.println("\t\t----------- Users -----------------");
            for (User user : users) {
                System.out.println("\t\tUsername: " + user.getUsername());
                System.out.println("\t\tEmail: " + user.getEmail());
                System.out.println("\t\tSkills: " + user.getSkills());
                System.out.print("\t\tApplied Jobs: ");
                boolean hasApplied = false;
                for (JobApplication app : appManager.applications) {
                    if (app.getUser().getUsername().equals(user.getUsername())) {
                        System.out.print(app.getJob().getTitle() + ", ");
                        hasApplied = true;
                    }
                }
                if (!hasApplied) {
                    System.out.print("None");
                }
                System.out.println("\n\t\t------------------------------------");
            }
        }
        JobPortal.waitForKey();
    }

    private void deleteUser(Scanner scanner) {
        JobPortal.clearScreen();
        System.out.println("\t\t====================================");
        System.out.println("\t\t|         Delete User              |");
        System.out.println("\t\t====================================");
        System.out.print("\t\tEnter username to delete: ");
        String username = scanner.nextLine();
        boolean removed = users.removeIf(user -> user.getUsername().equals(username));
        if (removed) {
            System.out.println("\t\tUser deleted successfully!");
        } else {
            System.out.println("\t\tUser not found!");
        }
        JobPortal.waitForKey();
    }

    private User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public int getTotalUsers() {
        return users.size();
    }

    private void userMenu(User user, Scanner scanner, JobManager jobManager, ApplicationManager appManager, ProfileManager profileManager) {
        while (true) {
            JobPortal.clearScreen();
            System.out.println("\t\t====================================");
            System.out.println("\t\t|          User Dashboard          |");
            System.out.println("\t\t====================================");
            System.out.println("\t\t------------- User Menu ------------");
            System.out.println("\t\t1. View Jobs");
            System.out.println("\t\t2. Apply for Job");
            System.out.println("\t\t3. View My Applications");
            System.out.println("\t\t4. Update Profile");
            System.out.println("\t\t5. View Interview Notifications");
            System.out.println("\t\t6. Logout");
            System.out.println("\t\t------------------------------------");
            int choice = InputHandler.getIntInput(scanner, "\t\tEnter choice: ");
            switch (choice) {
                case 1:
                    jobManager.viewJobs();
                    break;
                case 2:
                    jobManager.viewJobs();
                    int id = InputHandler.getIntInput(scanner, "\t\tEnter job ID to apply: ");
                    Job job = null;
                    for (Job j : ((ConcreteJobManager) jobManager).jobs) {
                        if (j.getJobId() == id) {
                            job = j;
                            break;
                        }
                    }
                    if (job != null) {
                        appManager.applyForJob(user, job, scanner);
                    } else {
                        System.out.println("\t\tJob not found!");
                        JobPortal.waitForKey();
                    }
                    break;
                case 3:
                    appManager.viewUserApplications(user);
                    break;
                case 4:
                    profileManager.updateProfile(user, scanner);
                    break;
                case 5:
                    appManager.viewInterviews();
                    break;
                case 6:
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
