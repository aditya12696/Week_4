package queuequestiontest.circularbuffertest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import queuequestion.circularbuffer.CircularBuffer;

import java.util.Arrays;

public class CircularBufferTest {

    @Test
    void testInsertAndRetrieve() {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);

        assertArrayEquals(new int[]{1, 2, 3}, cb.getBufferContents());

        cb.insert(4); // Overwrite 1
        assertArrayEquals(new int[]{2, 3, 4}, cb.getBufferContents());
    }

    @Test
    void testOverwriteOldest() {
        CircularBuffer cb = new CircularBuffer(2);
        cb.insert(10);
        cb.insert(20);
        assertArrayEquals(new int[]{10, 20}, cb.getBufferContents());

        cb.insert(30); // Overwrite 10
        assertArrayEquals(new int[]{20, 30}, cb.getBufferContents());

        cb.insert(40); // Overwrite 20
        assertArrayEquals(new int[]{30, 40}, cb.getBufferContents());
    }

    @Test
    void testSmallBuffer() {
        CircularBuffer cb = new CircularBuffer(1);
        cb.insert(5);
        assertArrayEquals(new int[]{5}, cb.getBufferContents());

        cb.insert(6); // Overwrite 5
        assertArrayEquals(new int[]{6}, cb.getBufferContents());
    }
}
