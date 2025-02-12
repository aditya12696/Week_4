package queuequestion.hospitaltriagesystem;
import java.util.PriorityQueue;
import java.util.Comparator;
// Hospital Triage System
public class HospitalTriage {

    public static void main(String[] args) {
        // Define a priority queue with a custom comparator for severity
        PriorityQueue<Patient> queue = new PriorityQueue<>(Comparator.comparingInt((Patient p) -> -p.severity));

        // Adding patients to the queue
        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));

        // Treat patients in order of severity
        while (!queue.isEmpty()) {
            System.out.println(queue.poll()); // Process patients in order
        }
    }
}