package studentdatastream;
import java.io.*;

public class StudentDataStream {
    private static final String FILE_NAME = "F:\\Local\\Week04\\Day03\\src\\main\\java\\studentdatastream\\student_data.bin";

    public static void main(String[] args) {
        // Sample student details
        int rollNumber = 101;
        String name = "Aditya";
        double gpa = 8.7;

        // Writing data to binary file
        if (writeStudentData(rollNumber, name, gpa)) {
            System.out.println("Student data stored successfully.\n");
        }

        // Reading data from binary file
        readStudentData();
    }

    // Method to write student details to a binary file
    public static boolean writeStudentData(int rollNumber, String name, double gpa) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
            return true;
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            return false;
        }
    }

    // Method to read student details from a binary file
    public static void readStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            int rollNumber = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("Retrieved Student Data:");
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
