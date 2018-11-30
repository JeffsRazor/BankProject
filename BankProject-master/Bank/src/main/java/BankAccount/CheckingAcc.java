package BankAccount;

import Bank.FinancialTracker;


class CheckingAccount extends BankAccount {
    private double  cashInAccount = 0;
    private boolean overDraftProtection;
    private final double overDraftFee = 20;
    public CheckingAccount(FinancialTracker financialTracker, boolean overDraftProtection)
    {
        super(financialTracker);
        this.overDraftProtection = overDraftProtection;
    }

    @Override
    public void depositMoney(double amount) throws InvalidMoneyAmountException {
        if(amount > maxExchange) throw new InvalidMoneyAmountException();
        else{
            cashInAccount= amount - debt;
        }
    }

    @Override
    public  void transferMoney(BankAccount recipient, double amount){
        if(amount > this.cashInAccount && maxDebtAllowed > debt + amount)
        {
            if(!isOverDraftProtected()) chargeOverDraftFee();
            debt = debt + amount - cashInAccount;
            cashInAccount = 0;
            financialTracker.cashUsed(amount);
        }
        else if(amount < this.cashInAccount)
        {
            recipient.depositMoney(cashInAccount - amount);
            cashInAccount -= amount;
            financialTracker.cashUsed(amount);
        }

        else{
            throw new InvalidMoneyAmountException();
        }

    }

    @Override
    public void updateAccount(){
        if(!IsMinimumReached()) cashInAccount =- minimumCharge;
    }

    @Override
    public boolean IsMinimumReached(){
        if(this.cashInAccount < minimumAccountBalance) return false;
        return true;
    }

    @Override
    public double getMoneyInAccount() {
        return this.cashInAccount;
    }

    @Override
    public void depositMoneyUsingCheck(String bankRoutingNumber, String checkAccountNumber, double amount) throws InvalidMoneyAmountException{
        if(amount > maxExchange || !isCheckNumberValid(bankRoutingNumber, checkAccountNumber)) throw new InvalidMoneyAmountException();
        else cashInAccount+=amount;
    }

    private void chargeOverDraftFee(){
        cashInAccount -= overDraftFee;
    }

    private boolean isOverDraftProtected(){
        if(overDraftProtection != false) return true;
        return false;
    }

}
