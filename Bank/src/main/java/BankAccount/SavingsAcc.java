package BankAccount;

import Bank.FinancialTracker;


 class SavingsAccount extends BankAccount {
    private double cashInAccount = 0;
    private double accountWithdrawLimit = 20000;
    private final double interestRate = 1.03;

    public SavingsAccount(FinancialTracker financialTracker) {
        super(financialTracker);
    }

    @Override
    public double getMoneyInAccount() {
        return this.cashInAccount;
    }

    @Override
    public void transferMoney(BankAccount recipient, double amount) throws InvalidMoneyAmountException {
        if (!isWithdrawalLimitReached() && amount < cashInAccount) {
            recipient.depositMoney(amount);
            cashInAccount -= amount;
            financialTracker.cashUsed(amount);
            accountWithdrawLimit -= amount;
        } else throw new InvalidMoneyAmountException();

    }

    @Override
    public void depositMoney(double amount) throws InvalidMoneyAmountException {
        if (amount > maxExchange) throw new InvalidMoneyAmountException();
        else cashInAccount += amount;
    }


    @Override
    public boolean IsMinimumReached() {
        {
            if (this.cashInAccount < minimumAccountBalance) return false;
            return true;
        }
    }


    @Override
    public void updateAccount () {
        if (!IsMinimumReached()) cashInAccount =- minimumCharge;
        addCompoundInterest();
        accountWithdrawLimit = 20000;
    }

    @Override
    public void depositMoneyUsingCheck(String bankRoutingNumber, String checkAccountNumber, double amount) throws InvalidMoneyAmountException{
        if(amount > maxExchange || !isCheckNumberValid(bankRoutingNumber, checkAccountNumber)) throw new InvalidMoneyAmountException();
        else cashInAccount+=amount;
    }

    private boolean isWithdrawalLimitReached () {
        if (accountWithdrawLimit > 0) return true;
        return false;
    } // Used for withdrawing money


   private void addCompoundInterest(){
        cashInAccount *= interestRate;
   }


}
