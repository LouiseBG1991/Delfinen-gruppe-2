import java.time.LocalDate;

public class CompetitionResult {
    private Member member;
    private Discipline discipline;
    private double finishTime; //Omdøbt fra timeInSeconds
    private LocalDate date;
    private String competitionName;
    private int placement;
    private String place;


    public CompetitionResult(Member member, Discipline discipline, double finishTime, LocalDate date, String competitionName, int placement, String place) {
        this.member = member;
        this.discipline = discipline;
        this.finishTime = finishTime;
        this.date = date;
        this.competitionName = competitionName;
        this.placement = placement;
        this.place = place;
    }

    //Getters
    public Member getMember() {return  member;}
    public Discipline getDiscipline() {return discipline;}
    public double getFinishTime() {return finishTime;}
    public LocalDate getDate() {return date;}
    public String getCompetitionName() {return competitionName;}
    public int getPlacement() {return placement;}
    public String getPlace() {return place;}


    @Override
    public String toString() {
            return String.format("""
                    Navn: %s
                    Medlemsnummer: %s
                    Disciplin: %s
                    Tid: %.2f sek.
                    Dato: %s
                    Stævne: %s 
                    Placering: %d
                    Sted: %s""",
                    member.getName(), member.getMemberId(), discipline, finishTime, date, competitionName, placement, place);
    }
}