package queuequestiontest.stackusingqueuestest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import queuequestion.stackusingqueues.StackUsingQueues;

public class StackUsingQueuesTest {

    @Test
    void testPushAndPop() {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop()); // Last in, first out
        assertEquals(2, stack.top()); // Top should be 2 now
    }

    @Test
    void testTop() {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(5);
        stack.push(10);

        assertEquals(10, stack.top()); // Top should be 10
    }

    @Test
    void testIsEmpty() {
        StackUsingQueues stack = new StackUsingQueues();
        assertTrue(stack.isEmpty()); // Stack should be empty initially

        stack.push(1);
        assertFalse(stack.isEmpty()); // Stack should not be empty after push

        stack.pop();
        assertTrue(stack.isEmpty()); // Stack should be empty after popping last element
    }

    @Test
    void testPopOnEmptyStack() {
        StackUsingQueues stack = new StackUsingQueues();
        Exception exception = assertThrows(RuntimeException.class, stack::pop);
        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    void testTopOnEmptyStack() {
        StackUsingQueues stack = new StackUsingQueues();
        Exception exception = assertThrows(RuntimeException.class, stack::top);
        assertEquals("Stack is empty", exception.getMessage());
    }
}
