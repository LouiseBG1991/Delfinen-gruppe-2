import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class CompetitionSwimmerTest {
    CompetitionSwimmer competitionSwimmer;
    SwimResult swimResult;

    @BeforeEach
    void setup(){
        //arrange
         competitionSwimmer = new CompetitionSwimmer(111, "Anders", "Hørkær 7F","51931177", "andersgraa@gmail.com", LocalDate.of(2004, 11, 7));
         swimResult = new SwimResult(Discipline.CRAWL,1.12,LocalDate.of(2026,11,10), "Ek's svøm", 13);
         SwimResult swimResult1 = new SwimResult(Discipline.CRAWL,1.14,LocalDate.of(2026,11,10), "Ek's svøm", 13);
         SwimResult swimResult2 = new SwimResult(Discipline.BACKSTROKE,1.15,LocalDate.of(2026,11,10), "Ek's svøm", 13);
         SwimResult swimResult3 = new SwimResult(Discipline.CRAWL,1.12,LocalDate.of(2026,11,10), "Ek's svøm", 13);
        competitionSwimmer.addSwimResults(swimResult);
        competitionSwimmer.addSwimResults(swimResult2);
        competitionSwimmer.addSwimResults(swimResult1);
        competitionSwimmer.addSwimResults(swimResult3);
    }

    @Test
    void addCompetitionResultTest(){
        //act
        competitionSwimmer.addSwimResults(swimResult);

        //assert
        assertEquals(competitionSwimmer.getBestResult(Discipline.CRAWL),swimResult);
   }
   @Test
   void getBestResultTestOnNoResults(){
        //arrange
       CompetitionSwimmer competitionSwimmerNull = new CompetitionSwimmer(121, "Anders", "Hørkær 7F","51931177", "andersgraa@gmail.com", LocalDate.of(2004, 11, 7));

       //assert
       assertNull(competitionSwimmerNull.getBestResult(Discipline.CRAWL));
   }

   @Test
    void getBestResultTest(){
        //arrange
       SwimResult swimResultBest = new SwimResult(Discipline.CRAWL,1.00,LocalDate.of(2026,11,10), "Ek's svøm", 13);

       //act
       competitionSwimmer.addSwimResults(swimResultBest);

       //assert
       assertEquals(competitionSwimmer.getBestResult(Discipline.CRAWL), swimResultBest);

   }
   @Test
    void getSwimResultsTest(){
        //act
       List<SwimResult> swimResultTest = competitionSwimmer.getSwimResults();

       //assert
        assertEquals(competitionSwimmer.getSwimResults(), swimResultTest);
   }

   @Test
    void getSwimResultOnMemberNoSwimResults (){
        //arrange
       CompetitionSwimmer competitionSwimmerNull = new CompetitionSwimmer(121, "Anders", "Hørkær 7F","51931177", "andersgraa@gmail.com", LocalDate.of(2004, 11, 7));

       //assert
       assertNotNull(competitionSwimmerNull.getSwimResults());
   }
}
