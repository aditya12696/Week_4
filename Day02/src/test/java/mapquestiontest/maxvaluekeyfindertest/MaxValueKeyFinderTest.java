package mapquestiontest.maxvaluekeyfindertest;
import static org.junit.jupiter.api.Assertions.*;

import mapquestion.maxvaluekeyfinder.MaxValueKeyFinder;
import org.junit.jupiter.api.Test;
import java.util.*;

public class MaxValueKeyFinderTest {

    @Test
    void testFindMaxKey() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        assertEquals("B", MaxValueKeyFinder.findMaxKey(map));
    }

    @Test
    void testFindMaxKeyEmptyMap() {
        Map<String, Integer> map = new HashMap<>();
        assertNull(MaxValueKeyFinder.findMaxKey(map));
    }

    @Test
    void testFindMaxKeySingleEntry() {
        Map<String, Integer> map = new HashMap<>();
        map.put("X", 100);
        assertEquals("X", MaxValueKeyFinder.findMaxKey(map));
    }
}
