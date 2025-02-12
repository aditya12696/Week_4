package setquestion.subsetcheck;
import java.util.*;

public class SubsetCheck {

    // Method to check if set1 is a subset of set2
    public static boolean isSubset(Set<Integer> set1, Set<Integer> set2) {
        return set2.containsAll(set1); // Returns true if set2 contains all elements of set1
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        // Print whether set1 is a subset of set2
        System.out.println("Is Set1 a subset of Set2? " + isSubset(set1, set2));
        // Output: true
    }
}

