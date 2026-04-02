package model;

import java.util.List;

public class WinningNumber {
    private List<Integer> winningNumber;

    public WinningNumber(List<Integer> winningNumber){
        this.winningNumber=winningNumber;
        validateRange(winningNumber);
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
    private final int minNumber=1;
    private final int maxNumber=45;
    private void validateRange(List<Integer> Numbers){
        for(Integer number:Numbers){
            if(minNumber>number||number>maxNumber){
                throw new IllegalArgumentException("[ERROR]1과 45사이의 숫자를 입력하시오");
            }
        }
    }
}
