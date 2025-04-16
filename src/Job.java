public class Job {
    private String title;
    private String description;
    private String experience;
    private double salary;
    private final int jobId;
    private static int idCounter = 1;
    private JobCategory category;

    public Job(String title, String description, String experience, double salary, JobCategory category) {
        this.title = title;
        this.description = description;
        this.experience = experience;
        this.salary = salary;
        this.jobId = idCounter++;
        this.category = category;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getExperience() { return experience; }
    public void setExperience(String experience) { this.experience = experience; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    public int getJobId() { return jobId; }
    public JobCategory getCategory() { return category; }
    public void setCategory(JobCategory category) { this.category = category; }

    @Override
    public String toString() {
        return "\t\tID: " + jobId + " | Title: " + title + "\n\t\tCategory: " + category.getName() +
                "\n\t\tExperience: " + experience + "\n\t\tSalary: $" + salary + "\n\t\tDescription: " + description;
    }
}