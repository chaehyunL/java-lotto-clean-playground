package model;

import java.util.Map;

import static model.LottoRank.MISS;

public class Money {
    private final int money;
    private final int amount;
    private final int manualAmount;
    private final int autoAmount;

    public Money(int money,int manualamount) {
        this.money = money;
        this.amount = getAmount();
        this.manualAmount=manualamount;
        this.autoAmount=amount-manualamount;
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


    public int getWinningAmount(Map<LottoRank,Integer>status){
        int total=0;
        for(LottoRank lottoRank:LottoRank.values()){
            int count=status.getOrDefault(lottoRank,0);
            if(lottoRank==MISS){
                return total;
            }
            total+=lottoRank.getWinningMoney()*count;
        }
        return total;
    }

    public double calculateRateOfReturn(int profit) {
        double rate = (double) profit / money;
        return rate;
    }
}
