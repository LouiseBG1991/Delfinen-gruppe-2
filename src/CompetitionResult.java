import java.time.LocalDate;

public class CompetitionResult {
    int memberId;
    String place;
    String convention;
    LocalDate time;
    LocalDate finishTime;
    int placement;

    public CompetitionResult(int memberId,String place, String convention, LocalDate time, LocalDate finishTime, int placement){
        this.memberId = memberId;
        this.place = place;
        this.convention = convention;
        this.time = time;
        this.finishTime = finishTime;
        this.placement = placement;
    }

    public CompetitionResult addCompetitionResult(int memberId,String place, String convention, LocalDate time, LocalDate finishTime, int placement){
        CompetitionResult competitionResult = new CompetitionResult(memberId, place, convention, time, finishTime, placement);
        return competitionResult;
    }
}
