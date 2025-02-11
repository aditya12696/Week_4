package universitycoursemanagement;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class CourseManagementTest extends CourseManagementMain {
    public Department<ExamCourse> scienceDept;
    public Department<AssignmentCourse> humanitiesDept;
    public Department<ResearchCourse> engineeringDept;
    public University university;

    @BeforeEach
    void setUp() {
        university = new University("Tech University");
        scienceDept = new Department<>("Science Department");
        humanitiesDept = new Department<>("Humanities Department");
        engineeringDept = new Department<>("Engineering Department");
    }

    @Test
    void testCourseTypeProperties() {
        ExamCourse examCourse = new ExamCourse();
        assertEquals("Exam-Based Course", examCourse.getTypeName());
        assertEquals("Final exam evaluation.", examCourse.getEvaluationMethod());

        AssignmentCourse assignmentCourse = new AssignmentCourse();
        assertEquals("Assignment-Based Course", assignmentCourse.getTypeName());
        assertEquals("Evaluated based on assignments.", assignmentCourse.getEvaluationMethod());

        ResearchCourse researchCourse = new ResearchCourse();
        assertEquals("Research-Based Course", researchCourse.getTypeName());
        assertEquals("Evaluated based on research projects.", researchCourse.getEvaluationMethod());
    }

    @Test
    void testCourseCreation() {
        Course<ExamCourse> physics = new Course<>("Physics 101", new ExamCourse());
        assertEquals("Physics 101", physics.getCourseName());
        assertEquals("Exam-Based Course", physics.getCourseType().getTypeName());

        Course<AssignmentCourse> history = new Course<>("History of Art", new AssignmentCourse());
        assertEquals("History of Art", history.getCourseName());
        assertEquals("Assignment-Based Course", history.getCourseType().getTypeName());

        Course<ResearchCourse> aiResearch = new Course<>("AI Research", new ResearchCourse());
        assertEquals("AI Research", aiResearch.getCourseName());
        assertEquals("Research-Based Course", aiResearch.getCourseType().getTypeName());
    }

    @Test
    void testDepartmentOperations() {
        Course<ExamCourse> physics = new Course<>("Physics 101", new ExamCourse());
        scienceDept.addCourse(physics);
        assertEquals(1, scienceDept.courses.size());

        Course<AssignmentCourse> history = new Course<>("History of Art", new AssignmentCourse());
        humanitiesDept.addCourse(history);
        assertEquals(1, humanitiesDept.courses.size());

        Course<ResearchCourse> aiResearch = new Course<>("AI Research", new ResearchCourse());
        engineeringDept.addCourse(aiResearch);
        assertEquals(1, engineeringDept.courses.size());
    }

    @Test
    void testUniversityOperations() {
        university.addDepartment(scienceDept);
        university.addDepartment(humanitiesDept);
        university.addDepartment(engineeringDept);
        assertEquals(3, university.departments.size());
    }
}
