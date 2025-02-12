package mapquestiontest.employeegroupertest;
import static org.junit.jupiter.api.Assertions.*;

import mapquestion.employeesbydepartment.Employee;
import mapquestion.employeesbydepartment.EmployeeGrouper;
import org.junit.jupiter.api.Test;
import java.util.*;

public class EmployeeGrouperTest {

    @Test
    void testGroupByDepartment() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> result = EmployeeGrouper.groupByDepartment(employees);

        assertEquals(2, result.size());
        assertTrue(result.containsKey("HR"));
        assertTrue(result.containsKey("IT"));
        assertEquals(2, result.get("HR").size());
        assertEquals(1, result.get("IT").size());
    }

    @Test
    void testGroupByDepartmentEmptyList() {
        List<Employee> employees = new ArrayList<>();
        assertTrue(EmployeeGrouper.groupByDepartment(employees).isEmpty());
    }
}
