import org.junit.jupiter.api.*;
import serializationdeserialization.Employee;
import serializationdeserialization.EmployeeSerialization;

import java.io.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeSerializationTest {
    private static final String TEST_FILE = "test_employees.ser";

    @BeforeEach
    void setUp() {
        // Ensure the test file is removed before each test
        new File(TEST_FILE).delete();
    }

    @Test
    void testSerializationAndDeserialization() {
        List<Employee> testEmployees = new ArrayList<>();
        testEmployees.add(new Employee(1, "John", "Engineering", 85000));
        testEmployees.add(new Employee(2, "Emma", "Marketing", 65000));

        // Serialize test data
        EmployeeSerialization.serializeEmployees(testEmployees);

        // Deserialize and check data
        List<Employee> retrievedEmployees = EmployeeSerialization.deserializeEmployees();
        assertEquals(testEmployees.size(), retrievedEmployees.size(), "Size should match.");
        assertEquals(testEmployees.get(0).toString(), retrievedEmployees.get(0).toString(), "First employee should match.");
        assertEquals(testEmployees.get(1).toString(), retrievedEmployees.get(1).toString(), "Second employee should match.");
    }

    @AfterEach
    void tearDown() {
        // Clean up test file after each test
        new File(TEST_FILE).delete();
    }
}
