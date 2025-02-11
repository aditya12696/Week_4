package resumescreeningsystem;

import java.util.ArrayList;
import java.util.List;

// Resume Screening Pipeline class for dynamically processing resumes
public class ResumeScreeningPipeline {
    public List<Resume<? extends JobRole>> resumeList;

    // Constructor initializes resume list
    public ResumeScreeningPipeline() {
        this.resumeList = new ArrayList<>();
    }

    // Generic method to add resumes to the screening pipeline
    public <T extends JobRole> void addResume(Resume<T> resume) {
        resumeList.add(resume);
    }

    // Display all resumes in the screening pipeline
    public void displayScreenedResumes() {
        System.out.println("\n AI-Driven Resume Screening Results:");
        for (Resume<? extends JobRole> resume : resumeList) {
            resume.displayResumeInfo();
        }
    }
}