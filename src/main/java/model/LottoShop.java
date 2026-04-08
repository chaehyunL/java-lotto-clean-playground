package model;

import java.util.Map;

import static model.LottoRank.MISS;

public class LottoShop {
    private final int money;
    private final int amount;
    private final int manualAmount;
    private final int autoAmount;

    public LottoShop(int money, int manualAmount) {
        this.money = money;
        this.amount = getAmount();
        this.manualAmount=manualAmount;
        this.autoAmount=amount-manualAmount;
    }

    public int getAmount() {
        int count;
        count = money / 1000;
        return count;
    }
    public int getManualAmount(){
        return manualAmount;
    }
    public int getAutoAmount(){
        return autoAmount;
    }



    public double calculateRateOfReturn(int profit) {
        double rate = (double) profit / money;
        return rate;
    }
}
