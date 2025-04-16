public class JobApplication {
    private User user;
    private Job job;
    private String coverLetter;
    private ApplicationStatus status;

    public JobApplication(User user, Job job, String coverLetter) {
        this.user = user;
        this.job = job;
        this.coverLetter = coverLetter;
        this.status = new ApplicationStatus("Pending");
    }

    public User getUser() { return user; }
    public Job getJob() { return job; }
    public String getCoverLetter() { return coverLetter; }
    public ApplicationStatus getStatus() { return status; }
    public void setStatus(String status) { this.status.setStatus(status); }

    @Override
    public String toString() {
        return "\t\tUser: " + user.getUsername() + " | Job: " + job.getTitle() +
                "\n\t\tStatus: " + status.getStatus() + "\n\t\tCover Letter: " + coverLetter;
    }
}