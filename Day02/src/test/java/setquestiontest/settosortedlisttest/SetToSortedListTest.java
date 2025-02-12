package setquestiontest.settosortedlisttest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import setquestion.settosortedlist.SetToSortedList;

import java.util.*;

public class SetToSortedListTest {

    /**
     * Test case: Convert a normal unsorted set to a sorted list.
     */
    @Test
    public void testConvertToSortedList_NormalCase() {
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        List<Integer> expected = Arrays.asList(1, 3, 5, 9);
        assertEquals(expected, SetToSortedList.convertToSortedList(set));
    }

    /**
     * Test case: Convert an already sorted set.
     */
    @Test
    public void testConvertToSortedList_AlreadySorted() {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(expected, SetToSortedList.convertToSortedList(set));
    }

    /**
     * Test case: Convert a set with duplicate values (handled by Set).
     */
    @Test
    public void testConvertToSortedList_Duplicates() {
        Set<Integer> set = new HashSet<>(Arrays.asList(2, 2, 3, 1, 1));
        List<Integer> expected = Arrays.asList(1, 2, 3); // No duplicates in output
        assertEquals(expected, SetToSortedList.convertToSortedList(set));
    }

    /**
     * Test case: Convert an empty set.
     */
    @Test
    public void testConvertToSortedList_EmptySet() {
        Set<Integer> set = new HashSet<>();
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, SetToSortedList.convertToSortedList(set));
    }

    /**
     * Test case: Convert a set with a single element.
     */
    @Test
    public void testConvertToSortedList_SingleElement() {
        Set<Integer> set = new HashSet<>(Collections.singletonList(7));
        List<Integer> expected = Collections.singletonList(7);
        assertEquals(expected, SetToSortedList.convertToSortedList(set));
    }
}
