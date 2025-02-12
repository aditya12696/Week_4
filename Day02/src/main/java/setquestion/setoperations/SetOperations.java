package setquestion.setoperations;
import java.util.*;

public class SetOperations {

    // Method to compute the union of two sets
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1); // Copy set1 into result
        result.addAll(set2); // Add all elements of set2
        return result;
    }

    // Method to compute the intersection of two sets
    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1); // Copy set1 into result
        result.retainAll(set2); // Keep only common elements
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        // Compute and print union and intersection
        System.out.println("Union: " + union(set1, set2));           // Output: {1, 2, 3, 4, 5}
        System.out.println("Intersection: " + intersection(set1, set2)); // Output: {3}
    }
}
