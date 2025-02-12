package setquestiontest.setoperations;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import setquestion.setoperations.SetOperations;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class SetOperationsTest {

    /**
     * Test case: Union of two sets with some common elements.
     */
    @Test
    public void testUnion_CommonElements() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(expected, SetOperations.union(set1, set2));
    }

    /**
     * Test case: Union of two disjoint sets.
     */
    @Test
    public void testUnion_DisjointSets() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4));
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        assertEquals(expected, SetOperations.union(set1, set2));
    }

    /**
     * Test case: Union where one set is empty.
     */
    @Test
    public void testUnion_OneEmptySet() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>();
        assertEquals(set1, SetOperations.union(set1, set2));
    }

    /**
     * Test case: Intersection of two sets with some common elements.
     */
    @Test
    public void testIntersection_CommonElements() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));
        Set<Integer> expected = new HashSet<>(Arrays.asList(3));
        assertEquals(expected, SetOperations.intersection(set1, set2));
    }

    /**
     * Test case: Intersection of two disjoint sets (no common elements).
     */
    @Test
    public void testIntersection_DisjointSets() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4));
        Set<Integer> expected = new HashSet<>(); // Empty set expected
        assertEquals(expected, SetOperations.intersection(set1, set2));
    }

    /**
     * Test case: Intersection where one set is empty.
     */
    @Test
    public void testIntersection_OneEmptySet() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> expected = new HashSet<>(); // Empty set expected
        assertEquals(expected, SetOperations.intersection(set1, set2));
    }
}
