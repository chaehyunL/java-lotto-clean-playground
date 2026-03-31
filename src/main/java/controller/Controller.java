package controller;

import model.LottoResult;
import model.LottoTickets;
import model.Money;
import view.Inputview;
import view.Outputview;

import java.lang.reflect.WildcardType;
import java.util.List;
import java.util.Map;

public class Controller {
    public void run() {
        Inputview inputview=new Inputview();

        Money money=payMoney();

        LottoTickets lottoTickets =buyTickets(money);

        showTickets(money,lottoTickets);

        showStatus(lottoTickets,money);


    }
    private Money payMoney(){
        Inputview inputview = new Inputview();
        int getMoney = inputview.getMoney();
        Money money = new Money(getMoney);
        return money;
    }
    private LottoTickets buyTickets(Money money){
        LottoTickets lottoTickets = new LottoTickets(money.getAmount());
        return lottoTickets;
    }

    private void showTickets(Money money,LottoTickets lottoTickets){
        Outputview outputview = new Outputview();
        outputview.printMyTickets(money.getAmount(), lottoTickets);
    }

    private void showStatus(LottoTickets lottoTickets,Money money){
        Inputview inputview=new Inputview();
        List<Integer> winningNumber = inputview.getResult();

        Outputview outputview=new Outputview();
        outputview.printHead();
        LottoResult lottoResult = new LottoResult();
        lottoResult.calculate(lottoTickets.getTickets(), winningNumber);

        outputview.printStatus(lottoResult.getResult());
        int totalPrice = money.getProfit(lottoResult.getResult());
        outputview.printRoR(money.calculateProfit(totalPrice));
    }
}
