package universitycoursemanagement;

public class CourseManagementMain {
    public static void main(String[] args) {
        // Creating a university
        University university = new University("Tech University");

        // Creating departments for different course types
        Department<ExamCourse> scienceDept = new Department<>("Science Department");
        Department<AssignmentCourse> humanitiesDept = new Department<>("Humanities Department");
        Department<ResearchCourse> engineeringDept = new Department<>("Engineering Department");

        // Adding courses to Science Department (Exam-Based)
        scienceDept.addCourse(new Course<>("Physics 101", new ExamCourse()));
        scienceDept.addCourse(new Course<>("Mathematics 202", new ExamCourse()));

        // Adding courses to Humanities Department (Assignment-Based)
        humanitiesDept.addCourse(new Course<>("History of Art", new AssignmentCourse()));
        humanitiesDept.addCourse(new Course<>("Philosophy & Ethics", new AssignmentCourse()));

        // Adding courses to Engineering Department (Research-Based)
        engineeringDept.addCourse(new Course<>("AI Research", new ResearchCourse()));
        engineeringDept.addCourse(new Course<>("Quantum Computing", new ResearchCourse()));

        // Adding departments to the university
        university.addDepartment(scienceDept);
        university.addDepartment(humanitiesDept);
        university.addDepartment(engineeringDept);

        // Displaying university details
        university.displayUniversityDetails();
    }
}

