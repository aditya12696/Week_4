package annotations.practiceproblems.beginner.todo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;

class TaskManagerTest {

    @Test
    void testTodoAnnotationPresence() throws NoSuchMethodException {
        Method authMethod = TaskManager.class.getMethod("implementAuth");
        Method dbMethod = TaskManager.class.getMethod("optimizeDatabase");
        Method refactorMethod = TaskManager.class.getMethod("refactorCode");

        assertTrue(authMethod.isAnnotationPresent(Todo.class));
        assertTrue(dbMethod.isAnnotationPresent(Todo.class));
        assertTrue(refactorMethod.isAnnotationPresent(Todo.class));
    }

    @Test
    void testTodoAnnotationValues() throws NoSuchMethodException {
        Method authMethod = TaskManager.class.getMethod("implementAuth");
        Todo authAnnotation = authMethod.getAnnotation(Todo.class);

        assertEquals("Implement authentication", authAnnotation.task());
        assertEquals("Alice", authAnnotation.assignedTo());
        assertEquals("HIGH", authAnnotation.priority());

        Method dbMethod = TaskManager.class.getMethod("optimizeDatabase");
        Todo dbAnnotation = dbMethod.getAnnotation(Todo.class);

        assertEquals("Optimize database queries", dbAnnotation.task());
        assertEquals("Bob", dbAnnotation.assignedTo());
        assertEquals("MEDIUM", dbAnnotation.priority()); // Default value

        Method refactorMethod = TaskManager.class.getMethod("refactorCode");
        Todo refactorAnnotation = refactorMethod.getAnnotation(Todo.class);

        assertEquals("Refactor legacy code", refactorAnnotation.task());
        assertEquals("Charlie", refactorAnnotation.assignedTo());
        assertEquals("LOW", refactorAnnotation.priority());
    }
}
