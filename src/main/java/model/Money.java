package model;

import java.util.Map;

import static model.LottoRank.MISS;

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

    public int getProfit(Map<LottoRank,Integer>status){
        int total=0;
        for(LottoRank lottoRank:LottoRank.values()){
            int count=status.get(lottoRank);
            if(lottoRank==MISS){
                return total;
            }
            total+=lottoRank.getWinningMoney()*count;
        }
        return total;
    }

    public double calculateProfit(int profit) {
        double rate = (double) profit / money;
        return rate;
    }
}
