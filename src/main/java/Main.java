import card.CardPeriod;
import card.CardTopUp;
import card.TypeOfCard;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CardSystem cardSystem = new CardSystem();
        Turnstile turnstile = new Turnstile(cardSystem);
        CardPeriod c = cardSystem.issueCardPeriod(TypeOfCard.PUPIL,
                LocalDate.of(
                        LocalDate.now().getYear()+1,
                        LocalDate.now().getMonth(),
                        LocalDate.now().getDayOfMonth()
                ));
        //c.useACard();
        CardTopUp c2 = cardSystem.issueCardTopUp(3);
        System.out.println(c);
        System.out.println(c2);
        turnstile.pass(c2);

        turnstile.pass(c);
        turnstile.pass(c2);
        turnstile.pass(c2);
        turnstile.pass(c2);

        turnstile.pass(c);
        turnstile.pass(c2);
        turnstile.pass(c);

        turnstile.pass(c);

        System.out.println(turnstile.getRecords());
        System.out.println(turnstile.getRecords(TypeOfCard.ORDINARY));

        System.out.println(turnstile.getRecordsSorted());

    }
}


