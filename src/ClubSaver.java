import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ClubSaver {
    private String delimiter = ",";
    private CsvMapper csvMapper;

    public ClubSaver(CsvMapper csvMapper) {
        this.csvMapper = csvMapper;
    }

    public void saveMembers(List<Member> members, String filename) throws IOException { // færdig
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Member member : members) {
                writer.write(csvMapper.memberToCsv(member));
                writer.newLine();
            }
        }
    }

    public void saveTrainingResults(List<TrainingResult> trainingResults, String filename) throws IOException { // færdig
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (TrainingResult trainingResult : trainingResults) {
                writer.write(csvMapper.trainingResultsToCsv(trainingResult));
                writer.newLine();
            }
        }
    }

    public void saveCompetitionResults(List<CompetitionResult> competitionResults, String filename) throws IOException { //færdig
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (CompetitionResult competitionResult : competitionResults) {
                writer.write(csvMapper.competitionResultsToCsv(competitionResult));
                writer.newLine();
            }
        }
    }

    public void saveMemberships(List<MemberShip> memberShips, String filename) throws IOException { //færdig
        Path path = Path.of(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (MemberShip memberShip : memberShips) {
                writer.write(csvMapper.memberShipToCsv(memberShip));
                writer.newLine();
            }
        }
    }

}
