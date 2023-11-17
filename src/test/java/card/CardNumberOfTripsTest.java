package card;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardNumberOfTripsTest {
    @Test
    public void constructorCorrectData() {
        try {
            CardNumberOfTrips card = new CardNumberOfTrips(TypeOfCard.PUPIL,
                    5);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void constructorWrongData() {
        String exceptionMessage = "number of trips must be >= min number of trips " + 1;
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                new CardNumberOfTrips(TypeOfCard.PUPIL,0)
        );
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void useACard() {
        int n = 5;
        CardNumberOfTrips card;

            card = new CardNumberOfTrips(TypeOfCard.PUPIL,n);
            boolean res = card.useACard();
         assertTrue(res);
        assertEquals(card.getNumberOfTrips(), n-1);
    }

    @Test
    public void useACardNoTrip() {
        int n = 1;
        CardNumberOfTrips card = new CardNumberOfTrips(TypeOfCard.PUPIL,n);
        card.useACard();
        boolean res = card.useACard();
        assertFalse(res);
        assertEquals(card.getNumberOfTrips(), 0);
    }
}