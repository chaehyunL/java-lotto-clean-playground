import model.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLottoTicket {
    @Test
    @DisplayName("6개의 숫자가 출력되는가")
    public void get6numbers() {
        //Given: 로또 티켓 한개 생성
        LottoTicket lottoTicket = new LottoTicket();
        //When:로또 한개를 만들고 숫자를 부여
        lottoTicket.makeLottoTicket();
        List<Integer> ticket = lottoTicket.getLottoNumbers();
        //Then:로또 1장당 6개의 숫자를 가짐
        assertEquals(ticket.size(), 6);
    }

    @Test
    @DisplayName("복권이 오름차순으로 정렬되어있는가")
    public void getnumberup() {
        //Given:로또 티켓 생성
        LottoTicket lottoTicket = new LottoTicket();
        //When:로또 티켓 숫자 부여
        lottoTicket.makeLottoTicket();
        List<Integer> number = lottoTicket.getLottoNumbers();
        //Then:오름차순으로 정렬되어 있음.
        for (int i = 0; i < 5; i++) {
            assertThat(number.get(i)).isLessThan(number.get(i + 1));
        }
    }
}
