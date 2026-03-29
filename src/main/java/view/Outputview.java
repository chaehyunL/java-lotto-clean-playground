package view;

import model.LottoTicket;
import model.LottoTickets;

import java.util.Map;

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

    public void printStatus(Map<Integer, Integer> status) {
        System.out.println("3개 일치 (5000원)-" + status.get(3));
        System.out.println("4개 일치 (50000원)-" + status.get(4));
        System.out.println("5개 일치 (1500000원)-" + status.get(5));
        System.out.println("6개 일치 (2000000000원)- " + status.get(6));
    }

    public void printRoR(double ror) {
        System.out.printf("총 수익률은 %.2f입니다.", ror);
    }
}
