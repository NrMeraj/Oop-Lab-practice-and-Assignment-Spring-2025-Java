import java.util.Scanner;

class ConcreteJobManager extends JobManager {
    @Override
    public void addJob(Scanner scanner) {
        JobPortal.clearScreen();
        System.out.println("\t\t====================================");
        System.out.println("\t\t|           Add New Job            |");
        System.out.println("\t\t====================================");
        System.out.print("\t\tEnter job title: ");
        String title = scanner.nextLine();
        System.out.print("\t\tEnter job description: ");
        String description = scanner.nextLine();
        System.out.print("\t\tEnter experience required: ");
        String experience = scanner.nextLine();
        double salary = InputHandler.getDoubleInput(scanner, "\t\tEnter salary: ");
        super.viewCategories();
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
            jobs.add(new Job(title, description, experience, salary, category));
            System.out.println("\t\tJob added successfully!");
        }
        JobPortal.waitForKey();
    }

    // Method Overloading
    public void addJob(String title, String description, String experience, double salary, String catName) {
        JobCategory category = new JobCategory(catName, "Default category");
        jobs.add(new Job(title, description, experience, salary, category));
        System.out.println("\t\tJob added successfully!");
        JobPortal.waitForKey();
    }
}