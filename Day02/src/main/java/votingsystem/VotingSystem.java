package votingsystem;
import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteCountMap;
    private LinkedHashMap<String, Integer> voteOrderMap;

    public VotingSystem() {
        voteCountMap = new HashMap<>();
        voteOrderMap = new LinkedHashMap<>();
    }

    // Cast a vote for a candidate
    public void castVote(String candidate) {
        voteCountMap.put(candidate, voteCountMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(candidate, voteOrderMap.getOrDefault(candidate, 0) + 1);
    }

    // Display vote count in insertion order (LinkedHashMap)
    public void displayVotesInOrder() {
        System.out.println("Votes in order of casting:");
        voteOrderMap.forEach((candidate, votes) ->
                System.out.println(candidate + " -> " + votes + " votes"));
    }

    // Display vote count sorted by candidate name (TreeMap)
    public void displayVotesSorted() {
        TreeMap<String, Integer> sortedVotes = new TreeMap<>(voteCountMap);
        System.out.println("Votes sorted by candidate name:");
        sortedVotes.forEach((candidate, votes) ->
                System.out.println(candidate + " -> " + votes + " votes"));
    }

    // Display results sorted by highest votes
    public void displayResults() {
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(voteCountMap.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("Final Election Results (Sorted by votes):");
        sortedList.forEach(entry ->
                System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes"));
    }
    public Map<String, Integer> getVoteCountMap() {
        return new TreeMap<>(voteCountMap); // Returns sorted by key
    }

    public LinkedHashMap<String, Integer> getVoteOrderMap() {
        return new LinkedHashMap<>(voteOrderMap); // Maintains insertion order
    }

    public List<Map.Entry<String, Integer>> getSortedResults() {
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(voteCountMap.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue())); // Sort by votes (descending)
        return sortedList;
    }

}
