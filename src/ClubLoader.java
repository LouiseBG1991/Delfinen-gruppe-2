import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ClubLoader {
    private CsvMapper csvMapper = new CsvMapper();

    public List<Member> loadMembers(Path path) throws IOException {
        List<Member> members = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)){
            String line;
            while ((line = reader.readLine()) != null) {
                Member member = csvMapper.memberFromCsv(line);
                members.add(member);
            }
        }
        return members;
    }

    public List<CompetitionSwimmer> loadCompetitionSwimmers(Path path) throws IOException {
        List<CompetitionSwimmer> competitionSwimmers = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)){
            String line;
            while ((line = reader.readLine()) !=null) {
                CompetitionSwimmer competitionSwimmer = csvMapper.competitionSwimmerFromCsv(line);
                competitionSwimmers.add(competitionSwimmer);
            }
        }
        return competitionSwimmers;
    }

    public List<CompetitionResult> loadCompetitionResults(Path path) throws  IOException {
        List<CompetitionResult> competitionResults = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                CompetitionResult competitionResult = csvMapper.competitionResultFromCsv(line);
                competitionResults.add(competitionResult);
            }
        }
        return competitionResults;
    }

    public List<Team> loadTeams(Path path) throws IOException {
        List<Team> teams = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)){
            String line;
            while ((line = reader.readLine()) != null) {
                Team team = csvMapper.teamFromCsv(line);
                teams.add(team);
            }
        }
        return teams;
    }

    public List<SwimResult> loadSwimResultPractices(Path path) throws IOException {
        List<SwimResult> swimResultsPractice = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)){
            String line;
            while ((line = reader.readLine()) != null) {
                SwimResult swimResult = csvMapper.swimResultPracticeFromCsv(line);
                swimResultsPractice.add(swimResult);
            }
        }
        return swimResultsPractice;
    }

    public List<SwimResult> loadSwimResultCompetition(Path path) throws IOException {
        List<SwimResult> swimResultsCompetition = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)){
            String line;
            while ((line = reader.readLine()) != null) {
                SwimResult swimResult = csvMapper.swimResultCompetitionFromCsv(line);
                swimResultsCompetition.add(swimResult);
            }
        }
        return swimResultsCompetition;
    }

    public List<MemberShip> memberShips(Path path) throws IOException {
        List<MemberShip> memberShips = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                MemberShip memberShip = csvMapper.memberShipFromCsv(line);
                memberShips.add(memberShip);
            }
        }
        return memberShips;
    }
}

