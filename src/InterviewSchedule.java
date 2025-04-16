public class InterviewSchedule {
    private String username;
    private int jobId;
    private String date;

    public InterviewSchedule(String username, int jobId, String date) {
        this.username = username;
        this.jobId = jobId;
        this.date = date;
    }

    @Override
    public String toString() {
        return "\t\tUser: " + username + " | Job ID: " + jobId + " | Date: " + date;
    }
}