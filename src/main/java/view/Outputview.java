package view;

import model.LottoRank;
import model.LottoResult;
import model.LottoTicket;
import model.LottoTickets;

import java.util.Map;

import static model.LottoRank.MISS;

public class Outputview {
    public void printMyTickets(int quantity, LottoTickets tickets) {
        System.out.println("\n" + quantity + "개를 구매했습니다.");
        for (LottoTicket ticket : tickets.getTickets()) {
            System.out.println(ticket.getLottoNumbers());
        }
        System.out.println(" ");
    }


    public void printHead() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public void printStatus(Map<LottoRank, Integer> lottoStatus) {
        for(LottoRank lottoRank:LottoRank.values()) {
            int count=lottoStatus.get(lottoRank);
            if(lottoRank==MISS){
                break;
            }
            System.out.println(lottoRank.getMatchCount()+"개 일치 ("
                    +lottoRank.getWinningMoney()+"원)- "
                    +count+"개");
        }
    }

    public void printRoR(double ror) {
        System.out.printf("총 수익률은 %.2f입니다.", ror);
    }
}
