package regex.basicregex;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import regex.basicregex.HexColorValidator;

class HexColorValidatorTest {

    @Test
    void testValidHexColors() {
        assertTrue(HexColorValidator.isValidHexColor("#FFA500"));
        assertTrue(HexColorValidator.isValidHexColor("#ff4500"));
        assertTrue(HexColorValidator.isValidHexColor("#00FF00"));
        assertTrue(HexColorValidator.isValidHexColor("#abcdef"));
        assertTrue(HexColorValidator.isValidHexColor("#A1B2C3"));
    }

    @Test
    void testInvalidHexColors() {
        assertFalse(HexColorValidator.isValidHexColor("#123")); // Too short
        assertFalse(HexColorValidator.isValidHexColor("#GHIJKL")); // Invalid characters
        assertFalse(HexColorValidator.isValidHexColor("123456")); // Missing #
        assertFalse(HexColorValidator.isValidHexColor("#12345G")); // Contains non-hex character
    }
}
