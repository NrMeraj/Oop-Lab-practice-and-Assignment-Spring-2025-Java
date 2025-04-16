import java.util.ArrayList;
import java.util.Scanner;

public class ProfileManager {
    private ArrayList<User> profiles = new ArrayList<>();

    public void addProfile(User user) {
        profiles.add(user);
    }

    public void updateProfile(User user, Scanner scanner) {
        JobPortal.clearScreen();
        System.out.println("\t\t====================================");
        System.out.println("\t\t|         Update Profile           |");
        System.out.println("\t\t====================================");
        System.out.print("\t\tEnter new email: ");
        String email = scanner.nextLine();
        System.out.print("\t\tEnter new skills: ");
        String skills = scanner.nextLine();
        user.setEmail(email);
        user.setSkills(skills);
        System.out.println("\t\tProfile updated successfully!");
        JobPortal.waitForKey();
    }
}