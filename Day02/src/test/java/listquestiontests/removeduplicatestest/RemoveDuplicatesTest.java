package listquestiontests.removeduplicatestest;
import org.junit.jupiter.api.Test;
import listquestion.removeduplicates.RemoveDuplicates;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveDuplicatesTest {

    @Test
    void testRemoveDuplicates() {
        List<Integer> list = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> expected = Arrays.asList(3, 1, 2, 4);
        assertEquals(expected, RemoveDuplicates.removeDuplicates(list));
    }

    @Test
    void testRemoveDuplicatesWithNoDuplicates() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(list, RemoveDuplicates.removeDuplicates(list));
    }

    @Test
    void testRemoveDuplicatesWithAllDuplicates() {
        List<Integer> list = Arrays.asList(5, 5, 5, 5);
        List<Integer> expected = Collections.singletonList(5);
        assertEquals(expected, RemoveDuplicates.removeDuplicates(list));
    }

    @Test
    void testRemoveDuplicatesWithEmptyList() {
        List<Integer> list = Collections.emptyList();
        assertEquals(list, RemoveDuplicates.removeDuplicates(list));
    }

    @Test
    void testRemoveDuplicatesWithSingleElement() {
        List<Integer> list = Collections.singletonList(10);
        assertEquals(list, RemoveDuplicates.removeDuplicates(list));
    }
}

