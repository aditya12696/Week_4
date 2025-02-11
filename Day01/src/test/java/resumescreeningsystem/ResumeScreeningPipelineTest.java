package resumescreeningsystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class ResumeScreeningPipelineTest extends ResumeScreeningMain {
    private ResumeScreeningPipeline pipeline;

    @BeforeEach
    void setUp() {
        pipeline = new ResumeScreeningPipeline();
    }

    @Test
    void testJobRoleEvaluation() {
        SoftwareEngineer se = new SoftwareEngineer("Alice");
        assertEquals("Alice - Evaluated for Software Engineer role: Strong programming skills required.", se.evaluateResume());

        DataScientist ds = new DataScientist("Bob");
        assertEquals("Bob - Evaluated for Data Scientist role: Proficiency in data analysis, ML, and statistics required.", ds.evaluateResume());

        ProductManager pm = new ProductManager("Charlie");
        assertEquals("Charlie - Evaluated for Product Manager role: Strong leadership and strategic skills required.", pm.evaluateResume());
    }

    @Test
    void testResumeCreation() {
        Resume<SoftwareEngineer> seResume = new Resume<>("R001", new SoftwareEngineer("Alice"));
        assertEquals("R001", seResume.getResumeId());
        assertEquals("Alice - Evaluated for Software Engineer role: Strong programming skills required.", seResume.getJobRole().evaluateResume());

        Resume<DataScientist> dsResume = new Resume<>("R002", new DataScientist("Bob"));
        assertEquals("R002", dsResume.getResumeId());
        assertEquals("Bob - Evaluated for Data Scientist role: Proficiency in data analysis, ML, and statistics required.", dsResume.getJobRole().evaluateResume());

        Resume<ProductManager> pmResume = new Resume<>("R003", new ProductManager("Charlie"));
        assertEquals("R003", pmResume.getResumeId());
        assertEquals("Charlie - Evaluated for Product Manager role: Strong leadership and strategic skills required.", pmResume.getJobRole().evaluateResume());
    }

    @Test
    void testResumeScreeningPipelineOperations() {
        Resume<SoftwareEngineer> seResume = new Resume<>("R001", new SoftwareEngineer("Alice"));
        Resume<DataScientist> dsResume = new Resume<>("R002", new DataScientist("Bob"));
        Resume<ProductManager> pmResume = new Resume<>("R003", new ProductManager("Charlie"));

        pipeline.addResume(seResume);
        pipeline.addResume(dsResume);
        pipeline.addResume(pmResume);

        assertEquals(3, pipeline.resumeList.size());
    }
}
