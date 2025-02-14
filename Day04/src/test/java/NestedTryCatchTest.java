import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NestedTryCatchTest {

    @Test
    void testArrayIndexOutOfBounds() {
        int[] arr = {10, 20, 30, 40, 50};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            int value = arr[10]; // Invalid index
        });
    }

    @Test
    void testArithmeticException() {
        assertThrows(ArithmeticException.class, () -> {
            int result = 10 / 0; // Division by zero
        });
    }
}
