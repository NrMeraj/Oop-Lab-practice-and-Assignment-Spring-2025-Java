public class ApplicationStatus {
    private String status;

    public ApplicationStatus(String status) {
        this.status = status;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) {
        if (status.equals("Pending") || status.equals("Approved") || status.equals("Rejected") ||
                status.equals("Interview") || status.equals("Selected")) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid status!");
        }
    }
}