package card;

public class CardNumberOfTrips extends Card {
    protected int numberOfTrips;

    public CardNumberOfTrips(TypeOfCard typeOfCard, int n) {
        super(typeOfCard);
        int minN = 1;
        if(n < minN) {
            throw new RuntimeException("number of trips must be >= min number of trips " + minN);
        }
        numberOfTrips = n;
    }

    public int getNumberOfTrips() {
        return numberOfTrips;
    }


    @Override
    public boolean useACard() {
        if (numberOfTrips <= 0) {
            return false;
        }
        numberOfTrips--;
        return true;
    }

    @Override
    public String toString() {
        String base = super.toString();
        return base +
                "numberOfTrips = " + numberOfTrips + ";\n";
    }
}
