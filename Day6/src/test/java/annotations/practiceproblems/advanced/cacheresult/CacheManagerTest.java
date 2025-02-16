package annotations.practiceproblems.advanced.cacheresult;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CacheManagerTest {
    private ExpensiveOperations operations;

    @BeforeEach
    void setUp() {
        operations = new ExpensiveOperations();
    }

    @Test
    void testComputeSquare_CachingWorks() {
        long startTime = System.currentTimeMillis();
        int result1 = (int) CacheManager.executeWithCache(operations, "computeSquare", 5);
        long duration1 = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        int result2 = (int) CacheManager.executeWithCache(operations, "computeSquare", 5);
        long duration2 = System.currentTimeMillis() - startTime;

        assertEquals(25, result1);
        assertEquals(25, result2);
        assertTrue(duration2 < duration1, "Cached call should be faster");
    }

    @Test
    void testComputeSquare_DifferentInputs() {
        int result1 = (int) CacheManager.executeWithCache(operations, "computeSquare", 5);
        int result2 = (int) CacheManager.executeWithCache(operations, "computeSquare", 10);

        assertEquals(25, result1);
        assertEquals(100, result2);
    }

    @Test
    void testComputeSquare_NonCachedMethod() {
        int result1 = (int) CacheManager.executeWithCache(operations, "computeSquare", 3);
        int result2 = (int) CacheManager.executeWithCache(operations, "computeSquare", 3);

        assertEquals(9, result1);
        assertEquals(9, result2);
    }
}
