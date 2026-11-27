import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class MemberTest {
Member member;

@BeforeEach
void Setup (){
    member = new Member(111, "Louise", "Norgesgade 17", "21212121","louise@gmail.com", LocalDate.of(1991, 9, 6), new MemberShip());
}
    @Test
    void createMemberTest() {
        //Arrange


        //Assert
        assertEquals(111, member.getMemberId());
        assertEquals("Louise", member.getName());
        assertEquals("Norgesgade 17", member.getAddress());
        assertEquals("21212121", member.getPhoneNumber());
        assertEquals("louise@gmail.com", member.getEmail());
        assertEquals(LocalDate.of(1991, 9, 6), member.getBirthday());

    }

    @Test
    void editMemberTest (){
        //arrange
        MemberShip memberShip = new MemberShip();
        Member memberEdgeCaseTester = new Member(1111111,
        "","","","",LocalDate.of(2000,1,1),memberShip);

        member.setEmail("ek@gmail.com");
        member.setAddress("Guldberggade 3");
        member.setName("EK");
        member.setPhoneNumber("67676767");

        //assert
        assertEquals("ek@gmail.com", member.getEmail());
        assertEquals("Guldberggade 3", member.getAddress());
        assertEquals("EK",member.getName());
        assertEquals("67676767", member.getPhoneNumber());

        assertNotNull(memberEdgeCaseTester.getName());
        assertNotNull(memberEdgeCaseTester.getEmail());
        assertNotNull(memberEdgeCaseTester.getAddress());


    }


}
