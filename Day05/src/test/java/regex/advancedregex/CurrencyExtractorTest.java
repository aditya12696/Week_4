package regex.advancedregex;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import regex.advancedregex.CurrencyExtractor;

import java.util.List;

class CurrencyExtractorTest {

    @Test
    void testExtractCurrencyValues() {
        String input = "The price is $45.99, and the discount is 10.50.";
        List<String> expected = List.of("$45.99", "10.50");
        assertEquals(expected, CurrencyExtractor.extractCurrencyValues(input));
    }

    @Test
    void testNoCurrencyValues() {
        String input = "There are no prices mentioned here.";
        List<String> expected = List.of();
        assertEquals(expected, CurrencyExtractor.extractCurrencyValues(input));
    }

    @Test
    void testMultipleCurrencies() {
        String input = "Items cost $5.00, $12.75, and 100.99 in different regions.";
        List<String> expected = List.of("$5.00", "$12.75", "100.99");
        assertEquals(expected, CurrencyExtractor.extractCurrencyValues(input));
    }

    @Test
    void testCurrencyWithoutDecimals() {
        String input = "The amount is $40 and another is 30.";
        List<String> expected = List.of("$40", "30");
        assertEquals(expected, CurrencyExtractor.extractCurrencyValues(input));
    }
}
