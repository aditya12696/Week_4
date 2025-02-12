package listquestiontests.frequencycountertest;
import listquestion.frequencycounter.FrequencyCounter;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class FrequencyCounterTest {

    @Test
    void testCountFrequency() {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        Map<String, Integer> expected = new HashMap<>();
        expected.put("apple", 3);
        expected.put("banana", 2);
        expected.put("orange", 1);

        assertEquals(expected, FrequencyCounter.countFrequency(words));
    }

    @Test
    void testCountFrequencyWithEmptyList() {
        List<String> words = Collections.emptyList();
        Map<String, Integer> expected = new HashMap<>();

        assertEquals(expected, FrequencyCounter.countFrequency(words));
    }

    @Test
    void testCountFrequencyWithSingleElement() {
        List<String> words = Collections.singletonList("grape");

        Map<String, Integer> expected = new HashMap<>();
        expected.put("grape", 1);

        assertEquals(expected, FrequencyCounter.countFrequency(words));
    }

    @Test
    void testCountFrequencyWithDuplicates() {
        List<String> words = Arrays.asList("mango", "mango", "mango", "mango");

        Map<String, Integer> expected = new HashMap<>();
        expected.put("mango", 4);

        assertEquals(expected, FrequencyCounter.countFrequency(words));
    }
}
