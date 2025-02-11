package universitycoursemanagement;

import java.util.ArrayList;
import java.util.List;

// University class managing multiple departments
public class University {
    public String universityName;
    public List<Department<? extends CourseType>> departments;

    // Constructor initializes university name and departments list
    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
    }

    // Method to add a department to the university
    public void addDepartment(Department<? extends CourseType> department) {
        departments.add(department);
    }

    // Display all departments and their courses
    public void displayUniversityDetails() {
        System.out.println("\n University: " + universityName);
        for (Department<? extends CourseType> department : departments) {
            department.displayCourses();
        }
    }
}
