import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CompetitionSwimmerTest {
    CompetitionSwimmer competitionSwimmer;

    @BeforeEach
    void setup (){
        LocalDate birthday = LocalDate.of(2004,11,7);
        CompetitionSwimmer competitionSwimmer = new CompetitionSwimmer(111, "Anders", "Hørkær 7F","51931177", "andersgraa@gmail.com", birthday);
        CompetitionResult competitionResult = new CompetitionResult(111, "Ek", "EK's Svømme", birthday, 1.11,3,"Crawl");
    }

    @Test
    void addCompetitionResultTest(){
        setup();
        competitionSwimmer.addCompetitionResult(competitionResult);
    }
}
