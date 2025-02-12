package queuequestion.hospitaltriagesystem;
import java.util.PriorityQueue;
import java.util.Comparator;

// Class representing a Patient
public class Patient {
    public String name;
    public int severity; // Higher severity means higher priority

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}