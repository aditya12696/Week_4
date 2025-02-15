package regex.advancedregex;

import java.util.regex.Pattern;

public class CreditCardValidator {
    private static final String VISA_REGEX = "^4[0-9]{15}$";  // Visa: Starts with 4, 16 digits
    private static final String MASTERCARD_REGEX = "^5[1-5][0-9]{14}$"; // MasterCard: Starts with 5, 16 digits

    private static final Pattern visaPattern = Pattern.compile(VISA_REGEX);
    private static final Pattern masterCardPattern = Pattern.compile(MASTERCARD_REGEX);

    public static String validateCreditCard(String cardNumber) {
        if (visaPattern.matcher(cardNumber).matches()) {
            return "Valid Visa Card";
        } else if (masterCardPattern.matcher(cardNumber).matches()) {
            return "Valid MasterCard";
        } else {
            return "Invalid Card";
        }
    }

    public static void main(String[] args) {
        String[] testCards = {
                "4111111111111111",  // Valid Visa
                "5105105105105100",  // Valid MasterCard
                "1234567812345678",  // Invalid
                "4012888888881881",  // Valid Visa
                "5500000000000004",  // Valid MasterCard
                "4222222222222222"   // Invalid (not MasterCard range)
        };

        for (String card : testCards) {
            System.out.println(card + " → " + validateCreditCard(card));
        }
    }
}
