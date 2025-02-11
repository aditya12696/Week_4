package universitycoursemanagement;

// Represents an exam-based course
public class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based Course");
    }

    @Override
    public String getEvaluationMethod() {
        return "Final exam evaluation.";
    }
}

