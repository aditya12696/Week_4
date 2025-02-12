package setquestion.settosortedlist;
import java.util.*;

public class SetToSortedList {

    // Method to convert a HashSet to a sorted list in ascending order
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set); // Convert set to list
        Collections.sort(sortedList); // Sort the list in ascending order
        return sortedList;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        // Convert and print the sorted list
        System.out.println("Sorted List: " + convertToSortedList(set));
        // Output: [1, 3, 5, 9]
    }
}

