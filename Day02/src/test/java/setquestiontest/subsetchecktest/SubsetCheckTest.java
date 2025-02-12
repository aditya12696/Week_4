package setquestiontest.subsetchecktest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import setquestion.subsetcheck.SubsetCheck;

import java.util.*;

public class SubsetCheckTest {

    /**
     * Test case: Normal subset check.
     */
    @Test
    public void testIsSubset_NormalCase() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        assertTrue(SubsetCheck.isSubset(set1, set2));
    }

    /**
     * Test case: Check when set1 is equal to set2.
     */
    @Test
    public void testIsSubset_EqualSets() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        assertTrue(SubsetCheck.isSubset(set1, set2));
    }

    /**
     * Test case: Check when set1 is not a subset of set2.
     */
    @Test
    public void testIsSubset_NotASubset() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        assertFalse(SubsetCheck.isSubset(set1, set2));
    }

    /**
     * Test case: Check when set1 is empty (empty set is a subset of any set).
     */
    @Test
    public void testIsSubset_EmptySet1() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        assertTrue(SubsetCheck.isSubset(set1, set2));
    }

    /**
     * Test case: Check when set2 is empty but set1 is not (should return false).
     */
    @Test
    public void testIsSubset_EmptySet2() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2));
        Set<Integer> set2 = new HashSet<>();
        assertFalse(SubsetCheck.isSubset(set1, set2));
    }

    /**
     * Test case: Both sets are empty (empty set is a subset of itself).
     */
    @Test
    public void testIsSubset_BothEmptySets() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        assertTrue(SubsetCheck.isSubset(set1, set2));
    }
}

