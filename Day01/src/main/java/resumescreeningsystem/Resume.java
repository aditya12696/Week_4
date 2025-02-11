package resumescreeningsystem;

// Generic class for handling resumes for different job roles
public class Resume<T extends JobRole> {
    private String resumeId;
    private T jobRole;

    // Constructor initializes resume ID and job role
    public Resume(String resumeId, T jobRole) {
        this.resumeId = resumeId;
        this.jobRole = jobRole;
    }

    // Getter for resume ID
    public String getResumeId() {
        return resumeId;
    }

    // Getter for job role
    public T getJobRole() {
        return jobRole;
    }

    // Display resume information
    public void displayResumeInfo() {
        System.out.println("Resume ID: " + resumeId + " | " + jobRole.evaluateResume());
    }
}

