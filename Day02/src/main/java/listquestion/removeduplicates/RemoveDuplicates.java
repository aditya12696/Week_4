package listquestion.removeduplicates;
import java.util.*;

public class RemoveDuplicates {

    // Method to remove duplicates while preserving order
    public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> seen = new HashSet<>(); // Set to track seen elements
        List<Integer> uniqueList = new ArrayList<>();

        // Iterate through the list and add elements only if they are not already in the set
        for (Integer num : list) {
            if (!seen.contains(num)) {
                seen.add(num);
                uniqueList.add(num);
            }
        }
        return uniqueList;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1, 2, 2, 3, 4);

        // Print the list after removing duplicates
        System.out.println(removeDuplicates(list));
    }
}

