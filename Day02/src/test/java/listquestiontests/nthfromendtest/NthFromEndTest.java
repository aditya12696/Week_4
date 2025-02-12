package listquestiontests.nthfromendtest;
import static org.junit.jupiter.api.Assertions.*;

import listquestion.nthfromend.NthFromEnd;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.Arrays;

public class NthFromEndTest {

    /**
     * Test case: Nth element from the end exists.
     */
    @Test
    public void testFindNthFromEnd_ValidCase() {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        assertEquals("D", NthFromEnd.findNthFromEnd(list, 2));
    }

    /**
     * Test case: N is larger than the list size.
     */
    @Test
    public void testFindNthFromEnd_LargerThanSize() {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C"));
        assertEquals("N is larger than the list size", NthFromEnd.findNthFromEnd(list, 5));
    }

    /**
     * Test case: N is equal to the list size (should return the first element).
     */
    @Test
    public void testFindNthFromEnd_EqualToSize() {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
        assertEquals("A", NthFromEnd.findNthFromEnd(list, 4));
    }

    /**
     * Test case: N is 1 (should return the last element).
     */
    @Test
    public void testFindNthFromEnd_LastElement() {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("X", "Y", "Z"));
        assertEquals("Z", NthFromEnd.findNthFromEnd(list, 1));
    }

    /**
     * Test case: Empty list.
     */
    @Test
    public void testFindNthFromEnd_EmptyList() {
        LinkedList<String> list = new LinkedList<>();
        assertEquals("N is larger than the list size", NthFromEnd.findNthFromEnd(list, 1));
    }
}
