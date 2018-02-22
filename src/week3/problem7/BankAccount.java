package week3.problem7;

public class BankAccount {

    private int balance = 0;

    public void deposit(int amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Illegal amount! Amount cannot be negative.");
        }

        balance += amount;
    }

    public void withdraw(int amount) throws IllegalArgumentException, InsufficientFundsException {
        if (amount < 0) {
            throw new IllegalArgumentException("Illegal amount! Amount cannot be negative.");
        }

        if (amount > balance) {
            throw new InsufficientFundsException(amount - balance);
        }

        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
