package mapquestion.employeesbydepartment;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeGrouper {
    // Method to group employees by department
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> groupedEmployees = groupByDepartment(employees);

        // Print grouped employees
        groupedEmployees.forEach((dept, empList) ->
                System.out.println(dept + ": " + empList));
    }
}
