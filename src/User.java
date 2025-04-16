public class User {
    private String username;
    private String password;
    private String email;
    private String skills;

    public User(String username, String password, String email, String skills) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.skills = skills;
    }

    public User(String username, String password) {
        this(username, password, "no-email", "no-skills");
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }

    public void displayRole() {
        System.out.println("\t\tRole: User");
    }
}