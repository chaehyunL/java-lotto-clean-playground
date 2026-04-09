import model.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestLottoTicket {

    @Test
    @DisplayName("복권이 오름차순으로 정렬되어있는가")
    public void getNumberUp() {
        //Given:로또 티켓 생성
        LottoTicket lottoTicket = new LottoTicket(List.of(6, 5, 4, 3, 2, 1));
        //When:로또 티켓 숫자 부여
        List<Integer> result = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> number = lottoTicket.getLottoNumbers();
        //Then:오름차순으로 정렬되어 있음.
        for (int i = 0; i < 5; i++) {
            assertThat(number.get(i)).isLessThan(number.get(i + 1));
        }
    }
}
