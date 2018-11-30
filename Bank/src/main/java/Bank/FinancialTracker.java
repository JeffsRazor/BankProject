package Bank;

import java.util.ArrayList;

public abstract class FinancialTracker {

    public abstract void displayExpenses();
    public abstract void calculateWeeklyExpenses();
    public abstract ArrayList <Double>caluclateMonthlyExpenses();
    public abstract ArrayList <Double>calculateYearlyExpenses();
    public abstract double cashUsed(double amount);

}
