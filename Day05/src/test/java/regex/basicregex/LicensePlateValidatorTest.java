package regex.basicregex;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import regex.basicregex.LicensePlateValidator;

class LicensePlateValidatorTest {

    @Test
    void testValidLicensePlates() {
        assertTrue(LicensePlateValidator.isValidLicensePlate("AB1234"));
        assertTrue(LicensePlateValidator.isValidLicensePlate("XY5678"));
        assertTrue(LicensePlateValidator.isValidLicensePlate("ZZ9999"));
    }

    @Test
    void testInvalidLicensePlates() {
        assertFalse(LicensePlateValidator.isValidLicensePlate("A12345")); // Only 1 letter
        assertFalse(LicensePlateValidator.isValidLicensePlate("abc123")); // Lowercase letters
        assertFalse(LicensePlateValidator.isValidLicensePlate("12AB34")); // Digits first
        assertFalse(LicensePlateValidator.isValidLicensePlate("A1B234")); // Incorrect format
        assertFalse(LicensePlateValidator.isValidLicensePlate("AB12CD")); // Should contain only digits after letters
    }
}
