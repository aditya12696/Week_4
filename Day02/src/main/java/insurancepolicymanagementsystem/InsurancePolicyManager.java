package insurancepolicymanagementsystem;
import java.time.LocalDate;
import java.util.*;

public class InsurancePolicyManager {
    private Set<InsurancePolicy> hashSetPolicies = new HashSet<>();
    private Set<InsurancePolicy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public Set<InsurancePolicy> getAllPolicies() {
        return new HashSet<>(hashSetPolicies);
    }

    public List<InsurancePolicy> getPoliciesExpiringSoon() {
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (InsurancePolicy policy : hashSetPolicies) {
            if (!policy.getExpiryDate().isBefore(today) && policy.getExpiryDate().isBefore(today.plusDays(30))) {
                expiringPolicies.add(policy);
            }
        }
        return expiringPolicies;
    }

    public List<InsurancePolicy> getPoliciesByCoverageType(String coverageType) {
        List<InsurancePolicy> result = new ArrayList<>();
        for (InsurancePolicy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                result.add(policy);
            }
        }
        return result;
    }

    public Set<InsurancePolicy> getDuplicatePolicies() {
        Set<InsurancePolicy> duplicates = new HashSet<>();
        Set<String> policyNumbers = new HashSet<>();
        for (InsurancePolicy policy : hashSetPolicies) {
            if (!policyNumbers.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }
        return duplicates;
    }

    public void comparePerformance() {
        List<InsurancePolicy> policies = new ArrayList<>(hashSetPolicies);
        long start, end;

        // Adding
        start = System.nanoTime();
        hashSetPolicies.addAll(policies);
        end = System.nanoTime();
        System.out.println("HashSet Add Time: " + (end - start));

        start = System.nanoTime();
        linkedHashSetPolicies.addAll(policies);
        end = System.nanoTime();
        System.out.println("LinkedHashSet Add Time: " + (end - start));

        start = System.nanoTime();
        treeSetPolicies.addAll(policies);
        end = System.nanoTime();
        System.out.println("TreeSet Add Time: " + (end - start));

        // Searching
        InsurancePolicy samplePolicy = policies.get(0);
        start = System.nanoTime();
        hashSetPolicies.contains(samplePolicy);
        end = System.nanoTime();
        System.out.println("HashSet Search Time: " + (end - start));

        start = System.nanoTime();
        linkedHashSetPolicies.contains(samplePolicy);
        end = System.nanoTime();
        System.out.println("LinkedHashSet Search Time: " + (end - start));

        start = System.nanoTime();
        treeSetPolicies.contains(samplePolicy);
        end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start));
    }
}