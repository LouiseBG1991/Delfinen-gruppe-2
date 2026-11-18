import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompetitionSwimmer extends Member{
    List<CompetitionResult> competitionResults = new ArrayList<>();

    public CompetitionSwimmer(int memberId, String name, String address, String phoneNumber, String email, LocalDate birthday) {
        super(memberId, name, address, phoneNumber, email, birthday, new MemberShip());
    }

    public void addCompetitionResult (CompetitionResult competitionResult){
        competitionResults.add(competitionResult);
    }

}
