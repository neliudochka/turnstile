import card.CardTopUp;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardSystemTest {
    @Test
    public void cardIsIssuedHere() {
        CardSystem cardSys = new CardSystem();
        CardTopUp card;
        try {
            card = cardSys.issueCardTopUp(5);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        assertTrue(cardSys.isIssuedHere(card));
    }

    @Test
    public void cardIsNotIssuedHere() {
        CardSystem cardSys = new CardSystem();
        CardTopUp card;
        try {
            card = new CardTopUp(5);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        assertFalse(cardSys.isIssuedHere(card));
    }

}