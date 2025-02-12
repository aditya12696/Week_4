package insurancepolicymanagertest;
import insurancepolicymanagementsystem.InsurancePolicyManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import insurancepolicymanagementsystem.InsurancePolicy;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

class InsurancePolicyManagerTest {
    private InsurancePolicyManager manager;
    private InsurancePolicy policy1, policy2, policy3, policy4;

    @BeforeEach
    void setUp() {
        manager = new InsurancePolicyManager();
        policy1 = new InsurancePolicy("P001", "John Doe", LocalDate.now().plusDays(10), "Health", 500.0);
        policy2 = new InsurancePolicy("P002", "Jane Doe", LocalDate.now().plusDays(40), "Auto", 700.0);
        policy3 = new InsurancePolicy("P003", "Alice", LocalDate.now().plusDays(5), "Health", 450.0);
        policy4 = new InsurancePolicy("P001", "Duplicate John", LocalDate.now().plusDays(15), "Home", 600.0); // Duplicate policy number

        manager.addPolicy(policy1);
        manager.addPolicy(policy2);
        manager.addPolicy(policy3);
        manager.addPolicy(policy4);
    }

    @Test
    void testGetAllPolicies() {
        Set<InsurancePolicy> policies = manager.getAllPolicies();
        assertEquals(3, policies.size()); // Since duplicate policy numbers should be ignored
    }

    @Test
    void testGetPoliciesExpiringSoon() {
        List<InsurancePolicy> expiringSoon = manager.getPoliciesExpiringSoon();
        assertEquals(2, expiringSoon.size());
    }

    @Test
    void testGetPoliciesByCoverageType() {
        List<InsurancePolicy> healthPolicies = manager.getPoliciesByCoverageType("Health");
        assertEquals(2, healthPolicies.size());
    }

    @Test
    void testGetDuplicatePolicies() {
        Set<InsurancePolicy> duplicatePolicies = manager.getDuplicatePolicies();
        assertEquals(1, duplicatePolicies.size());
        assertTrue(duplicatePolicies.contains(policy4));
    }
}
