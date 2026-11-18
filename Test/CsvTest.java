import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvTest {

    @Test
    void testMemberToCsv() {
        CsvMapper csvMapper = new CsvMapper();
        Member member = new Member(111, "Louise", "Norgesgade 17", "21212121","louise@gmail.com", LocalDate.of(1991, 9, 6), new MemberShip(SwimmerType.COMPETITIVE));

        String result = "111,Louise,Norgesgade 17,21212121,louise@gmail.com,1991-09-06,COMPETITIVE,";

        assertEquals(result, csvMapper.memberToCsv(member));
    }

    @Test
    void testMemberFromCsv() {
        CsvMapper csvMapper = new CsvMapper();
        String line = "111,Louise,Norgesgade 17,21212121,louise@gmail.com,1991-09-06,COMPETITIVE,";

        Member member = csvMapper.memberFromCsv(line);

        assertEquals(line, csvMapper.memberToCsv(member));
    }

    @Test
    void testSaveMembers() throws IOException {
        ClubSaver clubSaver = new ClubSaver();

        List<Member> members = new ArrayList<>();
        members.add(new Member(111, "Louise", "Norgesgade 17", "21212121","louise@gmail.com", LocalDate.of(1991, 9, 6), new MemberShip(SwimmerType.COMPETITIVE)));

        clubSaver.saveMembers(members,"testMembers.csv");

        String actual = Files.readString(Path.of("testMembers.csv"));
        String expected = "111,Louise,Norgesgade 17,21212121,louise@gmail.com,1991-09-06,COMPETITIVE,";

        assertEquals(expected, actual.trim());
    }

    @Test
    void testLoadMembers() throws IOException {
        String csv = "111,Louise,Norgesgade 17,21212121,louise@gmail.com,1991-09-06,COMPETITIVE,";

        Files.writeString(Path.of("testMembers.csv"), csv);

        ClubLoader clubLoader = new ClubLoader();
        CsvMapper csvMapper = new CsvMapper();
        List<Member> members = clubLoader.loadMembers(Path.of("testMembers.csv"));

        assertEquals(csv, csvMapper.memberToCsv(members.getFirst()));

    }
}
