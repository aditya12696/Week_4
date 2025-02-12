package listquestiontests.reverselisttest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import listquestion.reverselist.ReverseList;

import java.util.*;

class ReverseListTest {

    @Test
    void testReverseArrayList() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(5, 4, 3, 2, 1);
        assertEquals(expected, ReverseList.reverseArrayList(input));
    }

    @Test
    void testReverseLinkedList() {
        LinkedList<Integer> input = new LinkedList<>(Arrays.asList(10, 20, 30, 40));
        LinkedList<Integer> expected = new LinkedList<>(Arrays.asList(40, 30, 20, 10));
        assertEquals(expected, ReverseList.reverseLinkedList(input));
    }

    @Test
    void testReverseEmptyList() {
        List<Integer> emptyList = new ArrayList<>();
        assertTrue(ReverseList.reverseArrayList(emptyList).isEmpty());

        LinkedList<Integer> emptyLinkedList = new LinkedList<>();
        assertTrue(ReverseList.reverseLinkedList(emptyLinkedList).isEmpty());
    }

    @Test
    void testReverseSingleElementList() {
        List<Integer> singleList = Arrays.asList(42);
        assertEquals(singleList, ReverseList.reverseArrayList(singleList));

        LinkedList<Integer> singleLinkedList = new LinkedList<>(Arrays.asList(99));
        assertEquals(singleLinkedList, ReverseList.reverseLinkedList(singleLinkedList));
    }
}

