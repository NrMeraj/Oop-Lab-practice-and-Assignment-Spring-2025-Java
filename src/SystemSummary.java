public class SystemSummary {
    public void displaySummary(ApplicationManager appManager, JobManager jobManager, AuthManager authManager) {
        JobPortal.clearScreen();
        System.out.println("\t\t====================================");
        System.out.println("\t\t|         System Summary           |");
        System.out.println("\t\t====================================");
        System.out.println("\t\t---------- Summary ----------------");
        System.out.println("\t\tTotal Registered Users: " + authManager.getTotalUsers());
        System.out.println("\t\tTotal Job Categories: " + ((ConcreteJobManager) jobManager).categories.size());
        System.out.println("\t\tTotal Job Posts: " + ((ConcreteJobManager) jobManager).jobs.size());
        System.out.println("\t\tTotal Applications: " + appManager.getTotalApplications());
        System.out.println("\t\tTotal Selected Applicants: " + appManager.getTotalSelected());
        System.out.println("\t\t------------------------------------");
        JobPortal.waitForKey();
    }
}