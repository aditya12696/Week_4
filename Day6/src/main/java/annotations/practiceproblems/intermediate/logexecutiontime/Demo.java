package annotations.practiceproblems.intermediate.logexecutiontime;

public class Demo {

    @LogExecutionTime
    public void fastMethod() {
        System.out.println("Fast method executing...");
    }

    @LogExecutionTime
    public void slowMethod() {
        System.out.println("Slow method executing...");
        try {
            Thread.sleep(500); // Simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();

        // Measure execution time using the ExecutionTimer class
        ExecutionTimer.measureExecutionTime(demo, "fastMethod");
        ExecutionTimer.measureExecutionTime(demo, "slowMethod");
    }
}
