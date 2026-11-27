import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompetitionSwimmer extends Member{
    List<CompititionResult> swimResults = new ArrayList<>();
    private List<Discipline> activeDisciplines = new ArrayList<>();


    public CompetitionSwimmer(int memberId, String name, String address, String phoneNumber, String email, LocalDate birthday) {
        //Her sendes et aktivt konkurrencemedlemskab med op til Member
        super(memberId, name, address, phoneNumber, email, birthday, new MemberShip(SwimmerType.COMPETITIVE));
    }


    public void addSwimResults (CompititionResult swimResult){swimResults.add(swimResult);}
    public List<CompititionResult> getSwimResults() {return swimResults;}

    //Metoden returnerer den hurtigste tidsrekord i givent disciplin

    public CompititionResult getBestResult(Discipline discipline) {
        CompititionResult best = null;
        for (CompititionResult result : swimResults) {
            if (result.getDiscipline() == discipline) {
                if (best == null || result.getFinishTime() < best.getFinishTime()) {
                    best = result;
                }
            }
        }
        return best;
    }


    public void addDiscipline(Discipline discipline) {
        if (discipline != null && activeDisciplines.contains(discipline)) {
            activeDisciplines.add(discipline);
        }
    }

    public void removeDiscipline(Discipline discipline) {
        activeDisciplines.remove(discipline);
    }

    public List<Discipline> getActiveDisciplines() {
        return new ArrayList<>(activeDisciplines);
    }
}
