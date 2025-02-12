package listquestion.frequencycounter;
import java.util.*;

public class FrequencyCounter {

    // Method to count the frequency of each word in the list
    public static Map<String, Integer> countFrequency(List<String> words) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        // Iterate through the list and update count in the HashMap
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange");

        // Print the frequency map
        System.out.println(countFrequency(words));
    }
}

