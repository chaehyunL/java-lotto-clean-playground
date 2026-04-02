package controller;

import model.LottoRank;
import model.LottoResult;
import model.LottoTickets;
import model.Money;
import view.Inputview;
import view.Outputview;

import java.lang.reflect.WildcardType;
import java.util.List;
import java.util.Map;

public class Controller {
    private final Inputview inputview = new Inputview();
    private final Outputview outputview=new Outputview();
    private final LottoResult lottoResult=new LottoResult();
    public void run() {
        Money money = payMoney();

        LottoTickets lottoTickets = buyTickets(money);

        showTickets(money, lottoTickets);

        int totalPrice=calculateStatus(lottoTickets,money);

        printStatus(totalPrice,money);

    }

    private Money payMoney() {

        int getMoney = inputview.getMoney();
        Money money = new Money(getMoney);
        return money;
    }

    private LottoTickets buyTickets(Money money) {
        LottoTickets lottoTickets = new LottoTickets(money.getAmount());
        return lottoTickets;
    }

    private void showTickets(Money money, LottoTickets lottoTickets) {
        outputview.printMyTickets(money.getAmount(), lottoTickets);
    }

    private int calculateStatus(LottoTickets lottoTickets, Money money) {

        List<Integer> winningNumber = inputview.getResult();
        lottoResult.calculate(lottoTickets.getTickets(), winningNumber);
;
        int totalPrice = money.getProfit(lottoResult.getResult());
        return totalPrice;
    }
    private void printStatus(int profit,Money money){
        outputview.printHead();
        outputview.printStatus(lottoResult.getResult());
        outputview.printRoR(money.calculateProfit(profit));
    }
}
