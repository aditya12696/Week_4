package votingsystem;

public class VotingSystemMain {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        // Casting votes
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");

        // Display votes in order of casting
        System.out.println("\n=== Voting Order ===");
        votingSystem.displayVotesInOrder();

        // Display votes sorted by candidate name
        System.out.println("\n=== Sorted by Candidate Name ===");
        votingSystem.displayVotesSorted();

        // Display final results sorted by highest votes
        System.out.println("\n=== Final Election Results ===");
        votingSystem.displayResults();
    }
}
