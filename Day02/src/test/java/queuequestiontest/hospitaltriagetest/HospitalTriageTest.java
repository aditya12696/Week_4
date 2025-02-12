package queuequestiontest.hospitaltriagetest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import queuequestion.hospitaltriagesystem.Patient;

import java.util.*;

public class HospitalTriageTest {

    @Test
    void testTriageOrder() {
        PriorityQueue<Patient> queue = new PriorityQueue<>(Comparator.comparingInt((Patient p) -> -p.severity));

        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));

        assertEquals("Alice", queue.poll().name);
        assertEquals("John", queue.poll().name);
        assertEquals("Bob", queue.poll().name);
    }

    @Test
    void testSinglePatient() {
        PriorityQueue<Patient> queue = new PriorityQueue<>(Comparator.comparingInt((Patient p) -> -p.severity));
        queue.add(new Patient("Charlie", 4));

        assertEquals("Charlie", queue.poll().name);
        assertTrue(queue.isEmpty());
    }

    @Test
    void testEmptyQueue() {
        PriorityQueue<Patient> queue = new PriorityQueue<>(Comparator.comparingInt((Patient p) -> -p.severity));
        assertNull(queue.poll()); // Queue should return null when empty
    }
}
