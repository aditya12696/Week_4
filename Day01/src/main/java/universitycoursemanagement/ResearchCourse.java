package universitycoursemanagement;

// Represents a research-based course
public class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based Course");
    }

    @Override
    public String getEvaluationMethod() {
        return "Evaluated based on research projects.";
    }
}

