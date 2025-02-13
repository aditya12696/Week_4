package largefilereader;
import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        String filePath = "F:\\Local\\Week04\\Day03\\src\\main\\java\\largefilereader\\large_log.txt"; // Change to your file path

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) { // Case-insensitive search
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
