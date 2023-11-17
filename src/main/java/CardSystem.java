import card.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CardSystem {
    // реєстр карток
    private static final List<Card> issuedCards = new ArrayList<Card>();
    public CardPeriod issueCardPeriod(TypeOfCard typeOfCard, LocalDate expDate) {
        CardPeriod card;
        try {
            card = new CardPeriod(typeOfCard, expDate);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        issuedCards.add(card);
        return card;
    }

    public CardNumberOfTrips issueCardNumberOfTrips(TypeOfCard typeOfCard, int n) {
        CardNumberOfTrips card;
        try {
            card = new CardNumberOfTrips(typeOfCard, n);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        issuedCards.add(card);
        return card;
    }

    public CardTopUp issueCardTopUp(int n) {
        CardTopUp card;
        try {
            card = new CardTopUp(n);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        issuedCards.add(card);
        return card;
    }

    public boolean isIssuedHere(Card card) {
        return issuedCards.contains(card);
    }
}