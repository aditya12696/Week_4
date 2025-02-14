import exceptionpropagationexample.ExceptionPropagationExample;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionPropagation {

    @Test
    void testExceptionPropagation() {
        Exception e = assertThrows(ArithmeticException.class, ExceptionPropagationExample::method1);
        assertEquals("/ by zero", e.getMessage());
    }
}
