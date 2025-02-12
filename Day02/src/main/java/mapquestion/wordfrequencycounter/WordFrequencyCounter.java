package mapquestion.wordfrequencycounter;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class WordFrequencyCounter {

    public static Map<String, Integer> countWordFrequency(String filename) {
        Map<String, Integer> wordCount = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-z]", "");
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordCount;
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String filename = inputScanner.nextLine();
        inputScanner.close();

        Map<String, Integer> wordFrequency = countWordFrequency(filename);
        System.out.println(wordFrequency);
    }
}

