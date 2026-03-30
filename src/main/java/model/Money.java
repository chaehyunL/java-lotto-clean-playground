package model;

import java.util.Map;

public class Money {
    private final int money;
    private final int amount;

    public Money(int money) {
        this.money = money;
        this.amount = getAmount();
    }

    public int getAmount() {
        int count;
        count = money / 1000;
        return count;
    }

    public int getProfit(Map<Integer,Integer>status){
        int total=0;
        total=status.get(3)*5000+
                status.get(4)*50000+
                status.get(5)*1500000+
                status.get(6)*2000000000;
        return total;
    }

    public double calculateProfit(int profit) {
        double rate = (double) profit / money;
        return rate;
    }
}
