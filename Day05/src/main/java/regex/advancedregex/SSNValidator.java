package regex.advancedregex;

import java.util.regex.*;

public class SSNValidator {
    private static final String SSN_REGEX = "\\b\\d{3}-\\d{2}-\\d{4}\\b";

    public static boolean isValidSSN(String ssn) {
        return Pattern.matches(SSN_REGEX, ssn);
    }

    public static String extractAndValidateSSN(String text) {
        Pattern pattern = Pattern.compile(SSN_REGEX);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            String ssn = matcher.group();
            return ssn + " is valid";
        }
        return "No valid SSN found";
    }

    public static void main(String[] args) {
        String input1 = "My SSN is 123-45-6789.";
        String input2 = "Invalid SSN: 123456789";

        System.out.println(extractAndValidateSSN(input1)); // ✅ "123-45-6789 is valid"
        System.out.println(extractAndValidateSSN(input2)); // ❌ "No valid SSN found"
    }
}
