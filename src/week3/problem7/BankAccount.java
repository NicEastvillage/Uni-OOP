package week3.problem7;

public class BankAccount {

    private int balance = 0;

    public void deposit(int amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException();
        }

        balance += amount;
    }

    public void withdraw(int amount) throws NegativeAmountException, InsufficientFundsException {
        if (amount < 0) {
            throw new NegativeAmountException();
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
