import java.time.LocalDate;

public class SwimResult {
    private Discipline discipline;
    private double timeInSecounds;
    private LocalDate date;
    private boolean isCompetition;
    private String competitionName;
    private int placement;

    // Konstruktør til træning
    public SwimResult(Discipline discipline, double timeInSecounds, LocalDate date, boolean isCompetition, String competitionName, int placement) {
        this.discipline = discipline;
        this.timeInSecounds = timeInSecounds;
        this.date = date;
        this.isCompetition = false;
    }

    //Konstruktør til stævne
    public SwimResult(Discipline discipline, double timeInSecounds, LocalDate date, String competitionName, int placement) {
        this.discipline = discipline;
        this.timeInSecounds = timeInSecounds;
        this.date = date;
        this.isCompetition = true;
        this.competitionName = competitionName;
        this.placement = placement;
    }

    //Getters


    public Discipline getDiscipline() {return discipline;}
    public double getTimeInSecounds() {return timeInSecounds;}
    public boolean isCompetition() {return isCompetition;}
}
