import customexceptionexample.CustomExceptionExample;
import customexceptionexample.InvalidAgeException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomExceptionTest {

    @Test
    void testInvalidAgeException() {
        Exception exception = assertThrows(InvalidAgeException.class, () -> {
            CustomExceptionExample.validateAge(16); // Age below 18
        });

        assertEquals("Age must be 18 or above", exception.getMessage());
    }

    @Test
    void testValidAge() {
        assertDoesNotThrow(() -> CustomExceptionExample.validateAge(20)); // Age is valid
    }
}
