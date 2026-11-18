import java.util.ArrayList;

public class Team {
    private String teamName; //f.eks. "Juniorholdet" eller "Seniorholdet"
    private String coachName;
    private ArrayList<CompetitionSwimmer> swimmers = new ArrayList<>();

    public Team(String teamName, String coachName) {
        this.teamName = teamName;
        this.coachName = coachName;
    }

    public void addSwimmer(CompetitionSwimmer swimmer) {swimmers.add(swimmer);}

}
