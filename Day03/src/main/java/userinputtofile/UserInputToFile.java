package userinputtofile;
import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        String fileName = "F:\\Local\\Week04\\Day03\\src\\main\\java\\filehandling\\source.txt"; // Output file

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(fileName, true)) { // Append mode

            // Reading user input
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            // Writing to file
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Language: " + language + "\n");
            writer.write("------------------------------\n");

            System.out.println("\nUser data saved successfully in " + fileName);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
