package queuequestion.stackusingqueues;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    // Push element onto stack
    public void push(int x) {
        queue1.add(x);
    }

    // Removes and returns the top element of the stack
    public int pop() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        // Move all elements except the last one to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int topElement = queue1.poll(); // Last element in queue1
        swapQueues(); // Swap queue1 and queue2
        return topElement;
    }

    // Get the top element
    public int top() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int topElement = queue1.peek(); // Peek at last element
        queue2.add(queue1.poll()); // Move top element to queue2
        swapQueues(); // Swap queue1 and queue2
        return topElement;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    // Swap queue references
    private void swapQueues() {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); // Output: 3
        System.out.println(stack.top()); // Output: 2
    }
}

