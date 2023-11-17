package card;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    public void differentId() {
        Card card = new CardNumberOfTrips(TypeOfCard.ORDINARY, 5);
        Card card2 = new CardNumberOfTrips(TypeOfCard.ORDINARY, 5);

        assertNotEquals(card.getID(),card2.getID());
    }


    @Test
    public void getTypeValid() {
        Card card = new CardNumberOfTrips(TypeOfCard.STUDENT, 5);
        Card card2 = new CardPeriod(TypeOfCard.PUPIL, LocalDate.of(2023, 12, 7));
        Card card3 = new CardTopUp(5);

        assertEquals(TypeOfCard.STUDENT, card.getType());
        assertEquals(TypeOfCard.PUPIL, card2.getType());
        assertEquals(TypeOfCard.ORDINARY, card3.getType());
    }

}