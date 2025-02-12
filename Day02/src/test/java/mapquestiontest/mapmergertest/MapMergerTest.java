package mapquestiontest.mapmergertest;
import static org.junit.jupiter.api.Assertions.*;

import mapquestion.mapmerger.MapMerger;
import org.junit.jupiter.api.Test;
import java.util.*;

public class MapMergerTest {

    @Test
    void testMergeMaps() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("A", 1);
        expected.put("B", 5);
        expected.put("C", 4);

        assertEquals(expected, MapMerger.mergeMaps(map1, map2));
    }

    @Test
    void testMergeMapsEmpty() {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        assertTrue(MapMerger.mergeMaps(map1, map2).isEmpty());
    }

    @Test
    void testMergeMapsOneEmpty() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("X", 10);

        Map<String, Integer> map2 = new HashMap<>();

        assertEquals(map1, MapMerger.mergeMaps(map1, map2));
    }
}
