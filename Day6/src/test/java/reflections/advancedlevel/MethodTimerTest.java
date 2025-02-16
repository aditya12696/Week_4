package reflections.advancedlevel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import reflections.advancedlevel.methodexecution.SampleClass;

class MethodTimerTest {
    @Test
    void testFastMethodExecutionTime() throws Exception {
        SampleClass sample = new SampleClass();
        long startTime = System.nanoTime();
        sample.fastMethod();
        long endTime = System.nanoTime();

        long executionTime = (endTime - startTime) / 1_000_000;
        assertTrue(executionTime < 100, "Fast method should execute quickly");
    }

    @Test
    void testSlowMethodExecutionTime() throws Exception {
        SampleClass sample = new SampleClass();
        long startTime = System.nanoTime();
        sample.slowMethod();
        long endTime = System.nanoTime();

        long executionTime = (endTime - startTime) / 1_000_000;
        assertTrue(executionTime >= 2000, "Slow method should take at least 2 seconds");
    }
}
