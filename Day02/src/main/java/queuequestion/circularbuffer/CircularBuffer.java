package queuequestion.circularbuffer;
import java.util.Arrays;

public class CircularBuffer {
    private int[] buffer;
    private int head, tail, size, capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    // Insert an element into the buffer
    public void insert(int value) {
        if (size == capacity) {
            // Overwrite the oldest element
            head = (head + 1) % capacity;
        } else {
            size++;
        }
        buffer[tail] = value;
        tail = (tail + 1) % capacity;
    }

    // Get current elements in the buffer
    public int[] getBufferContents() {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = buffer[(head + i) % capacity];
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        System.out.println(Arrays.toString(cb.getBufferContents())); // Output: [1, 2, 3]

        cb.insert(4); // Overwrites the oldest element (1)
        System.out.println(Arrays.toString(cb.getBufferContents())); // Output: [2, 3, 4]
    }
}

