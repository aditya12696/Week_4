package universitycoursemanagement;

// Generic class representing a university course
public class Course<T extends CourseType> {
    public String courseName;
    public T courseType;

    // Constructor initializes course name and type
    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    // Getter for course name
    public String getCourseName() {
        return courseName;
    }

    // Getter for course type
    public T getCourseType() {
        return courseType;
    }

    // Display course details
    public void displayCourseInfo() {
        System.out.println("Course: " + courseName + " | Type: " + courseType.getTypeName() +
                " | Evaluation: " + courseType.getEvaluationMethod());
    }
}

