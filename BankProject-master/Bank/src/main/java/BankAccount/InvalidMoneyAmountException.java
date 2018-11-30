package BankAccount;

public class InvalidMoneyAmountException extends RuntimeException {
    public InvalidMoneyAmountException()

    {
        System.out.print("Incorrect amount of money.");
    }
}
