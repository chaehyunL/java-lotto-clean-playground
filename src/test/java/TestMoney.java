import model.LottoRank;
import model.LottoTickets;
import model.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TestMoney {
    @Test
    @DisplayName("가격을 입력받았을때 올바른 자동티켓/수동티켓을 반환하는지")
    public void getAmountTest() {
        //given:2만월을 받고, 2개의 수동 티켓을 받음
        int inputMoney = 20000;
        Money money = new Money(inputMoney, 2);
        //when: 2개의 수동 티켓/18개의 자동티켓/총티켓 20
        int TrueManualamount = 2;
        int TrueAutoamount = 18;
        int TrueTotalAmount = 20;
        //then:수동티켓/자동티켓/총 티켓 갯수 일치하는지 확인해주기
        Assertions.assertEquals(TrueManualamount, money.getManualAmount());
        Assertions.assertEquals(TrueAutoamount, money.getAutoAmount());
        Assertions.assertEquals(TrueTotalAmount, money.getAmount());
    }

    @Test
    @DisplayName("수익률 계산이 올바른지 테스트")
    public void calculateRateOfReturnTest(){
        //given 받는 돈이 20000원,그중 수익이 10000원이라고 하자
        Money money=new Money(20000,4);
        int profit=10000;
        //when:money에 있는 수익률 계산 메서드를 이용할때
        double ror=money.calculateRateOfReturn(profit);
        //then:10000/20000과 동일한지에 대한 검증을 함.
        Assertions.assertEquals(0.5,ror);
    }

    @Test
    @DisplayName("여러 등수가 제대로 환산되는지")
    public void getWinningAmountTest() {
        //given:등수별로 하나씩 다 주어진다고 가정했을대
        Money money = new Money(20000, 1);
        Map<LottoRank, Integer> status = new HashMap<>();
        //when: 모든 status에 put해준다
        status.put(LottoRank.THREE, 1);
        status.put(LottoRank.FOUR, 1);
        status.put(LottoRank.FIVE, 1);
        status.put(LottoRank.SIX, 1);
        //then: 결과 값과 내가 예측한 값이 동일해야한다.
        int result = money.getWinningAmount(status);
        int expect = LottoRank.THREE.getWinningMoney() * 1 +
                LottoRank.FOUR.getWinningMoney() * 1 +
                LottoRank.FIVE.getWinningMoney() * 1 +
                LottoRank.SIX.getWinningMoney() * 1;

        Assertions.assertEquals(result,expect);
    }

}
