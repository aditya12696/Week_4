package policymanagementsystem;
import java.time.LocalDate;
import java.util.*;

public class PolicyManagementSystem {
    private Map<String, InsurancePolicy> policiesHashMap = new HashMap<>();
    private Map<String, InsurancePolicy> policiesLinkedHashMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, InsurancePolicy> policiesTreeMap = new TreeMap<>();

    // Add policy to all collections
    public void addPolicy(InsurancePolicy policy) {
        policiesHashMap.put(policy.getPolicyNumber(), policy);
        policiesLinkedHashMap.put(policy.getPolicyNumber(), policy);
        policiesTreeMap.put(policy.getExpiryDate(), policy);
    }

    // Retrieve policy by policy number
    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policiesHashMap.get(policyNumber);
    }

    // List policies expiring within the next 30 days
    public List<InsurancePolicy> getPoliciesExpiringSoon() {
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate thresholdDate = today.plusDays(30);

        for (Map.Entry<LocalDate, InsurancePolicy> entry : policiesTreeMap.entrySet()) {
            if (!entry.getKey().isAfter(thresholdDate)) {
                expiringPolicies.add(entry.getValue());
            }
        }
        return expiringPolicies;
    }

    // List all policies for a specific policyholder
    public List<InsurancePolicy> getPoliciesByHolder(String policyholderName) {
        List<InsurancePolicy> holderPolicies = new ArrayList<>();
        for (InsurancePolicy policy : policiesHashMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                holderPolicies.add(policy);
            }
        }
        return holderPolicies;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        policiesTreeMap.headMap(today, true).clear();
        policiesHashMap.values().removeIf(policy -> policy.getExpiryDate().isBefore(today));
        policiesLinkedHashMap.values().removeIf(policy -> policy.getExpiryDate().isBefore(today));
    }

    // Print all policies (for testing)
    public void printAllPolicies() {
        System.out.println("All Policies:");
        policiesHashMap.values().forEach(System.out::println);
    }

    public static void main(String[] args) {
        PolicyManagementSystem system = new PolicyManagementSystem();

        // Sample policies
        system.addPolicy(new InsurancePolicy("P101", "Alice", LocalDate.now().plusDays(10), "Health", 5000));
        system.addPolicy(new InsurancePolicy("P102", "Bob", LocalDate.now().plusDays(40), "Auto", 7000));
        system.addPolicy(new InsurancePolicy("P103", "Alice", LocalDate.now().minusDays(5), "Home", 6000));

        // Retrieve policy by number
        System.out.println("Policy P101: " + system.getPolicyByNumber("P101"));

        // List policies expiring within 30 days
        System.out.println("Expiring Policies: " + system.getPoliciesExpiringSoon());

        // List policies by policyholder
        System.out.println("Alice's Policies: " + system.getPoliciesByHolder("Alice"));

        // Remove expired policies
        system.removeExpiredPolicies();
        system.printAllPolicies();
    }
}
