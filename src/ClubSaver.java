import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ClubSaver {
    private String delimiter = ",";
    CsvMapper csvMapper = new CsvMapper();

    public void saveMembers(List<Member> members, String filename) throws IOException {
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Member member : members) {
                writer.write(csvMapper.memberToCsv(member));
                writer.newLine();
            }
        }
    }

        public void saveCompetitionSwimmers(List<CompetitionSwimmer> competitionSwimmers, String filename) throws IOException {
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (CompetitionSwimmer competitionSwimmer : competitionSwimmers) {
                writer.write(csvMapper.competitionSwimmerToCsv(competitionSwimmer));
                writer.newLine();
            }
        }
    }

    public void saveCompetitionResults(List<CompetitionResult> competitionResults, String filename) throws IOException {
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)){
            for (CompetitionResult competitionResult : competitionResults) {
                writer.write(csvMapper.competitionResultsToCsv(competitionResult));
                writer.newLine();
            }
        }
    }

    public void saveTeams(List<Team> teams, String filename) throws IOException{
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Team team : teams) {
                writer.write(csvMapper.teamToCsv(team));
                writer.newLine();
            }
        }
    }


    public void saveSwimResultsPractice(List<SwimResult> swimResults, String filename) throws IOException {
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (SwimResult swimResult : swimResults) {
                writer.write(csvMapper.swimResultPracticeToCsv(swimResult));
                writer.newLine();
            }
        }
    }
    public void saveSwimResultsCompetition(List<SwimResult> swimResults, String filename) throws IOException {
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (SwimResult swimResult : swimResults) {
                writer.write(csvMapper.swimResultCompetitionToCsv(swimResult));
                writer.newLine();
            }
        }
    }

    public void saveMemberships(List<MemberShip> memberShips, String filename) throws  IOException {
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)){
            for (MemberShip memberShip : memberShips) {
                writer.write(csvMapper.memberShipToCsv(memberShip));
                writer.newLine();
            }
        }
    }

}
