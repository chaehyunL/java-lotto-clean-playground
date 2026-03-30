import model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMoney {
    @Test
    @DisplayName("금액->갯수 치환이 제대로 되는지")
    public void moneyToquantity() {
        //given:14000원입력시
        Money money = new Money(14000);
        //then:14개를 반환하게 된
        assertEquals(money.getAmount(), 14);
    }

    @Test
    @DisplayName("올바른 수익 반환")
    public void testprofit() {
        //given:돈과 status 객체 생성
        Money money = new Money(14000);
        Map<Integer, Integer> status = new HashMap<>();
        //when:3개 일치부터 6개일치까지 하나씩 밖에 없을때
        status.put(3, 1);
        status.put(4, 1);
        status.put(5, 1);
        status.put(6, 1);
        int profit = (money.getProfit(status));
        //then:가격은 합해서 2001555000
        assertEquals(2001555000,profit);
    }
}
