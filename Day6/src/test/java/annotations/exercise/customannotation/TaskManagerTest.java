package annotations.exercise.customannotation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;

class TaskManagerTest {

    @Test
    void testAnnotationPresence() throws NoSuchMethodException {
        Method method = TaskManager.class.getMethod("completeTask");
        assertTrue(method.isAnnotationPresent(TaskInfo.class));
    }

    @Test
    void testAnnotationValues() throws NoSuchMethodException {
        Method method = TaskManager.class.getMethod("completeTask");
        TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

        assertEquals("High", taskInfo.priority());
        assertEquals("John Doe", taskInfo.assignedTo());
    }
}
