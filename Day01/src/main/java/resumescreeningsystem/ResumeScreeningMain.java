package resumescreeningsystem;

public class ResumeScreeningMain {
    public static void main(String[] args) {
        // Create a resume screening pipeline
        ResumeScreeningPipeline pipeline = new ResumeScreeningPipeline();

        // Creating resumes for different job roles
        Resume<SoftwareEngineer> seResume = new Resume<>("R001", new SoftwareEngineer("Alice"));
        Resume<DataScientist> dsResume = new Resume<>("R002", new DataScientist("Bob"));
        Resume<ProductManager> pmResume = new Resume<>("R003", new ProductManager("Charlie"));

        // Adding resumes to the screening pipeline
        pipeline.addResume(seResume);
        pipeline.addResume(dsResume);
        pipeline.addResume(pmResume);

        // Display the screened resumes
        pipeline.displayScreenedResumes();
    }
}
