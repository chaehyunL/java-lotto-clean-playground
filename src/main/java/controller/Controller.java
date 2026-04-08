package controller;

import model.LottoResult;
import model.LottoTicket;
import model.LottoTickets;
import model.LottoShop;
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
        LottoShop money = buyTickets();

        showTickets(money);

        WinningNumber winningNumber = new WinningNumber(inputView.getResult());
        int bonusNumber = inputView.getBonusBall();
        int totalPrice = calculateStatus(winningNumber, lottoTickets, money, bonusNumber);
        printStatus(totalPrice, money);

    }

    private LottoShop buyTickets() {
        int getMoney = inputView.getMoney();
        int manualQuantity = inputView.getManualTicketCount();

        LottoShop money = new LottoShop(getMoney, manualQuantity);

        List<LottoTicket> manualTickets = inputView.getManalTicketsNumber(money.getManualAmount());

        lottoTickets.buyManualTickets(manualTickets);
        lottoTickets.buyAutoTickets(money.getAutoAmount());

        return money;
    }

    private void showTickets(LottoShop money) {
        outputView.printPurchaseSummary(money.getManualAmount(), money.getAutoAmount());
        outputView.printMytickets(lottoTickets);
    }

    private int calculateStatus(WinningNumber winningNumber, LottoTickets lottoTickets, LottoShop money, int bonusNumber) {
        lottoResult.calculate(lottoTickets.getTickets(), winningNumber.getWinningNumber(), bonusNumber);

        return money.getWinningAmount(lottoResult.getResult());
    }

    private void printStatus(int profit, LottoShop money) {
        outputView.printHead();
        outputView.printStatus(lottoResult.getResult());
        outputView.printProfit(money.calculateRateOfReturn(profit));
    }
}
