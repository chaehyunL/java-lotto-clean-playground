package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> lottoStatus = new HashMap<>();

    public LottoResult() {
        init();
    }

    public void init() {
        for (int i = 3; i <= 6; i++) {
            lottoStatus.put(i, 0);
        }
    }

    public void calculate(List<LottoTicket> tickets, List<Integer> winningNumbers) {
        for (LottoTicket ticket : tickets) {
            // 1. 각 티켓별로 당첨 번호와 몇 개가 일치하는지 계산
            int matchCount = ticket.calculateMatch(winningNumbers);

            if (matchCount >= 3 && matchCount <= 6) {
                lottoStatus.put(matchCount, lottoStatus.get(matchCount) + 1);
            }
        }
    }

    public Map<Integer, Integer> getResult() {
        return lottoStatus;
    }

}
