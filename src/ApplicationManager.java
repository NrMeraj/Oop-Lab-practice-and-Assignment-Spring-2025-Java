import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationManager {
    ArrayList<JobApplication> applications = new ArrayList<>();
    private ArrayList<InterviewSchedule> interviews = new ArrayList<>();


    public void applyForJob(User user, Job job, Scanner scanner) {
        JobPortal.clearScreen();
        System.out.println("\t\t====================================");
        System.out.println("\t\t|         Apply for Job            |");
        System.out.println("\t\t====================================");
        System.out.print("\t\tEnter cover letter: ");
        String coverLetter = scanner.nextLine();
        applications.add(new JobApplication(user, job, coverLetter));
        System.out.println("\t\tApplication submitted successfully!");
        JobPortal.waitForKey();
    }

    public void applyForJob(User user, Job job, String coverLetter) {
        applications.add(new JobApplication(user, job, coverLetter));
        System.out.println("\t\tApplication submitted successfully!");
        JobPortal.waitForKey();
    }

    public void viewApplications() {
        JobPortal.clearScreen();
        System.out.println("\t\t====================================");
        System.out.println("\t\t|        All Applications          |");
        System.out.println("\t\t====================================");
        if (applications.isEmpty()) {
            System.out.println("\t\tNo applications.");
        } else {
            System.out.println("\t\t--------- Applications ------------");
            for (JobApplication app : applications) {
                System.out.println(app);
                System.out.println("\t\t------------------------------------");
            }
        }
        JobPortal.waitForKey();
    }

    public void viewUserApplications(User user) {
        JobPortal.clearScreen();
        System.out.println("\t\t====================================");
        System.out.println("\t\t|       My Applications            |");
        System.out.println("\t\t====================================");
        boolean found = false;
        System.out.println("\t\t--------- Applications ------------");
        for (JobApplication app : applications) {
            if (app.getUser().getUsername().equals(user.getUsername())) {
                System.out.println(app);
                System.out.println("\t\t------------------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("\t\tNo applications found.");
        }
        JobPortal.waitForKey();
    }

    public void manageApplications(Scanner scanner) {
        while (true) {
            JobPortal.clearScreen();
            System.out.println("\t\t====================================");
            System.out.println("\t\t|      Manage Applications         |");
            System.out.println("\t\t====================================");
            System.out.println("\t\t------- Application Menu ----------");
            System.out.println("\t\t1. View Applicants for Job");
            System.out.println("\t\t2. Approve/Reject Application");
            System.out.println("\t\t3. Call for Interview");
            System.out.println("\t\t4. Mark as Selected");
            System.out.println("\t\t5. Back");
            System.out.println("\t\t------------------------------------");
            int choice = InputHandler.getIntInput(scanner, "\t\tEnter choice: ");
            switch (choice) {
                case 1:
                    viewApplicantsByJob(scanner);
                    break;
                case 2:
                    updateApplicationStatus(scanner);
                    break;
                case 3:
                    callForInterview(scanner);
                    break;
                case 4:
                    markAsSelected(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("\t\tInvalid choice! Please try again.");
                    JobPortal.waitForKey();
            }
        }
    }

    private void viewApplicantsByJob(Scanner scanner) {
        JobPortal.clearScreen();
        System.out.println("\t\t====================================");
        System.out.println("\t\t|      Applicants by Job           |");
        System.out.println("\t\t====================================");
        int jobId = InputHandler.getIntInput(scanner, "\t\tEnter job ID: ");
        boolean found = false;
        System.out.println("\t\t--------- Applicants --------------");
        for (JobApplication app : applications) {
            if (app.getJob().getJobId() == jobId) {
                System.out.println(app);
                System.out.println("\t\t------------------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("\t\tNo applicants for this job.");
        }
        JobPortal.waitForKey();
    }

    private void updateApplicationStatus(Scanner scanner) {
        JobPortal.clearScreen();
        System.out.println("\t\t====================================");
        System.out.println("\t\t|     Update Application Status     |");
        System.out.println("\t\t====================================");
        viewApplications();
        int jobId = InputHandler.getIntInput(scanner, "\t\tEnter job ID: ");
        System.out.print("\t\tEnter username: ");
        String username = scanner.nextLine();
        System.out.print("\t\tEnter status (Approved/Rejected): ");
        String status = scanner.nextLine();
        boolean found = false;
        for (JobApplication app : applications) {
            if (app.getJob().getJobId() == jobId && app.getUser().getUsername().equals(username)) {
                app.setStatus(status);
                System.out.println("\t\tStatus updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\t\tApplication not found!");
        }
        JobPortal.waitForKey();
    }

    private void callForInterview(Scanner scanner) {
        JobPortal.clearScreen();
        System.out.println("\t\t====================================");
        System.out.println("\t\t|       Call for Interview         |");
        System.out.println("\t\t====================================");
        viewApplications();
        int jobId = InputHandler.getIntInput(scanner, "\t\tEnter job ID: ");
        System.out.print("\t\tEnter username: ");
        String username = scanner.nextLine();
        System.out.print("\t\tEnter interview date (e.g., 2025-05-01): ");
        String date = scanner.nextLine();
        boolean found = false;
        for (JobApplication app : applications) {
            if (app.getJob().getJobId() == jobId && app.getUser().getUsername().equals(username)) {
                app.setStatus("Interview");
                interviews.add(new InterviewSchedule(username, jobId, date));
                System.out.println("\t\tInterview scheduled! Notification sent to " + username + ".");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\t\tApplication not found!");
        }
        JobPortal.waitForKey();
    }

    private void markAsSelected(Scanner scanner) {
        JobPortal.clearScreen();
        System.out.println("\t\t====================================");
        System.out.println("\t\t|        Mark as Selected          |");
        System.out.println("\t\t====================================");
        viewApplications();
        int jobId = InputHandler.getIntInput(scanner, "\t\tEnter job ID: ");
        System.out.print("\t\tEnter username: ");
        String username = scanner.nextLine();
        boolean found = false;
        for (JobApplication app : applications) {
            if (app.getJob().getJobId() == jobId && app.getUser().getUsername().equals(username)) {
                app.setStatus("Selected");
                System.out.println("\t\tApplicant marked as selected!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\t\tApplication not found!");
        }
        JobPortal.waitForKey();
    }

    public void manageInterviews(Scanner scanner) {
        while (true) {
            JobPortal.clearScreen();
            System.out.println("\t\t====================================");
            System.out.println("\t\t|     Manage Interviews            |");
            System.out.println("\t\t====================================");
            System.out.println("\t\t-------- Interview Menu -----------");
            System.out.println("\t\t1. Schedule Interview");
            System.out.println("\t\t2. View Scheduled Interviews");
            System.out.println("\t\t3. Back");
            System.out.println("\t\t------------------------------------");
            int choice = InputHandler.getIntInput(scanner, "\t\tEnter choice: ");
            switch (choice) {
                case 1:
                    callForInterview(scanner);
                    break;
                case 2:
                    viewInterviews();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("\t\tInvalid choice! Please try again.");
                    JobPortal.waitForKey();
            }
        }
    }

    void viewInterviews() {
        JobPortal.clearScreen();
        System.out.println("\t\t====================================");
        System.out.println("\t\t|     Scheduled Interviews         |");
        System.out.println("\t\t====================================");
        if (interviews.isEmpty()) {
            System.out.println("\t\tNo interviews scheduled.");
        } else {
            System.out.println("\t\t-------- Interviews --------------");
            for (InterviewSchedule interview : interviews) {
                System.out.println(interview);
                System.out.println("\t\t------------------------------------");
            }
        }
        JobPortal.waitForKey();
    }

    public void viewUserProfiles() {
        JobPortal.clearScreen();
        System.out.println("\t\t====================================");
        System.out.println("\t\t|         User Profiles            |");
        System.out.println("\t\t====================================");
        if (applications.isEmpty()) {
            System.out.println("\t\tNo user profiles available.");
        } else {
            System.out.println("\t\t---------- Profiles --------------");
            for (JobApplication app : applications) {
                User user = app.getUser();
                System.out.println("\t\tUsername: " + user.getUsername());
                System.out.println("\t\tEmail: " + user.getEmail());
                System.out.println("\t\tSkills: " + user.getSkills());
                System.out.println("\t\t------------------------------------");
            }
        }
        JobPortal.waitForKey();
    }

    public int getTotalApplications() {
        return applications.size();
    }

    public int getTotalSelected() {
        int count = 0;
        for (JobApplication app : applications) {
            if (app.getStatus().getStatus().equals("Selected")) {
                count++;
            }
        }
        return count;
    }
}