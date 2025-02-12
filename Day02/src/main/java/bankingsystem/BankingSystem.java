package bankingsystem;

import java.util.*;

public class BankingSystem {
    private Map<Integer, Double> accounts;  // HashMap stores account balances
    private Queue<Integer> withdrawalQueue; // Queue for processing withdrawals

    public BankingSystem() {
        accounts = new HashMap<>();
        withdrawalQueue = new LinkedList<>();
    }

    // Create a new account
    public void createAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
    }

    // Deposit money
    public void deposit(int accountNumber, double amount) {
        accounts.put(accountNumber, accounts.getOrDefault(accountNumber, 0.0) + amount);
    }

    // Request withdrawal (added to queue)
    public void requestWithdrawal(int accountNumber) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Invalid account number!");
            return;
        }
        withdrawalQueue.add(accountNumber);
    }

    // Process withdrawal requests
    public void processWithdrawals(double withdrawalAmount) {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            double currentBalance = accounts.get(accountNumber);

            if (currentBalance >= withdrawalAmount) {
                accounts.put(accountNumber, currentBalance - withdrawalAmount);
                System.out.println("Withdrawal of $" + withdrawalAmount + " processed for account " + accountNumber);
            } else {
                System.out.println("Insufficient balance for account " + accountNumber);
            }
        }
    }

    // Display accounts sorted by balance using TreeMap
    public void displayAccountsSortedByBalance() {
        TreeMap<Double, Integer> sortedAccounts = new TreeMap<>(Collections.reverseOrder());

        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            sortedAccounts.put(entry.getValue(), entry.getKey());
        }

        System.out.println("Accounts sorted by balance:");
        sortedAccounts.forEach((balance, accountNumber) ->
                System.out.println("Account " + accountNumber + " -> $" + balance));
    }

    // Display all accounts
    public void displayAccounts() {
        System.out.println("All accounts:");
        accounts.forEach((accountNumber, balance) ->
                System.out.println("Account " + accountNumber + " -> $" + balance));
    }
    public Map<Integer, Double> getAccounts() {
        return new HashMap<>(accounts);
    }

    public Queue<Integer> getWithdrawalQueue() {
        return new LinkedList<>(withdrawalQueue);
    }

    public TreeMap<Double, Integer> getSortedAccounts() {
        TreeMap<Double, Integer> sortedAccounts = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            sortedAccounts.put(entry.getValue(), entry.getKey());
        }
        return sortedAccounts;
    }

}
