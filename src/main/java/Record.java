import card.TypeOfCard;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Record {
    public UUID id;
    public TypeOfCard type;

    public LocalDateTime date;
    public boolean passed;

    public Record(UUID id, TypeOfCard type, LocalDateTime date, boolean passed) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.passed = passed;

    }
    @Override
    public String toString() {
        return "Record: " + "\n" +
                " id= " + id + "\n" +
                " type= " + type + "\n" +
                " time= " + date + "\n" +
                " passed= " + passed + "\n";
    }
}
