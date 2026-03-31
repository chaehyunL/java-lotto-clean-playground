package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LottoTicket {
    private final List<Integer> lottoNumbers = new ArrayList<>();

    public LottoTicket(){
        makeLottoTicket();
    }
    public void makeLottoTicket() {
        List<Integer> pool = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            pool.add(i);
        }
        Collections.shuffle(pool);

        lottoNumbers.clear();
        lottoNumbers.addAll(pool.subList(0, 6));

        Collections.sort(lottoNumbers);
    }

    public int calculateMatch(List<Integer> winnumbers) {
        return (int) lottoNumbers.stream()
                .filter(winnumbers::contains)
                .count();
    }

    public List<Integer> getLottoNumbers() {
        return List.copyOf(lottoNumbers);
    }
}
