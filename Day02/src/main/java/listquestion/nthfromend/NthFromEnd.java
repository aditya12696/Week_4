package listquestion.nthfromend;
import java.util.*;

public class NthFromEnd {

    // Method to find the Nth element from the end
    public static String findNthFromEnd(LinkedList<String> list, int n) {
        Iterator<String> first = list.iterator();
        Iterator<String> second = list.iterator();

        // Move the first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (!first.hasNext()) {
                return "N is larger than the list size"; // Handle edge case
            }
            first.next();
        }

        // Move both pointers together until the first pointer reaches the end
        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next(); // The second pointer now points to the Nth node from the end
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;

        // Print the Nth element from the end
        System.out.println(findNthFromEnd(list, n));
    }
}

