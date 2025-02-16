package annotations.practiceproblems.advanced.cacheresult;

class ExpensiveOperations {

    @CacheResult
    public int computeSquare(int number) {
        System.out.println("Computing square of " + number + "...");
        try {
            Thread.sleep(2000); // Simulate expensive computation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number * number;
    }

    public static void main(String[] args) {
        ExpensiveOperations operations = new ExpensiveOperations();

        // Call method multiple times with the same input
        System.out.println("Result: " + CacheManager.executeWithCache(operations, "computeSquare", 5));
        System.out.println("Result: " + CacheManager.executeWithCache(operations, "computeSquare", 5)); // Cached
        System.out.println("Result: " + CacheManager.executeWithCache(operations, "computeSquare", 10));
        System.out.println("Result: " + CacheManager.executeWithCache(operations, "computeSquare", 10)); // Cached
    }
}
