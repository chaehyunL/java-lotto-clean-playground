package controller;

import model.LottoResult;
import model.LottoTickets;
import model.Money;
import view.Inputview;
import view.Outputview;

import java.util.List;
import java.util.Map;

public class Controller {
    public void run() {
        Inputview inputview = new Inputview();
        int getMoney = inputview.getMoney();

        Money money = new Money(getMoney);
        LottoTickets lottoTickets = new LottoTickets(money.getAmount());
        lottoTickets.buyTickets();
        Outputview outputview = new Outputview();
        outputview.printMyTickets(money.getAmount(), lottoTickets);

        List<Integer> Resultnumber = inputview.getResult();

        outputview.printHead();
        LottoResult lottoResult = new LottoResult();
        lottoResult.calculate(lottoTickets.getTickets(), Resultnumber);

        outputview.printStatus(lottoResult.getResult());
        int totalPrice = money.getProfit(lottoResult.getResult());
        outputview.printRoR(money.calculateProfit(totalPrice));
    }
}
