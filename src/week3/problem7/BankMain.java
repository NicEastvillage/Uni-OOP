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
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void tryWithdraw(int amount) {
        try {
            account.withdraw(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Not possible! You are short by " + e.getDeficit());
        }
    }
}
