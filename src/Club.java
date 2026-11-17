import java.util.ArrayList;
import java.util.List;

public class Club {

    private List<Member> members = new ArrayList<>();


    public void addMember(Member member) {
        members.add(member);
    }

    public List<Member> getMembers() {
        return members;
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
}


