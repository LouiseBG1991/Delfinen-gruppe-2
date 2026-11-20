import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class SwimResultTest {
    SwimResult swimResult1;
    SwimResult swimResult2;

    @BeforeEach
    void setup(){
        swimResult1 = new SwimResult(Discipline.CRAWL,1.15, LocalDate.of(2026,11,8),"EK's Svøm", 1);
        swimResult2 = new SwimResult(Discipline.CRAWL,1.16, LocalDate.of(2026,11,8));
    }

    @Test
    void testOf2ConstructorsAssignedRightValues(){
        assertTrue(swimResult1.isCompetition());
        assertFalse(swimResult2.isCompetition());
    }

    @Test
    void testOfGettersAndSetters(){
        assertEquals(Discipline.CRAWL, swimResult1.getDiscipline());
        assertEquals(1.15, swimResult1.getFinishTime());
        assertEquals(LocalDate.of(2026,11,8), swimResult1.getDate());
        assertEquals("EK's Svøm", swimResult1.getCompetitionName());
        assertEquals(1, swimResult1.getPlacement());
    }
}
