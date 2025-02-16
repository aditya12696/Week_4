package reflections.basiclevel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class ClassInspectorTest {

    @Test
    void testClassExists() {
        try {
            Class<?> clazz = Class.forName("java.util.ArrayList");
            assertNotNull(clazz);
        } catch (ClassNotFoundException e) {
            fail("Class should exist but was not found.");
        }
    }

    @Test
    void testConstructorRetrieval() {
        try {
            Class<?> clazz = Class.forName("java.util.ArrayList");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            assertTrue(constructors.length > 0, "ArrayList should have constructors.");
        } catch (ClassNotFoundException e) {
            fail("Class should exist but was not found.");
        }
    }

    @Test
    void testFieldRetrieval() {
        try {
            Class<?> clazz = Class.forName("java.util.ArrayList");
            Field[] fields = clazz.getDeclaredFields();
            assertNotNull(fields, "Fields should not be null.");
        } catch (ClassNotFoundException e) {
            fail("Class should exist but was not found.");
        }
    }

    @Test
    void testMethodRetrieval() {
        try {
            Class<?> clazz = Class.forName("java.util.ArrayList");
            Method[] methods = clazz.getDeclaredMethods();
            assertTrue(methods.length > 0, "ArrayList should have methods.");
        } catch (ClassNotFoundException e) {
            fail("Class should exist but was not found.");
        }
    }

    @Test
    void testInvalidClassName() {
        assertThrows(ClassNotFoundException.class, () -> Class.forName("invalid.ClassName"));
    }
}
