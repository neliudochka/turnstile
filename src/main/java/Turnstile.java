import card.Card;
import card.TypeOfCard;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

class Turnstile {
    //назва таке
    private final CardSystem cardSystem;

    private final List<Record> records = new ArrayList<Record>();
    public Turnstile(CardSystem cardSystem) {
        this.cardSystem = cardSystem;
    }
    public boolean pass(Card card) {
        //Турнікет зчитує дані з картки та виконує її перевірку.
        // Якщо дані не вдалося зчитати, чи картка прострочена, чи на ній не залишилося кредитів для поїздок, то прохід заборонено.
        // Інакше з картки знімається одна і прохід дозволяється.

        if(!cardSystem.isIssuedHere(card)) {
            System.out.println("You can`t pass! Your card is not issued by our system");
            makeARecord(card, false);
            return false;
        }

        if(!card.useACard()) {
            System.out.println("You can`t pass! Card is expired!");
            makeARecord(card, false);
            return false;
        }

        System.out.println("Welcome!");
        makeARecord(card, true);
        return true;
    }

    private void makeARecord(Card card, boolean passed) {
        Record record = new Record(
                card.getID(),
                card.getType(),
                LocalDateTime.now(),
                passed
                );
        records.add(record);
    }

    public List<Record> getRecords() {
        return records;
    }


    public List<Record> getRecords(TypeOfCard type) {
        List<Record> typedRecords = new ArrayList<Record>();
        for (Record r : records) {
         if(r.type == type) {
             typedRecords.add(r);
         }
        }
        return typedRecords;
    }

    public List<Record> getRecordsSorted() {
        List<Record> sortedRecords = new ArrayList<Record>();
        for (TypeOfCard t: TypeOfCard.values()) {
            sortedRecords.addAll(getRecords(t));
        }

        return sortedRecords;
    }

}
