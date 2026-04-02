package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static model.LottoRank.MISS;

public class LottoResult {
    private final Map<LottoRank, Integer> lottoStatus = new HashMap<>();

    public LottoResult() {
        initLottoStatus();
    }

    private void initLottoStatus() {
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoStatus.put(lottoRank, 0);
        }
    }

    public void calculate(List<LottoTicket> tickets, List<Integer> winningNumbers) {
        for (LottoTicket ticket : tickets) {
            int matchCount = ticket.calculateMatch(winningNumbers);
            LottoRank lottoRank = LottoRank.find(matchCount);

            if (lottoRank != MISS) {
                lottoStatus.put(lottoRank, lottoStatus.get(lottoRank) + 1);
            }

        }
    }

    public Map<LottoRank, Integer> getResult() {
        return lottoStatus;
    }
}
