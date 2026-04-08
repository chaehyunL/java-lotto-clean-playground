package controller;

import model.LottoResult;
import model.LottoTicket;
import model.LottoTickets;
import model.Money;
import model.WinningNumber;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoResult lottoResult = new LottoResult();
    private final LottoTickets lottoTickets = new LottoTickets();

    public void run() {
        Money money = buyTickets();

        showTickets(money);

        WinningNumber winningNumber = new WinningNumber(inputView.getResult());
        int bonusNumber = inputView.getBonusBall();
        int totalPrice = calculateStatus(winningNumber, lottoTickets, money, bonusNumber);
        printStatus(totalPrice, money);

    }

    private Money buyTickets() {
        int getMoney = inputView.getMoney();
        int manualQuantity = inputView.getManualTicketCount();

        Money money = new Money(getMoney, manualQuantity);

        List<LottoTicket> manualTickets = inputView.getManalTicketsNumber(money.getManualAmount());

        lottoTickets.buyManualTickets(manualTickets);
        lottoTickets.buyAutoTickets(money.getAutoAmount());

        return money;
    }

    private void showTickets(Money money) {
        outputView.printPurchaseSummary(money.getManualAmount(), money.getAutoAmount());
        outputView.printMytickets(lottoTickets);
    }

    private int calculateStatus(WinningNumber winningNumber, LottoTickets lottoTickets, Money money, int bonusNumber) {
        lottoResult.calculate(lottoTickets.getTickets(), winningNumber.getWinningNumber(), bonusNumber);

        return money.getWinningAmount(lottoResult.getResult());
    }

    private void printStatus(int profit, Money money) {
        outputView.printHead();
        outputView.printStatus(lottoResult.getResult());
        outputView.printRoR(money.calculateRateOfReturn(profit));
    }
}
