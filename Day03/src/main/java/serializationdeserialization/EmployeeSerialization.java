package serializationdeserialization;
import java.io.*;
import java.util.*;

public class EmployeeSerialization {
    private static final String FILE_NAME = "employees.ser";

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", "HR", 60000));
        employees.add(new Employee(102, "Bob", "IT", 75000));
        employees.add(new Employee(103, "Charlie", "Finance", 70000));

        // Serialize employee list
        serializeEmployees(employees);

        // Deserialize and display employees
        List<Employee> retrievedEmployees = deserializeEmployees();
        System.out.println("Retrieved Employees:");
        retrievedEmployees.forEach(System.out::println);
    }

    // Method to serialize (save) employees
    public static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees saved successfully.");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }

    // Method to deserialize (retrieve) employees
    public static List<Employee> deserializeEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
        return employees;
    }
}
