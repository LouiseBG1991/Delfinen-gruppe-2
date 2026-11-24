import java.time.LocalDate;
import java.util.ArrayList;
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

    // Metoder fra TrainerAdministration

    public void addMember(Member member) {
        doesMemberIdAlreadyExist(member.getMemberId());
        members.add(member);

        MemberFee memberfee = new MemberFee(member);
        administration.addMemberFee(memberfee);

        team.addMemberToTeam(member);
    }

    //Getters

    public List<Member> getMembers() {return members;}

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
}