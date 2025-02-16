package annotations.practiceproblems.intermediate.logexecutiontime;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import reflections.advancedlevel.dependencyinjection.Service;

import java.lang.reflect.Method;

class ServiceTest {

    @Test
    void testLogExecutionTimePresence() throws NoSuchMethodException {
        Method processMethod = Service.class.getMethod("processData");
        Method fetchMethod = Service.class.getMethod("fetchData");
        Method helperMethod = Service.class.getMethod("helperMethod");

        assertTrue(processMethod.isAnnotationPresent(LogExecutionTime.class));
        assertTrue(fetchMethod.isAnnotationPresent(LogExecutionTime.class));
        assertFalse(helperMethod.isAnnotationPresent(LogExecutionTime.class));
    }
}
