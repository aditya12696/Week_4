package reflections.basiclevel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import reflections.basiclevel.calculatorreflection.Calculator;

import java.lang.reflect.Method;

class CalculatorReflectionTest {

    @Test
    void testInvokePrivateMethod() {
        try {

            Calculator calculator = new Calculator();


            Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
            multiplyMethod.setAccessible(true);


            int result = (int) multiplyMethod.invoke(calculator, 6, 3);
            assertEquals(18, result, "Multiplication should return 18 for inputs (6,3)");

        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}
