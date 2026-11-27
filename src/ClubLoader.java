import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ClubLoader {
    private CsvMapper csvMapper;

    public ClubLoader(CsvMapper csvMapper) {
        this.csvMapper = csvMapper;
    }

    public List<Member> loadMembers(String filename) throws IOException {
        List<Member> members = new ArrayList<>();
        Path path = Path.of(filename);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                Member member = csvMapper.memberFromCsv(line);
                members.add(member);
            }
        }
        return members; //færdig
    }


    public List<CompetitionResult> loadCompetitionResults(String filename) throws IOException {
        List<CompetitionResult> competitionResults = new ArrayList<>();
        Path path = Path.of(filename);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                CompetitionResult competitionResult = csvMapper.competitionResultFromCsv(line);
                competitionResults.add(competitionResult);
            }
        }
        return competitionResults; // færdig
    }


    public List<TrainingResult> loadTrainingResults(String filename) throws IOException {
        List<TrainingResult> trainingResults = new ArrayList<>();
        Path path = Path.of(filename);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                TrainingResult trainingResult = csvMapper.trainingResultsFromCsv(line);
                trainingResults.add(trainingResult);
            }
        }
        return trainingResults; // færdig
    }


    public List<MemberShip> loadMemberShips(String filename) throws IOException {
        List<MemberShip> memberShips = new ArrayList<>();
        Path path = Path.of(filename);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                MemberShip memberShip = csvMapper.memberShipFromCsv(line);
                memberShips.add(memberShip);
            }
        }
        return memberShips; // færdig
    }


}
