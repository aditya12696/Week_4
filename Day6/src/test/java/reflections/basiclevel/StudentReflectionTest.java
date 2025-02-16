package reflections.basiclevel;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import reflections.basiclevel.studentreflection.Student;

import java.lang.reflect.Constructor;

class StudentReflectionTest {

    @Test
    void testCreateStudentInstance() {
        try {

            Class<?> studentClass = Student.class;


            Constructor<?> constructor = studentClass.getDeclaredConstructor();


            Object studentInstance = constructor.newInstance();


            assertNotNull(studentInstance, "Student instance should not be null.");
            assertTrue(studentInstance instanceof Student, "Created object should be an instance of Student.");

        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}
