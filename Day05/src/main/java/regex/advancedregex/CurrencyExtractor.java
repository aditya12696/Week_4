package regex.advancedregex;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class CurrencyExtractor {
    private static final String CURRENCY_REGEX = "\\$?\\d+(\\.\\d{2})?";

    public static List<String> extractCurrencyValues(String text) {
        List<String> extractedValues = new ArrayList<>();
        Pattern pattern = Pattern.compile(CURRENCY_REGEX);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            extractedValues.add(matcher.group());
        }
        return extractedValues;
    }

    public static void main(String[] args) {
        String input = "The price is $45.99, and the discount is 10.50.";
        List<String> values = extractCurrencyValues(input);

        System.out.println("Extracted Currency Values: " + String.join(", ", values));
    }
}
