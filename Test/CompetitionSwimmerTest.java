import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CompetitionSwimmerTest {
    CompetitionSwimmer competitionSwimmer;

    @BeforeEach
    void setup (){
        CompetitionSwimmer competitionSwimmer = new CompetitionSwimmer(111, "Anders", "Hørkær 7F","51931177", "andersgraa@gmail.com", LocalDate.of(2004, 11, 7));
        CompetitionResult competitionResult = new CompetitionResult(111, "Ek", "EK's Svømme", LocalDate.of(2026, 11, 13), LocalDate.of(2026, 11, 14),3,"Crawl");
    }

//    @Test
//    void addCompetitionResultTest(){
//        competitionSwimmer.addCompetitionResult(competitionResult);
//    }
}
