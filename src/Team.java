import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Håndterer fordelingen af medlemmer på hold
public class Team {

    private List<Member> juniors;
    private List<Member> seniors;

    public Team () {
        this.juniors = new ArrayList<>();
        this.seniors = new ArrayList<>();

    }

    public List<Member> getJuniors() {
        return juniors;
    }

    public List<Member> getSeniors() {
        return seniors;
    }

    public void addMemberToTeam(Member member) {
       if(!member.getMembership().isActive() || member.getMembership().getSwimmerType() != SwimmerType.COMPETITIVE) {
           return;
       }

       if(member.isJunior()) {
           juniors.add(member);
       } else {
           seniors.add(member);
       }

    }

    public String toString() {
        return String.format("""
                Juniorteam: %s
                Seniorteam: %s
                """, juniors, seniors);
    }
}