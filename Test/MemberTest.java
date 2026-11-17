import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class MemberTest {

    @Test
    void createMemberTest() {
        //Arrange
        Member member = new Member(111, "Louise", "Norgesgade 17", "21212121","louise@gmail.com", LocalDate.of(1991, 9, 6));

        //Assert
        assertEquals(111, member.getMemberId());
        assertEquals("Louise", member.getName());
        assertEquals("Norgesgade 17", member.getAddress());
        assertEquals("21212121", member.getPhoneNumber());
        assertEquals("louise@gmail.com", member.getEmail());
        assertEquals(LocalDate.of(1991, 9, 6), member.getBirthday());

    }
}
