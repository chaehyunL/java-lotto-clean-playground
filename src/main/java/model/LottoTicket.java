package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LottoTicket {
    private final List<Integer> lottoNumbers = new ArrayList<>();

    public LottoTicket() {
        makeLottoTicket();
    }

    public void makeLottoTicket() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        List<Integer> pool = randomNumberGenerator.getRandomNumberList();
        lottoNumbers.addAll(pool);

        Collections.sort(lottoNumbers);
    }

    public int calculateMatch(List<Integer> winnumbers) {
        return (int) lottoNumbers.stream()
                .filter(winnumbers::contains)
                .count();
    }

    public boolean hasBonusBall(int BonusBall){
        return lottoNumbers.contains(BonusBall);
    }
    public List<Integer> getLottoNumbers() {
        return List.copyOf(lottoNumbers);
    }
}
