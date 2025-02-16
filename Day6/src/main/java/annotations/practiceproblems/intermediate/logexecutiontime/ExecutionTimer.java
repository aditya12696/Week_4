package annotations.practiceproblems.intermediate.logexecutiontime;

import java.lang.reflect.Method;

public class ExecutionTimer {
    public static void measureExecutionTime(Object obj, String methodName, Object... args) {
        try {
            Method method = obj.getClass().getMethod(methodName);

            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();

                // Invoke the method
                method.invoke(obj);

                long endTime = System.nanoTime();
                System.out.println("Execution time of " + methodName + ": " + (endTime - startTime) / 1_000_000 + " ms");
            } else {
                System.out.println(methodName + " is not annotated with @LogExecutionTime.");
            }
        } catch (Exception e) {
            System.out.println("Error executing method: " + e.getMessage());
        }
    }
}
