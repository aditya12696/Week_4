package regex.extractionproblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import regex.extractionproblems.DateExtractor;

import java.util.List;

class DateExtractorTest {

    @Test
    void testExtractValidDates() {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        List<String> result = DateExtractor.extractDates(text);

        assertEquals(3, result.size());
        assertTrue(result.contains("12/05/2023"));
        assertTrue(result.contains("15/08/2024"));
        assertTrue(result.contains("29/02/2020"));
    }

    @Test
    void testNoDatesInText() {
        String text = "There are no dates in this sentence.";
        List<String> result = DateExtractor.extractDates(text);

        assertTrue(result.isEmpty());
    }

    @Test
    void testMixedTextWithInvalidDates() {
        String text = "We met on 32/01/2023, 15/13/2025 and 10/10/2022.";
        List<String> result = DateExtractor.extractDates(text);

        assertEquals(1, result.size()); // Only "10/10/2022" is valid
        assertTrue(result.contains("10/10/2022"));
    }
}
