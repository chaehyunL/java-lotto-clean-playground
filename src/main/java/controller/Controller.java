package controller;

import model.LottoResult;
import model.LottoTicket;
import model.LottoTickets;
import model.Money;
import model.WinningNumber;
import view.Inputview;
import view.Outputview;

import java.util.List;

public class Controller {
    private final Inputview inputview = new Inputview();
    private final Outputview outputview = new Outputview();
    private final LottoResult lottoResult = new LottoResult();
    private final LottoTickets lottoTickets = new LottoTickets();

    public void run() {
        Money money = buyTickets();

        showTickets(money);

        WinningNumber winningNumber = new WinningNumber(inputview.getResult());
        int bonusNumber = inputview.getBonusBall();
        int totalPrice = calculateStatus(winningNumber, lottoTickets, money, bonusNumber);
        printStatus(totalPrice, money);

    }

    private Money buyTickets() {
        int getMoney = inputview.getMoney();
        int manualquantity = inputview.getManualTicketCount();

        Money money = new Money(getMoney, manualquantity);

        List<LottoTicket> manualTickets = inputview.getManalTicketsNumber(money.getManualAmount());

        lottoTickets.buyManualTickets(manualTickets);
        lottoTickets.buyAutoTickets(money.getAutoAmount());

        return money;
    }

    private void showTickets(Money money) {
        outputview.printPurchaseSummary(money.getManualAmount(), money.getAutoAmount());
        outputview.printMytickets(lottoTickets);
    }

    private int calculateStatus(WinningNumber winningNumber, LottoTickets lottoTickets, Money money, int bonusNumber) {
        lottoResult.calculate(lottoTickets.getTickets(), winningNumber.getWinningNumber(), bonusNumber);

        return money.getWinningAmount(lottoResult.getResult());
    }

    private void printStatus(int profit, Money money) {
        outputview.printHead();
        outputview.printStatus(lottoResult.getResult());
        outputview.printRoR(money.calculateRateOfReturn(profit));
    }
}
