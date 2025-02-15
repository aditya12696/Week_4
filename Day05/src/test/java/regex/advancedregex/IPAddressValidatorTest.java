package regex.advancedregex;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import regex.advancedregex.IPAddressValidator;

class IPAddressValidatorTest {

    @Test
    void testValidIPAddresses() {
        assertTrue(IPAddressValidator.isValidIPAddress("192.168.1.1"));
        assertTrue(IPAddressValidator.isValidIPAddress("255.255.255.255"));
        assertTrue(IPAddressValidator.isValidIPAddress("0.0.0.0"));
        assertTrue(IPAddressValidator.isValidIPAddress("127.0.0.1"));
    }

    @Test
    void testInvalidIPAddresses() {
        assertFalse(IPAddressValidator.isValidIPAddress("256.100.50.25")); // 256 is out of range
        assertFalse(IPAddressValidator.isValidIPAddress("192.168.1")); // Missing last octet
        assertFalse(IPAddressValidator.isValidIPAddress("192.168.1.300")); // 300 is out of range
        assertFalse(IPAddressValidator.isValidIPAddress("192.168.1.a")); // Contains non-numeric character
    }
}
