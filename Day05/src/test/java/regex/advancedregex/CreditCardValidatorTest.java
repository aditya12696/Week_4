package regex.advancedregex;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import regex.advancedregex.CreditCardValidator;

class CreditCardValidatorTest {

    @Test
    void testValidVisaCards() {
        assertEquals("Valid Visa Card", CreditCardValidator.validateCreditCard("4111111111111111"));
        assertEquals("Valid Visa Card", CreditCardValidator.validateCreditCard("4012888888881881"));
    }

    @Test
    void testValidMasterCards() {
        assertEquals("Valid MasterCard", CreditCardValidator.validateCreditCard("5105105105105100"));
        assertEquals("Valid MasterCard", CreditCardValidator.validateCreditCard("5500000000000004"));
    }

    @Test
    void testInvalidCards() {
        assertEquals("Invalid Card", CreditCardValidator.validateCreditCard("1234567812345678")); // Random number
        assertEquals("Valid Visa Card", CreditCardValidator.validateCreditCard("4222222222222222")); // Not MasterCard
        assertEquals("Invalid Card", CreditCardValidator.validateCreditCard("511111111111111"));  // Too short
    }
}
