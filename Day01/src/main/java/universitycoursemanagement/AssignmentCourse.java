package universitycoursemanagement;

// Represents an assignment-based course
public class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based Course");
    }

    @Override
    public String getEvaluationMethod() {
        return "Evaluated based on assignments.";
    }
}

