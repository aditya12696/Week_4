package annotations.practiceproblems.beginner.importantmethod;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;

class TaskServiceTest {

    @Test
    void testImportantMethodPresence() throws NoSuchMethodException {
        Method criticalMethod = TaskService.class.getMethod("processCriticalTask");
        Method regularMethod = TaskService.class.getMethod("processRegularTask");

        assertTrue(criticalMethod.isAnnotationPresent(ImportantMethod.class));
        assertTrue(regularMethod.isAnnotationPresent(ImportantMethod.class));
    }

    @Test
    void testImportantMethodLevels() throws NoSuchMethodException {
        Method criticalMethod = TaskService.class.getMethod("processCriticalTask");
        Method regularMethod = TaskService.class.getMethod("processRegularTask");

        ImportantMethod criticalAnnotation = criticalMethod.getAnnotation(ImportantMethod.class);
        ImportantMethod regularAnnotation = regularMethod.getAnnotation(ImportantMethod.class);

        assertEquals("HIGH", criticalAnnotation.level());
        assertEquals("MEDIUM", regularAnnotation.level());
    }
}
