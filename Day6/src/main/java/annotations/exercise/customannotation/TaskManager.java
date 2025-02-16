package annotations.exercise.customannotation;

class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Adi")
    public void completeTask() {
        System.out.println("Task completed!");
    }
}
