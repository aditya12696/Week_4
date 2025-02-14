import banktransactionsystem.BankAccount;
import banktransactionsystem.InsufficientBalanceException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTransactionTest {

    @Test
    void testWithdrawValidAmount() throws Exception {
        BankAccount account = new BankAccount(5000);
        assertDoesNotThrow(() -> account.withdraw(1000));
    }

    @Test
    void testWithdrawInsufficientBalance() {
        BankAccount account = new BankAccount(5000);
        Exception e = assertThrows(InsufficientBalanceException.class, () -> account.withdraw(6000));
        assertEquals("Insufficient balance!", e.getMessage());
    }

    @Test
    void testWithdrawNegativeAmount() {
        BankAccount account = new BankAccount(5000);
        Exception e = assertThrows(IllegalArgumentException.class, () -> account.withdraw(-500));
        assertEquals("Invalid amount!", e.getMessage());
    }
}
