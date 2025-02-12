package setquestiontest.setdifferencetest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import setquestion.setdifference.SetDifference;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class SetDifferenceTest {

    /**
     * Test case: Symmetric difference with some common elements.
     */
    @Test
    public void testSymmetricDifference_CommonElements() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 4, 5));
        assertEquals(expected, SetDifference.symmetricDifference(set1, set2));
    }

    /**
     * Test case: Symmetric difference with disjoint sets.
     */
    @Test
    public void testSymmetricDifference_DisjointSets() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4));
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        assertEquals(expected, SetDifference.symmetricDifference(set1, set2));
    }

    /**
     * Test case: Symmetric difference when one set is empty.
     */
    @Test
    public void testSymmetricDifference_OneEmptySet() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>();
        assertEquals(set1, SetDifference.symmetricDifference(set1, set2));
    }

    /**
     * Test case: Symmetric difference when both sets are identical.
     */
    @Test
    public void testSymmetricDifference_IdenticalSets() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> expected = new HashSet<>(); // Empty set expected
        assertEquals(expected, SetDifference.symmetricDifference(set1, set2));
    }
}
