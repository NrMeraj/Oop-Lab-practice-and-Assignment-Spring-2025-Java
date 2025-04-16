import java.util.ArrayList;
import java.util.Scanner;

public abstract class JobManager {
    protected ArrayList<Job> jobs = new ArrayList<>();
    protected ArrayList<JobCategory> categories = new ArrayList<>();

    public abstract void addJob(Scanner scanner);

    public void viewJobs() {
        JobPortal.clearScreen();
        System.out.println("\t\t====================================");
        System.out.println("\t\t|           Job Listings           |");
        System.out.println("\t\t====================================");
        if (jobs.isEmpty()) {
            System.out.println("\t\tNo jobs available.");
        } else {
            System.out.println("\t\t------------ Jobs -----------------");
            for (Job job : jobs) {
                System.out.println(job);
                System.out.println("\t\t------------------------------------");
            }
        }
        JobPortal.waitForKey();
    }

    public void manageCategories(Scanner scanner) {
        while (true) {
            JobPortal.clearScreen();
            System.out.println("\t\t====================================");
            System.out.println("\t\t|       Manage Job Categories      |");
            System.out.println("\t\t====================================");
            System.out.println("\t\t---------- Category Menu ----------");
            System.out.println("\t\t1. Add Category");
            System.out.println("\t\t2. Delete Category");
            System.out.println("\t\t3. View Categories");
            System.out.println("\t\t4. Back");
            System.out.println("\t\t------------------------------------");
            int choice = InputHandler.getIntInput(scanner, "\t\tEnter choice: ");
            switch (choice) {
                case 1:
                    System.out.print("\t\tEnter category name: ");
                    String name = scanner.nextLine();
                    System.out.print("\t\tEnter category description: ");
                    String desc = scanner.nextLine();
                    categories.add(new JobCategory(name, desc));
                    System.out.println("\t\tCategory added successfully!");
                    JobPortal.waitForKey();
                    break;
                case 2:
                    viewCategories();
                    int id = InputHandler.getIntInput(scanner, "\t\tEnter category ID to delete: ");
                    try {
                        boolean removed = categories.removeIf(cat -> cat.getCategoryId() == id);
                        if (!removed) {
                            throw new CategoryNotFoundException("Category ID " + id + " not found!");
                        }
                        jobs.removeIf(job -> job.getCategory().getCategoryId() == id);
                        System.out.println("\t\tCategory and associated jobs deleted!");
                    } catch (CategoryNotFoundException e) {
                        System.out.println("\t\t" + e.getMessage());
                    }
                    JobPortal.waitForKey();
                    break;
                case 3:
                    viewCategories();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("\t\tInvalid choice! Please try again.");
                    JobPortal.waitForKey();
            }
        }
    }

    void viewCategories() {
        JobPortal.clearScreen();
        System.out.println("\t\t====================================");
        System.out.println("\t\t|        Job Categories            |");
        System.out.println("\t\t====================================");
        if (categories.isEmpty()) {
            System.out.println("\t\tNo categories available.");
        } else {
            System.out.println("\t\t--------- Categories --------------");
            for (JobCategory cat : categories) {
                System.out.println(cat);
                System.out.println("\t\t------------------------------------");
            }
        }
        JobPortal.waitForKey();
    }

    public void manageJobs(Scanner scanner) {
        while (true) {
            JobPortal.clearScreen();
            System.out.println("\t\t====================================");
            System.out.println("\t\t|         Manage Job Posts         |");
            System.out.println("\t\t====================================");
            System.out.println("\t\t----------- Job Menu --------------");
            System.out.println("\t\t1. Add Job");
            System.out.println("\t\t2. Update Job");
            System.out.println("\t\t3. Delete Job");
            System.out.println("\t\t4. View Jobs");
            System.out.println("\t\t5. Back");
            System.out.println("\t\t------------------------------------");
            int choice = InputHandler.getIntInput(scanner, "\t\tEnter choice: ");
            switch (choice) {
                case 1:
                    addJob(scanner);
                    break;
                case 2:
                    updateJob(scanner);
                    break;
                case 3:
                    deleteJob(scanner);
                    break;
                case 4:
                    viewJobs();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("\t\tInvalid choice! Please try again.");
                    JobPortal.waitForKey();
            }
        }
    }

    private void updateJob(Scanner scanner) {
        viewJobs();
        int id = InputHandler.getIntInput(scanner, "\t\tEnter job ID to update: ");
        for (Job job : jobs) {
            if (job.getJobId() == id) {
                System.out.print("\t\tEnter new title: ");
                String title = scanner.nextLine();
                System.out.print("\t\tEnter new description: ");
                String desc = scanner.nextLine();
                System.out.print("\t\tEnter new experience: ");
                String exp = scanner.nextLine();
                double salary = InputHandler.getDoubleInput(scanner, "\t\tEnter new salary: ");
                viewCategories();
                int catId = InputHandler.getIntInput(scanner, "\t\tEnter category ID: ");
                JobCategory category = null;
                for (JobCategory cat : categories) {
                    if (cat.getCategoryId() == catId) {
                        category = cat;
                        break;
                    }
                }
                if (category == null) {
                    System.out.println("\t\tCategory not found!");
                } else {
                    job.setTitle(title);
                    job.setDescription(desc);
                    job.setExperience(exp);
                    job.setSalary(salary);
                    job.setCategory(category);
                    System.out.println("\t\tJob updated successfully!");
                }
                JobPortal.waitForKey();
                return;
            }
        }
        System.out.println("\t\tJob not found!");
        JobPortal.waitForKey();
    }

    private void deleteJob(Scanner scanner) {
        viewJobs();
        int id = InputHandler.getIntInput(scanner, "\t\tEnter job ID to delete: ");
        try {
            boolean removed = jobs.removeIf(job -> job.getJobId() == id);
            if (!removed) {
                throw new JobNotFoundException("Job ID " + id + " not found!");
            }
            System.out.println("\t\tJob deleted successfully!");
        } catch (JobNotFoundException e) {
            System.out.println("\t\t" + e.getMessage());
        }
        JobPortal.waitForKey();
    }
}

