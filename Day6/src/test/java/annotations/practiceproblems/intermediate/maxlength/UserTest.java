package annotations.practiceproblems.intermediate.maxlength;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void testValidUsername() {
        assertDoesNotThrow(() -> new User("ValidUser"));
    }

    @Test
    void testExceedingMaxLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new User("TooLongUsername"));
        assertEquals("Username exceeds max length of 10 characters.", exception.getMessage());
    }
}
