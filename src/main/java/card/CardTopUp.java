package card;

//накопичувальна
public class CardTopUp extends CardNumberOfTrips {
    public CardTopUp(int n) {
        //накопичувальна тільки звичайна
        super(TypeOfCard.ORDINARY, n);
    }

    public void topUp(int n) {
        if (n <= 0) {
            throw new RuntimeException("number of top up trips must be > 0");
        }
        this.numberOfTrips += n;
    }
}
