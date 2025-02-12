package mapquestiontest.wordfrequencycountertest;
import static org.junit.jupiter.api.Assertions.*;

import mapquestion.wordfrequencycounter.WordFrequencyCounter;
import org.junit.jupiter.api.Test;
import java.util.*;

public class WordFrequencyCounterTest {

    @Test
    void testWordFrequency() {
        Map<String, Integer> result = WordFrequencyCounter.countWordFrequency("testfile.txt");

        Map<String, Integer> expected = new HashMap<>();
        expected.put("hello", 2);
        expected.put("world", 1);
        expected.put("java", 1);

        assertEquals(expected, result);
    }

    @Test
    void testEmptyFile() {
        Map<String, Integer> result = WordFrequencyCounter.countWordFrequency("emptyfile.txt");
        assertTrue(result.isEmpty());
    }

    @Test
    void testCaseInsensitive() {
        Map<String, Integer> result = WordFrequencyCounter.countWordFrequency("casefile.txt");

        Map<String, Integer> expected = new HashMap<>();
        expected.put("hello", 3);
        expected.put("java", 2);

        assertEquals(expected, result);
    }

    @Test
    void testPunctuationIgnored() {
        Map<String, Integer> result = WordFrequencyCounter.countWordFrequency("punctuation.txt");

        Map<String, Integer> expected = new HashMap<>();
        expected.put("hello", 2);
        expected.put("world", 1);
        expected.put("java", 1);

        assertEquals(expected, result);
    }
}
