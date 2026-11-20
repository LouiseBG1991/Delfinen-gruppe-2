
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

class CompetitionResultTest {

    CompetitionResult result;
    LocalDate date;

    @BeforeEach
    void setUp() {
        date = LocalDate.of(2026, 5, 15);

        result = new CompetitionResult(111, "EK", "Ek's Svøm-off", date, LocalDate.of(2026,12,13), 2, "Crawl");
    }

    @Test
    void testGetters() {
        assertEquals(111, result.getMemberId());
        assertEquals("EK", result.getPlace());
        assertEquals("Ek's Svøm-off", result.getConvention());
        assertEquals(date, result.getTime());
        assertEquals(LocalDate.of(2026,12,13), result.getFinishTime());
        assertEquals(2, result.getPlacement());
        assertEquals("Crawl", result.getDiscipline());
    }

    @Test
    void testAddCompetitionResult() {
        CompetitionResult newResult = result.addCompetitionResult(2, "EK lygten", "Lygtens dårlige stevne", date, LocalDate.of(2026,12,13), 3, "Butterfly");

        assertNotNull(newResult);
        assertEquals(2, newResult.getMemberId());
        assertEquals("EK lygten", newResult.getPlace());
        assertEquals("Lygtens dårlige stevne", newResult.getConvention());
        assertEquals(date, newResult.getTime());
        assertEquals(LocalDate.of(2026,12,13), newResult.getFinishTime());
        assertEquals(3, newResult.getPlacement());
        assertEquals("Butterfly", newResult.getDiscipline());
    }
}
