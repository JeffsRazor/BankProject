package BankAccount;

import Bank.FinancialTracker;



//maybe make this an abstract class?
public abstract class BankAccount {
    protected  double minimumAccountBalance = 1000; // an account must have at least 1,000$ as to not be charged.
    protected  double minimumCharge = 20; // if they don't charge the account
    protected  double maxExchange = 20000; // the bank will only accept a deposit of 20,000$
    protected FinancialTracker financialTracker;
    protected double debt = 0;
    protected double maxDebtAllowed = 20000;

    public BankAccount(FinancialTracker financialTracker){
        this.financialTracker = financialTracker;
    }
    public abstract void depositMoney(double amount) throws InvalidMoneyAmountException;
    public abstract void depositMoneyUsingCheck(String bankRoutingNumber, String checkAccountNumber, double amount) throws InvalidMoneyAmountException;
    public abstract void transferMoney(BankAccount recipient, double amount);
    public abstract boolean IsMinimumReached();
    public abstract double getMoneyInAccount();
    public abstract void updateAccount(); // needs to implemented by each subclass. in progress
    
    
    public double getMinimumCharge() {return minimumCharge;}
    
    public boolean isCheckNumberValid(String bankRoutingNumber, String checkAccountNumber) {
     if(bankRoutingNumber.length() != 9 || checkAccountNumber.length() > 17 || checkAccountNumber.length() < 0) return false;
     return true;
    }


}
