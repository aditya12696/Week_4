package queuequestion.binarynumbersgenerator;
import java.util.*;

public class BinaryNumbersGenerator {

    // Method to generate first N binary numbers using a queue
    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1"); // Start with "1"

        for (int i = 0; i < N; i++) {
            String current = queue.poll(); // Remove the front element
            result.add(current);

            // Generate next two binary numbers and add to queue
            queue.add(current + "0");
            queue.add(current + "1");
        }

        return result;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int N = 5;
        System.out.println(generateBinaryNumbers(N)); // Output: [1, 10, 11, 100, 101]
    }
}
