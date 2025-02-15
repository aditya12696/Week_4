package regex.extractionproblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import regex.extractionproblems.CapitalizedWordExtractor;

import java.util.List;

class CapitalizedWordExtractorTest {

    @Test
    void testExtractCapitalizedWords() {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> result = CapitalizedWordExtractor.extractCapitalizedWords(text);

        assertEquals(7, result.size());
        assertTrue(result.contains("Eiffel"));
        assertTrue(result.contains("Tower"));
        assertTrue(result.contains("Paris"));
        assertTrue(result.contains("Statue"));
        assertTrue(result.contains("Liberty"));
        assertTrue(result.contains("New"));
        assertTrue(result.contains("York"));
    }

    @Test
    void testNoCapitalizedWords() {
        String text = "this is a lowercase sentence.";
        List<String> result = CapitalizedWordExtractor.extractCapitalizedWords(text);

        assertTrue(result.isEmpty());
    }

    @Test
    void testSingleCapitalizedWord() {
        String text = "Welcome to programming.";
        List<String> result = CapitalizedWordExtractor.extractCapitalizedWords(text);

        assertEquals(1, result.size());
        assertTrue(result.contains("Welcome"));
    }
}
