package model;

import java.util.ArrayList;
import java.util.List;


public class LottoTickets {
    private final List<LottoTicket> tickets = new ArrayList<>();
    int quantity;

    public LottoTickets(int quantity) {
        this.quantity = quantity;
        buyTickets();
    }

    public void buyTickets() {
        for (int i = 1; i <= quantity; i++) {
            LottoTicket lottoTicket = new LottoTicket();
            tickets.add(lottoTicket);
        }
    }


    public List<LottoTicket> getTickets() {
        return List.copyOf(tickets);
    }

}
