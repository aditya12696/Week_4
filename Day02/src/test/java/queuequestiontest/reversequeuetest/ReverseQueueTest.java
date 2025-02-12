package queuequestiontest.reversequeuetest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import queuequestion.reversequeue.ReverseQueue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueueTest {

    // Test case for reversing a queue with multiple elements
    @Test
    public void testReverseQueue() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        Queue<Integer> expected = new LinkedList<>();
        expected.add(30);
        expected.add(20);
        expected.add(10);

        assertEquals(expected, ReverseQueue.reverseQueue(queue));
    }

    // Test case for an empty queue
    @Test
    public void testReverseEmptyQueue() {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> expected = new LinkedList<>();

        assertEquals(expected, ReverseQueue.reverseQueue(queue));
    }

    // Test case for a queue with a single element
    @Test
    public void testReverseSingleElementQueue() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(5);

        Queue<Integer> expected = new LinkedList<>();
        expected.add(5);

        assertEquals(expected, ReverseQueue.reverseQueue(queue));
    }
}
