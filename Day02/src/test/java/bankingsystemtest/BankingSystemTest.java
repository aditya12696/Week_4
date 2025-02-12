package bankingsystemtest;

import static org.junit.jupiter.api.Assertions.*;

import bankingsystem.BankingSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class BankingSystemTest {
    private BankingSystem bankingSystem;

    @BeforeEach
    void setUp() {
        bankingSystem = new BankingSystem();
        bankingSystem.createAccount(101, 5000);
        bankingSystem.createAccount(102, 7000);
        bankingSystem.createAccount(103, 3000);
        bankingSystem.createAccount(104, 9000);
    }

    @Test
    void testCreateAccount() {
        bankingSystem.createAccount(105, 4000);
        assertEquals(4000, bankingSystem.getAccounts().get(105));
    }

    @Test
    void testDeposit() {
        bankingSystem.deposit(101, 2000);
        assertEquals(7000, bankingSystem.getAccounts().get(101));
    }

    @Test
    void testRequestWithdrawal() {
        bankingSystem.requestWithdrawal(102);
        bankingSystem.requestWithdrawal(103);
        assertEquals(2, bankingSystem.getWithdrawalQueue().size());
    }

    @Test
    void testProcessWithdrawals() {
        bankingSystem.requestWithdrawal(102);
        bankingSystem.requestWithdrawal(103);
        bankingSystem.processWithdrawals(4000);
        assertEquals(3000, bankingSystem.getAccounts().get(102));
        assertEquals(0, bankingSystem.getWithdrawalQueue().size());
    }

    @Test
    void testAccountsSortedByBalance() {
        bankingSystem.deposit(101, 2000);
        bankingSystem.deposit(103, 1500);
        TreeMap<Double, Integer> sorted = bankingSystem.getSortedAccounts();
        assertEquals(9000, sorted.firstKey());
    }
}
