import java.util.ArrayList;
import java.util.List;

public class Club {

    private List<Member> members = new ArrayList<>();

    private Team juniorTeam = new Team("Juniorholdet", "Anders");
    private Team seniorTeam = new Team("Seniorholdet", "Mette");

    public void addMember(Member member) {
        doesMemberIdAlreadyExist(member.getMemberId());
        members.add(member);
    }

    public void addCompetitionSwimmer(CompetitionSwimmer swimmer) {
        members.add(swimmer);
        if (swimmer.isJunior()) {
            juniorTeam.addSwimmer(swimmer);
        } else {
            seniorTeam.addSwimmer(swimmer);
        }
    }

    public List<Member> getMembers() {
        return members;
    }

    public Team getJuniorTeam() {
        return juniorTeam;
    }

    public Team getSeniorTeam() {
        return seniorTeam;
    }

    public Member findMemberByMemberId (int memberId) {
        for (Member member : members) {
            if (memberId == member.getMemberId()) {
                return member;
            }
        }
        return null;
    }

    public void printMembers() {
        for (Member member : members) {
            IO.println(member);
        }
    }

    public void doesMemberIdAlreadyExist(int memberId) {
        if(findMemberByMemberId(memberId) != null) {
            throw new IllegalArgumentException();
        }
    }

}


