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
        int MinlottoNumber=1;
        int MaxlottoNumber=45;
        for (int i = MinlottoNumber; i <= MaxlottoNumber; i++) {
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
