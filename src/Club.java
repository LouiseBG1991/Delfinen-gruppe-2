import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Club {
    private List<Member> members = new ArrayList<>();
    private Administration administration = new Administration();
    private Team team = new Team();
    private TrainerAdministration trainerAdministration = new TrainerAdministration(team);


    public double getExpectedAnnualRevenue() {
        return administration.expectedAnnualRevenue();
    }

    public List<Member> getMembersWithOutstandingPayment() {
        return administration.showMembersWithOutstandingPayment();
    }

    public boolean registerPayment(int memberId) {
        return administration.registerPayment(memberId);
    }

    public void addMember(Member member) {
        doesMemberIdAlreadyExist(member.getMemberId());
        members.add(member);

        MemberFee memberfee = new MemberFee(member);
        administration.addMemberFee(memberfee);

        team.addMemberToTeam(member);
    }


    public List<Member> getMembers() {
        return members;
    }

    public Member findMemberByMemberId(int memberId) {
        for (Member member : members) {
            if (memberId == member.getMemberId()) {
                return member;
            }
        }
        return null;
    }

    public void doesMemberIdAlreadyExist(int memberId) {
        if (findMemberByMemberId(memberId) != null) {
            throw new IllegalArgumentException();
        }
    }

    public int membersInTotal() {

        int membersInTotal = 0;
        for (Member member : members) {
            membersInTotal++;
        }
        return membersInTotal;
    }

    public MemberShip getCurrentMemberShip(int memberId) {
        Member member = findMemberByMemberId(memberId);
        if (member != null) {
            return member.getCurrentMemberShip();
        } else {
            return null;
        }
    }

    // fields
    private List<TrainingResult> trainingResults = new ArrayList<>();
    private List<CompetitionResult> competitionResults = new ArrayList<>();

    public void addTrainingResult(TrainingResult result) {
        trainingResults.add(result);
    }

    public void addCompetitionResult(CompetitionResult result) {
        competitionResults.add(result);
    }

    public List<TrainingResult> getTrainingResults() {
        return trainingResults;
    }

    public List<CompetitionResult> getCompetitionResults() {
        return competitionResults;
    }

    public List<TrainingResult> getTop5(Discipline discipline) {
        return trainingResults.stream()
                .filter(r -> r.getDiscipline() == discipline)
                .sorted(Comparator.comparingDouble(TrainingResult::getFinishTime))
                .limit(5)
                .toList();
    }

}