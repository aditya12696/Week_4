package resumescreeningsystem;

// Software Engineer job role implementation
public class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName) {
        super(candidateName);
    }

    @Override
    public String evaluateResume() {
        return getCandidateName() + " - Evaluated for Software Engineer role: Strong programming skills required.";
    }
}
