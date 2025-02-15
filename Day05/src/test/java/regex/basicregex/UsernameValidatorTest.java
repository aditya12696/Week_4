package regex.basicregex;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import regex.basicregex.UsernameValidator;

class UsernameValidatorTest {

    @Test
    void testValidUsernames() {
        assertTrue(UsernameValidator.isValidUsername("user_123"));
        assertTrue(UsernameValidator.isValidUsername("Valid_User"));
        assertTrue(UsernameValidator.isValidUsername("User12345"));
    }

    @Test
    void testInvalidUsernames() {
        assertFalse(UsernameValidator.isValidUsername("123user")); // Starts with a number
        assertFalse(UsernameValidator.isValidUsername("us")); // Too short
        assertFalse(UsernameValidator.isValidUsername("this_is_a_very_long_username")); // Too long
        assertFalse(UsernameValidator.isValidUsername("user!name")); // Contains invalid character (!)
        assertFalse(UsernameValidator.isValidUsername("_username")); // Starts with underscore
    }
}
