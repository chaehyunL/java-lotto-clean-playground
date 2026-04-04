import model.LottoTicket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestLottoTicket {
    @Test
    @DisplayName("복권이 오름차순으로 정렬되어있는가")
    public void getnumberup() {
        //given: 역순의 숫자 6개가 주어짐
        List<Integer> number = List.of(6, 5, 4, 3, 2, 1);
        //when:lottoticket을 생성할때
        LottoTicket lottoTicket = new LottoTicket(number);
        List<Integer> result = List.of(1, 2, 3, 4, 5, 6);
        //then:오름차순으로 정렬해야한다.
        Assertions.assertEquals(lottoTicket.getLottoNumbers(), result);
    }

    @Test
    @DisplayName("일치하는 개수가 제대로 출력되는지")
    public void WinningNumberMatchingTest() {
        //given: 1,2,3,4,5,6 숫자를 가진 로또 1장 생성
        List<Integer> number = List.of(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = new LottoTicket(number);
        //when:winingnumber가 1개 일치할때와 여러개 일치할때를 가정
        List<Integer> OneWinningNumber = List.of(1, 7, 8, 9, 10, 11);
        List<Integer> ThreeWinningNumber = List.of(1, 2, 3, 8, 9, 10);
        //then:1개와 여러개 동일한 것을 잡아낼 수 있는가.
        Assertions.assertEquals(1, lottoTicket.calculateMatch(OneWinningNumber));
        Assertions.assertEquals(3, lottoTicket.calculateMatch(ThreeWinningNumber));
    }

    @Test
    @DisplayName("보너스 볼 유무를 제대로 검출하는지")
    public void BonusBallTest() {
        //given: 1,2,3,4,5,6 숫자를 가진 로또 1장 생성
        List<Integer> number = List.of(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = new LottoTicket(number);
        //when:BonusBall이 1일때(로또에 존재) 8일때(로또에 존재하지 않음.)
        int TrueBonusBall = 1;
        int FalseBonusBall = 8;
        //Then:각각 존재할때 존재하지 않을때를 비교함
        Assertions.assertTrue(lottoTicket.hasBonusBall(TrueBonusBall));
        Assertions.assertFalse(lottoTicket.hasBonusBall(FalseBonusBall));
    }
}
