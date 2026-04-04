package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> number){
        this.lottoNumbers=new ArrayList<>(number);
        Collections.sort(this.lottoNumbers);
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
