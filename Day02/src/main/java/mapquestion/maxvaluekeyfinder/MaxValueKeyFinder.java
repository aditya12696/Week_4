package mapquestion.maxvaluekeyfinder;
import java.util.*;

public class MaxValueKeyFinder {
    // Method to find the key with the highest value
    public static String findMaxKey(Map<String, Integer> map) {
        return map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        System.out.println(findMaxKey(map)); // Output: B
    }
}
