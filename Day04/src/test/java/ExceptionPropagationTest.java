import interestcalculator.InterestCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionPropagationTest {

    @Test
    void testValidInterestCalculation() {
        assertEquals(200, InterestCalculator.calculateInterest(1000, 10, 2));
    }

    @Test
    void testInvalidInterestNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            InterestCalculator.calculateInterest(-1000, 10, 2);
        });

        assertEquals("Invalid input: Amount and rate must be positive", exception.getMessage());
    }

    @Test
    void testInvalidInterestNegativeRate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            InterestCalculator.calculateInterest(1000, -10, 2);
        });

        assertEquals("Invalid input: Amount and rate must be positive", exception.getMessage());
    }
}
