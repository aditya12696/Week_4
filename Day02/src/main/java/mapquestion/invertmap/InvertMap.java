package mapquestion.invertmap;
import java.util.*;

public class InvertMap {

    // Method to invert a map
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> inputMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : inputMap.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            // Add key to the corresponding value list
            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }
        return invertedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1);

        Map<Integer, List<String>> inverted = invertMap(inputMap);
        System.out.println(inverted); // Output: {1=[A, C], 2=[B]}
    }
}

