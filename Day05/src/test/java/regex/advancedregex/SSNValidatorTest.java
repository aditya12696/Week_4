package regex.advancedregex;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import regex.advancedregex.SSNValidator;

class SSNValidatorTest {

    @Test
    void testValidSSN() {
        assertTrue(SSNValidator.isValidSSN("123-45-6789"));
    }

    @Test
    void testInvalidSSN_NoDashes() {
        assertFalse(SSNValidator.isValidSSN("123456789"));
    }

    @Test
    void testInvalidSSN_WrongFormat() {
        assertFalse(SSNValidator.isValidSSN("123-456-789"));
    }

    @Test
    void testExtractValidSSN() {
        String input = "My SSN is 987-65-4321.";
        assertEquals("987-65-4321 is valid", SSNValidator.extractAndValidateSSN(input));
    }

    @Test
    void testNoValidSSN() {
        String input = "No valid SSN here.";
        assertEquals("No valid SSN found", SSNValidator.extractAndValidateSSN(input));
    }
}
