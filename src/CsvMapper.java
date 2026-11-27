import java.time.LocalDate;

public class CsvMapper {
    private final String delimiter = ",";
    public Club club;

    public CsvMapper (Club club) {
        this.club = club;
    }

    // Members

    public Member memberFromCsv(String line) {
        String[] tokens = line.split(delimiter, -1);
        int memberID = Integer.parseInt(tokens[0]);
        LocalDate birthday = LocalDate.parse(tokens[5]);
        MemberShip memberShip = memberShipFromCsv(tokens[6] + delimiter + tokens[7]);
        return new Member(memberID, tokens[1], tokens[2], tokens[3], tokens[4], birthday, memberShip); // færdig
    }

    public String memberToCsv(Member member) {
        return member.getMemberId() + delimiter
                + member.getName() + delimiter
                + member.getAddress() + delimiter
                + member.getPhoneNumber() + delimiter
                + member.getEmail() + delimiter
                + member.getBirthday() + delimiter
                + member.getMembership().getStatus() + delimiter
                + member.getMembership().getSwimmerType() + delimiter; // færdig
    }


     // CompetitionResults

    public CompetitionResult competitionResultFromCsv(String line) {
        String[] tokens = line.split(delimiter, -1);
        int memberId = Integer.parseInt(tokens[0]);
        Member member = club.findMemberByMemberId(memberId);
        Discipline discipline = Discipline.valueOf(tokens[1]);
        double finishTime = Double.parseDouble(tokens[2]);
        LocalDate date = LocalDate.parse(tokens[3]);
        String competitionName = tokens[4];
        int placement = Integer.parseInt(tokens[5]);
        String place = tokens[6];
        return new CompetitionResult(member, discipline, finishTime, date, competitionName, placement, place); // færdig
    }

    public String competitionResultsToCsv(CompetitionResult competitionResult) {
        return competitionResult.getMember().getMemberId() + delimiter
                + competitionResult.getDiscipline() + delimiter
                + competitionResult.getFinishTime() + delimiter
                + competitionResult.getDate() + delimiter
                + competitionResult.getCompetitionName() + delimiter
                + competitionResult.getPlacement() + delimiter
                + competitionResult.getPlace() + delimiter; // færdig

    }

    // TrainingResults

    public TrainingResult trainingResultsFromCsv(String line) {
        String[] tokens = line.split(delimiter, -1);
        int memberId = Integer.parseInt(tokens[0]);
        Member member = club.findMemberByMemberId(memberId);
        Discipline discipline = Discipline.valueOf(tokens[1]);
        double finishTime = Double.parseDouble(tokens[2]);
        LocalDate date = LocalDate.parse(tokens[3]);
        return new TrainingResult(member, discipline, finishTime, date); // færdig
    }
    public String trainingResultsToCsv(TrainingResult trainingResult) {
        return trainingResult.getMember().getMemberId() + delimiter
                + trainingResult.getDiscipline() + delimiter
                + trainingResult.getFinishTime() + delimiter
                + trainingResult.getDate() + delimiter; // færdig
    }


    // Memberships

    public MemberShip memberShipFromCsv(String line) {
        String[] tokens = line.split(delimiter, -1);
        MemberShipStatus status = MemberShipStatus.valueOf(tokens[0]);
        SwimmerType swimmerType = SwimmerType.valueOf(tokens[1]);
        MemberShip memberShip = new MemberShip();

        if (status == MemberShipStatus.ACTIVE) {
            memberShip.setActive(swimmerType);
        } else if (status == MemberShipStatus.PASSIVE) {
            memberShip.setPassive();
        }

        return memberShip; // færdig
    }

    public String memberShipToCsv(MemberShip memberShip) {
        return memberShip.getStatus() + delimiter + memberShip.getSwimmerType(); // færdig
    }


}
