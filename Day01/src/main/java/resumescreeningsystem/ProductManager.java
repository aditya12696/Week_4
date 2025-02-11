package resumescreeningsystem;

// Product Manager job role implementation
public class ProductManager extends JobRole {
    public ProductManager(String candidateName) {
        super(candidateName);
    }

    @Override
    public String evaluateResume() {
        return getCandidateName() + " - Evaluated for Product Manager role: Strong leadership and strategic skills required.";
    }
}

