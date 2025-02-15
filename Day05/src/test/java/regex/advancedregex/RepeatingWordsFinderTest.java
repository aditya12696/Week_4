package regex.advancedregex;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import regex.advancedregex.RepeatingWordsFinder;

import java.util.Set;

class RepeatingWordsFinderTest {

    @Test
    void testFindRepeatingWords() {
        String input = "This is is a repeated repeated word test.";
        Set<String> expected = Set.of("is", "repeated");
        assertEquals(expected, RepeatingWordsFinder.findRepeatingWords(input));
    }

    @Test
    void testNoRepeatingWords() {
        String input = "Each word here is unique.";
        Set<String> expected = Set.of();
        assertEquals(expected, RepeatingWordsFinder.findRepeatingWords(input));
    }

    @Test
    void testCaseInsensitiveWords() {
        String input = "Hello hello world World.";
        Set<String> expected = Set.of("hello", "world");
        assertEquals(expected, RepeatingWordsFinder.findRepeatingWords(input));
    }

    @Test
    void testWordsWithPunctuation() {
        String input = "Test, test! Repeated repeated.";
        Set<String> expected = Set.of("test", "repeated");
        assertEquals(expected, RepeatingWordsFinder.findRepeatingWords(input));
    }
}

