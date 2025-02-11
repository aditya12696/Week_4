package universitycoursemanagement;

// Abstract class representing different types of university courses
public abstract class CourseType {
    public String typeName;

    // Constructor initializes the course type name
    public CourseType(String typeName) {
        this.typeName = typeName;
    }

    // Getter for course type name
    public String getTypeName() {
        return typeName;
    }

    // Abstract method for evaluation method description
    public abstract String getEvaluationMethod();
}

