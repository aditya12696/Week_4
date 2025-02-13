package uppertolowerconverter;
import java.io.*;

public class UpperToLowerConverter {
    public static void main(String[] args) {
        String sourceFile = "F:\\Local\\Week04\\Day03\\src\\main\\java\\uppertolowerconverter\\input.txt";  // Input file (contains uppercase text)
        String destinationFile = "F:\\Local\\Week04\\Day03\\src\\main\\java\\uppertolowerconverter\\output.txt"; // Output file (converted text)

        if (convertFileToLowercase(sourceFile, destinationFile)) {
            System.out.println("File successfully converted to lowercase and saved as " + destinationFile);
        } else {
            System.out.println("Failed to process the file.");
        }
    }

    // Method to convert uppercase text to lowercase and write to another file
    public static boolean convertFileToLowercase(String inputPath, String outputPath) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }
            return true;

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
            return false;
        }
    }
}
