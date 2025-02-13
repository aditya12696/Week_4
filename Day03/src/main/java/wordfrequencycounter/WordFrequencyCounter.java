package wordfrequencycounter;
import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String filePath = "F:\\Local\\Week04\\Day03\\src\\main\\java\\wordfrequencycounter\\sample_text.txt"; // Change this to your file path
        Map<String, Integer> wordCountMap = new HashMap<>();
        int totalWords = 0;

        // Read the file and count word occurrences
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Normalize and split words
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                        totalWords++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Sort words by frequency in descending order
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCountMap.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Display results
        System.out.println("Total Words: " + totalWords);
        System.out.println("Top 5 Most Frequent Words:");
        for (int i = 0; i < Math.min(5, sortedWords.size()); i++) {
            System.out.println(sortedWords.get(i).getKey() + " - " + sortedWords.get(i).getValue());
        }
    }
}
