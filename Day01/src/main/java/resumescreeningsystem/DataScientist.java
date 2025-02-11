package resumescreeningsystem;

// Data Scientist job role implementation
public class DataScientist extends JobRole {
    public DataScientist(String candidateName) {
        super(candidateName);
    }

    @Override
    public String evaluateResume() {
        return getCandidateName() + " - Evaluated for Data Scientist role: Proficiency in data analysis, ML, and statistics required.";
    }
}

