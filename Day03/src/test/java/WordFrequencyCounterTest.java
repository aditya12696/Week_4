import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class WordFrequencyCounterTest {

    @Test
    void testWordCount() throws IOException {
        String testData = "hello world hello world hello test test\n";
        File tempFile = File.createTempFile("test_words", ".txt");

        // Write test data
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write(testData);
        }

        // Read and count words
        Map<String, Integer> wordCountMap = new HashMap<>();
        int totalWords = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(tempFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                        totalWords++;
                    }
                }
            }
        }

        // Expected word counts
        assertEquals(6, totalWords);
        assertEquals(2, wordCountMap.get("hello"));
        assertEquals(2, wordCountMap.get("world"));
        assertEquals(2, wordCountMap.get("test"));

        // Cleanup
        tempFile.delete();
    }
}
