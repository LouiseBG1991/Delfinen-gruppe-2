import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class CsvMapper {
    private String delimiter = ",";

    public Member memberFromCsv(String line) {
        String[] tokens = line.split(delimiter, -1);
        int memberID = Integer.parseInt(tokens[0]);
        LocalDate birthday = LocalDate.parse(tokens[5]);
        MemberShip memberShip = new MemberShip(SwimmerType.valueOf(tokens[6]));
        return new Member(memberID, tokens[1], tokens[2], tokens[3], tokens[4], birthday, memberShip);
    }

    public String memberToCsv(Member member) {
        return member.getMemberId() + delimiter
                + member.getName() + delimiter
                + member.getAddress() + delimiter
                + member.getPhoneNumber() + delimiter
                + member.getEmail() + delimiter
                + member.getBirthday() + delimiter
                + member.getMembership().getSwimmerType() + delimiter;
    }

    public CompetitionSwimmer competitionSwimmerFromCsv(String line) {
        String[] tokens = line.split(delimiter, -1);
        int memberID = Integer.parseInt(tokens[0]);
        LocalDate birthday = LocalDate.parse(tokens[5]);
        return new CompetitionSwimmer(memberID, tokens[1], tokens[2], tokens[3], tokens[4], birthday);
    }

    public String competitionSwimmerToCsv(CompetitionSwimmer competitionSwimmer) {
        return competitionSwimmer.getMemberId() + delimiter
                + competitionSwimmer.getName() + delimiter
                + competitionSwimmer.getAddress() + delimiter
                + competitionSwimmer.getPhoneNumber() + delimiter
                + competitionSwimmer.getBirthday() + delimiter
                + competitionSwimmer.getMembership() + delimiter;
    }

    public CompetitionResult competitionResultFromCsv(String line) {
        String[] tokens = line.split(delimiter, -1);
        int memberID = Integer.parseInt(tokens[0]);
        LocalDate time = LocalDate.parse(tokens[3]);
        LocalDate finishtime = LocalDate.parse(tokens[4]);
        int placement = Integer.parseInt(tokens[5]);
        return new CompetitionResult(memberID, tokens[1], tokens[2], time, finishtime, placement, tokens[6]);
    }

    public String competitionResultsToCsv(CompetitionResult competitionResult) {
        return competitionResult.getMemberId() + delimiter
                + competitionResult.getPlace() + delimiter
                + competitionResult.getConvention() + delimiter
                + competitionResult.getTime() + delimiter
                + competitionResult.getFinishTime() + delimiter
                + competitionResult.getPlacement() + delimiter
                + competitionResult.getDiscipline() + delimiter;
    }

    public Team teamFromCsv(String line) {
        String[] tokens = line.split(delimiter, -1);
        return new Team(tokens[0], tokens[1]);
    }

    public String teamToCsv(Team team) {
        return team.getTeamName() + delimiter
                + team.getCoachName() + delimiter;
    }

    public SwimResult swimResultPracticeFromCsv(String line) {
        String[] tokens = line.split(delimiter, -1);
        double time = Double.parseDouble(tokens[1]);
        LocalDate date = LocalDate.parse(tokens[2]);
        return new SwimResult(Discipline.valueOf(tokens[0]), time, date);
    }
    public String swimResultPracticeToCsv(SwimResult swimResult) {
        return swimResult.getDiscipline() + delimiter
                + swimResult.getFinishTime() + delimiter
                + swimResult.getDate() + delimiter;
    }

    public SwimResult swimResultCompetitionFromCsv(String line) {
        String[] tokens = line.split(delimiter, -1);
        double time = Double.parseDouble(tokens[1]);
        LocalDate date = LocalDate.parse(tokens[2]);
        int placement = Integer.parseInt(tokens[4]);
        return new SwimResult(Discipline.valueOf(tokens[0]), time, date, tokens[3], placement);
    }

    public String swimResultCompetitionToCsv(SwimResult swimResult) {
        return swimResult.getDiscipline() + delimiter
                + swimResult.getFinishTime() + delimiter
                + swimResult.getDate() + delimiter
                + swimResult.getCompetitionName() + delimiter
                + swimResult.getPlacement() + delimiter;
    }

    public MemberShip memberShipFromCsv(String line) {
        String[] tokens = line.split(delimiter, -1);
        return new MemberShip(SwimmerType.valueOf(tokens[0]));
    }

    public String memberShipToCsv(MemberShip memberShip) {
        return memberShip.getSwimmerType().toString();
    }


}
