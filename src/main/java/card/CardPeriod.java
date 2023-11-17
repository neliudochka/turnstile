package card;

import java.time.LocalDate;

public class CardPeriod extends Card {
    private final LocalDate expirationDate;
    public CardPeriod(TypeOfCard typeOfCard, LocalDate expDate) {
        super(typeOfCard);
        if (expDate.isBefore(LocalDate.now())){
            throw new RuntimeException("invalid expiration date");
        }
        expirationDate = expDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public boolean useACard() {
        LocalDate currentDate = LocalDate.now();
        return !currentDate.isAfter(expirationDate);
    }

    @Override
    public String toString() {
        String base = super.toString();
        return base +
                "expirationDate = " + getExpirationDate() + ";\n";
    }
}
