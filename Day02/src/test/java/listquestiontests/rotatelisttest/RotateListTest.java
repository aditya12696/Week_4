package listquestiontests.rotatelisttest;
import org.junit.jupiter.api.Test;
import listquestion.rotatelist.RotateList;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class RotateListTest {

    // Test rotating a list by 2 positions
    @Test
    void testRotateListByTwoPositions() {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> expected = Arrays.asList(30, 40, 50, 10, 20);
        assertEquals(expected, RotateList.rotateList(list, 2));
    }

    // Test rotating a list by 0 positions (should remain unchanged)
    @Test
    void testRotateListByZeroPositions() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(list, RotateList.rotateList(list, 0));
    }

    // Test rotating a list by its own size (should remain unchanged)
    @Test
    void testRotateListBySize() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(list, RotateList.rotateList(list, 5));
    }

    // Test rotating a list by more than its size (should be equivalent to rotating by positions % size)
    @Test
    void testRotateListByMoreThanSize() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(3, 4, 5, 1, 2); // 7 % 5 = 2, so same as rotating by 2
        assertEquals(expected, RotateList.rotateList(list, 7));
    }

    // Test rotating a single-element list (should remain unchanged)
    @Test
    void testRotateListSingleElement() {
        List<Integer> list = Collections.singletonList(42);
        assertEquals(list, RotateList.rotateList(list, 3));
    }

    // Test rotating an empty list (should remain unchanged)
    @Test
    void testRotateListEmptyList() {
        List<Integer> list = Collections.emptyList();
        assertEquals(list, RotateList.rotateList(list, 3));
    }
}

