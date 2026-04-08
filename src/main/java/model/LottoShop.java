package model;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static model.LottoRank.MISS;

public class LottoShop {
    private final int money;
    private final int amount;
    private final int manualAmount;
    private final int autoAmount;

    public LottoShop(int money, int manualAmount) {
        this.money = money;
        this.amount = getAmount();
        validateManualAmount(this.amount);
        this.manualAmount=manualAmount;
        this.autoAmount=amount-manualAmount;
    }

    public int getAmount() {
        int count;
        count = money / 1000;
        return count;
    }
    public int getManualAmount() {

        return manualAmount;
    }
    public int getAutoAmount(){
        return autoAmount;
    }

    private void validateManualAmount(int count){
        if(count<0||count>manualAmount){
            throw new IllegalArgumentException("수동 구매 수량이 올바르지 않습니다.");
        }
    }


    public double calculateRateOfReturn(int profit) {
        double rate = (double) profit / money;
        return rate;
    }
}
