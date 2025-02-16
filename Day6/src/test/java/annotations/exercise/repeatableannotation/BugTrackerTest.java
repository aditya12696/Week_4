package annotations.exercise.repeatableannotation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;

class BugTrackerTest {

    @Test
    void testBugReportsPresence() throws NoSuchMethodException {
        Method method = BugTracker.class.getMethod("processTask");
        assertTrue(method.isAnnotationPresent(BugReports.class));
    }

    @Test
    void testBugReportsValues() throws NoSuchMethodException {
        Method method = BugTracker.class.getMethod("processTask");
        BugReports bugReports = method.getAnnotation(BugReports.class);

        assertEquals(2, bugReports.value().length);
        assertEquals("NullPointerException occurs when input is null", bugReports.value()[0].description());
        assertEquals("Incorrect output for edge cases", bugReports.value()[1].description());
    }
}
