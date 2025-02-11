package universitycoursemanagement;

import java.util.ArrayList;
import java.util.List;

// Generic class representing a department managing various courses
public class Department<T extends CourseType> {
    public String departmentName;
    public List<Course<T>> courses;

    // Constructor initializes department name and course list
    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.courses = new ArrayList<>();
    }

    // Method to add a course to the department
    public void addCourse(Course<T> course) {
        courses.add(course);
    }

    // Method to display all courses in the department
    public void displayCourses() {
        System.out.println("\nDepartment: " + departmentName);
        for (Course<T> course : courses) {
            course.displayCourseInfo();
        }
    }
}

