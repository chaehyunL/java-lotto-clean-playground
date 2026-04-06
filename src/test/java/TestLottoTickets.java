import model.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLottoTickets {
    @Test
    @DisplayName("개수가 일치하게 로또 생성이 되는가")
    public void getSamequantity() {
        int quantity=3;
        LottoTickets lottoTickets = new LottoTickets(quantity);
        lottoTickets.buyTickets();

        assertEquals(lottoTickets.getTickets().size(),3);
    }
}
