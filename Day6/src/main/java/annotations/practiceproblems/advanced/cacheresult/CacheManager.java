package annotations.practiceproblems.advanced.cacheresult;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CacheManager {
    private static final Map<String, Object> cache = new HashMap<>();

    public static Object executeWithCache(Object obj, String methodName, Object... args) {
        try {
            // Create a unique key for method call
            String key = methodName + "(" + args[0] + ")";

            // Check if result is already cached
            if (cache.containsKey(key)) {
                System.out.println("Returning cached result for " + key);
                return cache.get(key);
            }

            // Get the method
            Method method = obj.getClass().getMethod(methodName, int.class);

            // Check if method is annotated with @CacheResult
            if (method.isAnnotationPresent(CacheResult.class)) {
                Object result = method.invoke(obj, args);
                cache.put(key, result);  // Store result in cache
                return result;
            } else {
                return method.invoke(obj, args);
            }

        } catch (Exception e) {
            System.out.println("Error executing method: " + e.getMessage());
            return null;
        }
    }
}
