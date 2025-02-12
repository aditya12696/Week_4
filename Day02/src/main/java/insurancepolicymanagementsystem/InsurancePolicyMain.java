package insurancepolicymanagementsystem;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class InsurancePolicyMain {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        // Adding sample policies
        manager.addPolicy(new InsurancePolicy("P001", "John Doe", LocalDate.now().plusDays(10), "Health", 500.0));
        manager.addPolicy(new InsurancePolicy("P002", "Jane Doe", LocalDate.now().plusDays(40), "Auto", 700.0));
        manager.addPolicy(new InsurancePolicy("P003", "Alice", LocalDate.now().plusDays(5), "Health", 450.0));
        manager.addPolicy(new InsurancePolicy("P004", "Bob", LocalDate.now().plusDays(25), "Home", 600.0));
        manager.addPolicy(new InsurancePolicy("P005", "Charlie", LocalDate.now().plusDays(15), "Auto", 750.0));
        manager.addPolicy(new InsurancePolicy("P001", "Duplicate John", LocalDate.now().plusDays(15), "Home", 600.0)); // Duplicate policy

        // Display all policies
        System.out.println("All Unique Policies:");
        Set<InsurancePolicy> allPolicies = manager.getAllPolicies();
        allPolicies.forEach(System.out::println);

        // Retrieve policies expiring soon (within 30 days)
        System.out.println("\nPolicies Expiring Soon:");
        List<InsurancePolicy> expiringSoon = manager.getPoliciesExpiringSoon();
        expiringSoon.forEach(System.out::println);

        // Retrieve policies by coverage type
        System.out.println("\nAuto Insurance Policies:");
        List<InsurancePolicy> autoPolicies = manager.getPoliciesByCoverageType("Auto");
        autoPolicies.forEach(System.out::println);

        // Retrieve duplicate policies
        System.out.println("\nDuplicate Policies:");
        Set<InsurancePolicy> duplicatePolicies = manager.getDuplicatePolicies();
        duplicatePolicies.forEach(System.out::println);

        // Compare performance
        System.out.println("\nPerformance Comparison:");
        manager.comparePerformance();
    }
}
