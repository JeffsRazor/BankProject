package Bank;
import org.apache.tomcat.jni.Time;

import java.util.*;

public class FinancialTracker {

    private Double totalCashSpent;
    private Map<Date, Double> trackingExpenditure;

    public FinancialTracker() {
        trackingExpenditure = new HashMap<>();
    }

    public double getDailyExpenses(Date day){
        if(trackingExpenditure.containsKey(day)) return trackingExpenditure.get(day);
        return 0; // should this throw an exception instead?

    }
    public Map<Time, Double> getExpenses(Date startDate, Date endDate) throws  Exception{
        boolean flag = false;
        if(trackingExpenditure.containsKey(startDate) && trackingExpenditure.containsKey(endDate)) {
            Map<Date, Double> returnMap = new HashMap<>();
            for(Map.Entry<Date, Double> x : trackingExpenditure.entrySet()){
              if(x.getKey() == startDate){
                  flag = true;
              }
              if(flag == true) returnMap.put(x.getKey(), x.getValue());

              if(x.getKey() == endDate) flag = false;
            }
        }

        throw new Exception(); // write a better exception
    }

    public void addCash(double amount, Date today){
        if(!trackingExpenditure.containsKey(today)) trackingExpenditure.put(today, amount);
        else trackingExpenditure.replace(today, trackingExpenditure.get(today));
    }

    public double getTotalExpenses(){
        return totalCashSpent;
    }

}
