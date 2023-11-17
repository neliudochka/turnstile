package card;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CardPeriodTest {

    @Test
    public void setExpDate_Correct() {
        try {
             CardPeriod card = new CardPeriod(TypeOfCard.PUPIL,
             LocalDate.of(
                     LocalDate.now().getYear(),
                     LocalDate.now().getMonth(),
                     LocalDate.now().getDayOfMonth()
             ));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void setExpDate_Invalid() {
        String exceptionMessage = "invalid expiration date";
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                new CardPeriod(TypeOfCard.PUPIL,
                        LocalDate.of(
                                LocalDate.now().getYear()-1,
                                LocalDate.now().getMonth(),
                                LocalDate.now().getDayOfMonth()
                        )));
        assertEquals(exceptionMessage, exception.getMessage());
    }

}