package setquestion.comparesets;
import java.util.*;

public class CompareSets {

    // Method to check if two sets are equal
    public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {
        return set1.equals(set2); // Directly compare sets using equals()
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));

        // Print whether the sets are equal
        System.out.println(areSetsEqual(set1, set2)); // Output: true
    }
}
