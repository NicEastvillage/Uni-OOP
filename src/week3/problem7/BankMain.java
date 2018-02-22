package week3.problem7;

public class BankMain {

    private static BankAccount account = new BankAccount();

    public static void main(String[] args) {

        tryDeposit(100);
        tryDeposit(-50);
        tryWithdraw(30);
        tryWithdraw(-400);
        tryWithdraw(5000);

        System.out.println("Current balance: " + account.getBalance());
    }

    public static void tryDeposit(int amount) {
        try {
            account.deposit(amount);
        } catch (NegativeAmountException e) {
            System.out.println("Illegal amount! Amount cannot be negative.");
        }
    }

    public static void tryWithdraw(int amount) {
        try {
            account.withdraw(amount);
        } catch (NegativeAmountException e) {
            System.out.println("Illegal amount! Amount cannot be negative.");
        } catch (InsufficientFundsException e) {
            System.out.println("Not possible! You are short by " + e.getDeficit());
        }
    }
}
