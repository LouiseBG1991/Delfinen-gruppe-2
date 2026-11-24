import java.time.LocalDate;

public class TrainingResult {

    private Member member;
    private Discipline discipline;
    private double finishTime;
    private LocalDate date;


public TrainingResult (Member member, Discipline discipline, double finishTime, LocalDate date) {
    this.member = member;
    this.discipline = discipline;
    this.finishTime = finishTime;
    this.date = date;
}

public Member getMember() {
    return member;
}

public Discipline getDiscipline() {
    return discipline;
}

public double getFinishTime() {
    return finishTime;
}

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("""
                    Navn: %s
                    Medlemsnummer: %s
                    Disciplin: %s
                    Tid: %.2f sek.
                    Dato: %s""",
               member.getName(), member.getMemberId(), discipline,finishTime, date);
    }
}
