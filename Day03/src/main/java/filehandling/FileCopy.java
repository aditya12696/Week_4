package filehandling;
import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "F:\\Local\\Week04\\Day03\\src\\main\\java\\filehandling\\source.txt"; // Source file path
        String destinationFile = "F:\\Local\\Week04\\Day03\\src\\main\\java\\filehandling\\destination.txt"; // Destination file path

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            System.out.println("File copied successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Source file does not exist: " + sourceFile);
        } catch (IOException e) {
            System.out.println("An error occurred while copying the file: " + e.getMessage());
        }
    }
}
