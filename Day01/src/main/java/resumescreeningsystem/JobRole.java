package resumescreeningsystem;

// Abstract class representing a job role
public abstract class JobRole {
    private String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    // Abstract method to evaluate the resume
    public abstract String evaluateResume();
}

