package policymanagementsystemtest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import policymanagementsystem.InsurancePolicy;
import policymanagementsystem.PolicyManagementSystem;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PolicyManagementSystemTest {
    private PolicyManagementSystem system;

    @BeforeEach
    void setUp() {
        system = new PolicyManagementSystem();

        // Adding sample policies
        system.addPolicy(new InsurancePolicy("P101", "Alice", LocalDate.now().plusDays(10), "Health", 5000));
        system.addPolicy(new InsurancePolicy("P102", "Bob", LocalDate.now().plusDays(40), "Auto", 7000));
        system.addPolicy(new InsurancePolicy("P103", "Alice", LocalDate.now().minusDays(5), "Home", 6000)); // Expired
    }

    @Test
    void testGetPolicyByNumber() {
        InsurancePolicy policy = system.getPolicyByNumber("P101");
        assertNotNull(policy);
        assertEquals("Alice", policy.getPolicyholderName());
    }

    @Test
    void testGetPoliciesExpiringSoon() {
        List<InsurancePolicy> expiringPolicies = system.getPoliciesExpiringSoon();
        assertEquals(1, expiringPolicies.size());
        assertEquals("P101", expiringPolicies.get(0).getPolicyNumber());
    }

    @Test
    void testGetPoliciesByHolder() {
        List<InsurancePolicy> alicePolicies = system.getPoliciesByHolder("Alice");
        assertEquals(2, alicePolicies.size());
    }

    @Test
    void testRemoveExpiredPolicies() {
        system.removeExpiredPolicies();
        assertNull(system.getPolicyByNumber("P103")); // Expired policy should be removed
    }

    @Test
    void testAddPolicy() {
        system.addPolicy(new InsurancePolicy("P104", "Charlie", LocalDate.now().plusDays(20), "Life", 8000));
        InsurancePolicy policy = system.getPolicyByNumber("P104");
        assertNotNull(policy);
        assertEquals("Charlie", policy.getPolicyholderName());
    }
}
