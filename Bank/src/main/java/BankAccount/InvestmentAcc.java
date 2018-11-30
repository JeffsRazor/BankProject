package BankAccount;

public class InvestmentAcc extends BankAccount {
    @Override
    public void depositMoney(double amount) throws InvalidMoneyAmountException {

    }

    @Override
    public void depositMoneyUsingCheck(String bankRoutingNumber, String checkAccountNumber, double amount) throws InvalidMoneyAmount {

    }

    @Override
    public boolean IsMinimumReached() {
        return false;
    }

    @Override
    public double getMoneyInAccount() {
        return 0;
    }

    @Override
    public void updateAccount() {

    }

    @Override
    public void transferMoney(BankAccount.BankAccount recipient, double amount) {

    }
}
