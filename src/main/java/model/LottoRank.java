package model;

public enum LottoRank {
    THREE(3,5000),
    FOUR(4,50000),
    FIVE(5,1500000),
    SIX(6,2000000000);

    private final int matchCount;
    private final int winningMoney;

    LottoRank(int matchCount,int winningMoney){
        this.matchCount=matchCount;
        this.winningMoney=winningMoney;
    }

    public int getMatchCount(){
        return matchCount;
    }
    public int getWinningMoney(){
        return winningMoney;
    }

}
