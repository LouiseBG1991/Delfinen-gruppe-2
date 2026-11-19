import java.time.LocalDate;

public class CompetitionResult {
    int memberId;
    String place;
    String convention;
    LocalDate time;
    LocalDate finishTime;
    int placement;
    String discipline;

    public CompetitionResult(int memberId,String place, String convention, LocalDate time, LocalDate finishTime, int placement, String discipline){
        this.memberId = memberId;
        this.place = place;
        this.convention = convention;
        this.time = time;
        this.finishTime = finishTime;
        this.placement = placement;
        this.discipline = discipline;
    }

    public CompetitionResult addCompetitionResult(int memberId,String place, String convention, LocalDate time, LocalDate finishTime, int placement, String discipline){
        CompetitionResult competitionResult = new CompetitionResult(memberId, place, convention, time, finishTime, placement, discipline);
        return competitionResult;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getPlace() {
        return place;
    }
    public String getConvention() {
        return convention;
    }
    public LocalDate getTime() {
        return time;
    }
    public LocalDate getFinishTime() {
    return finishTime;
    }

    public int getPlacement() {
        return placement;
    }
    public String getDiscipline() {
        return discipline;
    }
}
