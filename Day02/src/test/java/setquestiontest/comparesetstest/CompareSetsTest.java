package setquestiontest.comparesetstest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import setquestion.comparesets.CompareSets;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class CompareSetsTest {

    /**
     * Test case: Both sets contain the same elements in different order.
     */
    @Test
    public void testAreSetsEqual_SameElementsDifferentOrder() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));
        assertTrue(CompareSets.areSetsEqual(set1, set2));
    }

    /**
     * Test case: Sets have different elements.
     */
    @Test
    public void testAreSetsEqual_DifferentElements() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6));
        assertFalse(CompareSets.areSetsEqual(set1, set2));
    }

    /**
     * Test case: One set is a subset of the other.
     */
    @Test
    public void testAreSetsEqual_OneSubsetOfAnother() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2));
        assertFalse(CompareSets.areSetsEqual(set1, set2));
    }

    /**
     * Test case: Both sets are empty.
     */
    @Test
    public void testAreSetsEqual_BothEmpty() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        assertTrue(CompareSets.areSetsEqual(set1, set2));
    }

    /**
     * Test case: One set is empty, and the other is not.
     */
    @Test
    public void testAreSetsEqual_OneEmpty() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>();
        assertFalse(CompareSets.areSetsEqual(set1, set2));
    }
}
