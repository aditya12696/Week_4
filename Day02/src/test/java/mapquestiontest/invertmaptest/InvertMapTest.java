package mapquestiontest.invertmaptest;
import static org.junit.jupiter.api.Assertions.*;

import mapquestion.invertmap.InvertMap;
import org.junit.jupiter.api.Test;
import java.util.*;

public class InvertMapTest {

    @Test
    void testInvertMap() {
        Map<String, Integer> input = new HashMap<>();
        input.put("A", 1);
        input.put("B", 2);
        input.put("C", 1);

        Map<Integer, List<String>> result = InvertMap.invertMap(input);

        assertEquals(Arrays.asList("A", "C"), result.get(1));
        assertEquals(Collections.singletonList("B"), result.get(2));
    }
}
