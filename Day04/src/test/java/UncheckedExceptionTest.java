import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UncheckedExceptionTest {

    @Test
    void testDivisionByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            int result = 10 / 0; // Division by zero
        });

        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    void testValidDivision() {
        int num = 10;
        int denom = 2;
        int result = num / denom;
        assertEquals(5, result);
    }

    @Test
    void testInvalidInput() {
        assertThrows(InputMismatchException.class, () -> {
            Integer.parseInt("abc"); // Simulating non-numeric input
        });
    }
}
