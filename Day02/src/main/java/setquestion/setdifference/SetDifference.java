package setquestion.setdifference;
import java.util.*;

public class SetDifference {

    // Method to compute the symmetric difference of two sets
    public static Set<Integer> symmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1); // Copy set1 into result
        Set<Integer> temp = new HashSet<>(set2); // Copy set2 into temp

        result.removeAll(set2); // Remove common elements from set1
        temp.removeAll(set1);   // Remove common elements from set2

        result.addAll(temp); // Union of both remaining sets
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        // Compute and print symmetric difference
        System.out.println("Symmetric Difference: " + symmetricDifference(set1, set2));
        // Output: {1, 2, 4, 5}
    }
}
