package card;

import java.time.LocalDate;
import java.util.UUID;


public abstract class Card {
    private final UUID identifier;
    private final TypeOfCard type;

    public Card(TypeOfCard typeOfCard) {
        identifier = UUID.randomUUID();
        type = typeOfCard;
    }

    public UUID getID() {
        return identifier;
    }
    
    public TypeOfCard getType() {
        return type;
    }

    abstract public boolean useACard();

    @Override
    public String toString() {
        return "!!Card!! " + "\n" +
                "identifier = " + identifier + ";\n" +
                "type = " + type + ";\n" ;
    }
}
