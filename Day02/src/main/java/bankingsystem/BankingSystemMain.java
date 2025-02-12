package bankingsystem;

public class BankingSystemMain {
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Creating accounts
        bank.createAccount(101, 5000);
        bank.createAccount(102, 7000);
        bank.createAccount(103, 3000);
        bank.createAccount(104, 9000);

        // Deposits
        bank.deposit(101, 2000);
        bank.deposit(103, 1500);

        // Display accounts before withdrawals
        System.out.println("\n=== Account Balances ===");
        bank.displayAccounts();

        // Request withdrawals
        bank.requestWithdrawal(102);
        bank.requestWithdrawal(103);
        bank.requestWithdrawal(104);

        // Process withdrawals
        System.out.println("\n=== Processing Withdrawals ===");
        bank.processWithdrawals(4000);

        // Display accounts sorted by balance
        System.out.println("\n=== Accounts Sorted by Balance ===");
        bank.displayAccountsSortedByBalance();
    }
}
