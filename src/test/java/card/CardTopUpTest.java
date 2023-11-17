package card;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTopUpTest {
    @Test
    public void onlyOrdinaryType() {
        CardTopUp card = new CardTopUp(5);
        assertEquals(card.getType(), TypeOfCard.ORDINARY);
    }

    @Test
    public void topUpCorrect() {
        int n1 = 1;
        int n2 = 5;
        CardTopUp card;
        try {
            card = new CardTopUp(n1);
            card.topUp(n2);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        assertEquals(card.getNumberOfTrips(), n1+n2);
    }

    @Test
    public void topUpError() {
        String exceptionMessage = "number of top up trips must be > 0";
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                {
                    int n1 = 7;
                    int n2 = -1;
                    CardTopUp card;
                    card = new CardTopUp(n1);
                    card.topUp(n2);
                }
        );
        assertEquals(exceptionMessage, exception.getMessage());
    }

}