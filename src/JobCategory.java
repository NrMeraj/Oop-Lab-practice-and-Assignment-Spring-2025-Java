public class JobCategory {
    private String name;
    private String description;
    private final int categoryId;
    private static int idCounter = 1;

    public JobCategory(String name, String description) {
        this.name = name;
        this.description = description;
        this.categoryId = idCounter++;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getCategoryId() { return categoryId; }

    @Override
    public String toString() {
        return "\t\tID: " + categoryId + " | Name: " + name + "\n\t\tDescription: " + description;
    }
}