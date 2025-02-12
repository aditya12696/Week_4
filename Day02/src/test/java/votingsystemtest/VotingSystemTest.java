package votingsystemtest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import votingsystem.VotingSystem;

import java.util.*;

class VotingSystemTest {
    private VotingSystem votingSystem;

    @BeforeEach
    void setUp() {
        votingSystem = new VotingSystem();
    }

    @Test
    void testCastVote() {
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");

        Map<String, Integer> expectedVotes = new HashMap<>();
        expectedVotes.put("Alice", 2);
        expectedVotes.put("Bob", 1);

        // Verify the vote counts
        assertEquals(2, expectedVotes.get("Alice"));
        assertEquals(1, expectedVotes.get("Bob"));
    }

    @Test
    void testVoteOrder() {
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Alice");

        LinkedHashMap<String, Integer> expectedOrder = new LinkedHashMap<>();
        expectedOrder.put("Alice", 2);
        expectedOrder.put("Bob", 1);
        expectedOrder.put("Charlie", 1);

        assertEquals(expectedOrder.keySet(), votingSystem.getVoteOrderMap().keySet());
        assertEquals(expectedOrder.values(), votingSystem.getVoteOrderMap().values());
    }

    @Test
    void testVotesSortedByCandidate() {
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");

        TreeMap<String, Integer> expectedSorted = new TreeMap<>();
        expectedSorted.put("Alice", 2);
        expectedSorted.put("Bob", 1);
        expectedSorted.put("Charlie", 1);

        assertEquals(expectedSorted, votingSystem.getVoteCountMap());
    }

    @Test
    void testResultsSortedByVotes() {
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Charlie");

        List<Map.Entry<String, Integer>> expectedResults = new ArrayList<>();
        expectedResults.add(Map.entry("Charlie", 3));
        expectedResults.add(Map.entry("Alice", 2));
        expectedResults.add(Map.entry("Bob", 1));

        assertEquals(expectedResults, votingSystem.getSortedResults());
    }
}
