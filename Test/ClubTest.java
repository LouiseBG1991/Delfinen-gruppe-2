import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ClubTest {

    @Test
    void addMemberTest() {
        //Arrange
        Club club = new Club();
        Member member = new Member(111, "Louise", "Norgesgade 17", "21212121","louise@gmail.com", LocalDate.of(1991, 9, 6), new MemberShip());
        Member member1 = new Member(222, "Marie", "Skyttegade 10", "22222222", "marie@gmail.com", LocalDate.of(1995, 7, 9), new MemberShip());


        //Act
        club.addMember(member);
        club.addMember(member1);

        //Assert
        assertEquals(2,club.getMembers().size());

    }

    @Test
    void duplicatedIdTest() {
        //Arrange
        Club club = new Club();
        Member member = new Member(111,"Louise", "Norgesgade 17", "21212121","louise@gmail.com", LocalDate.of(1991, 9, 6), new MemberShip());
        Member member1 = new Member(111, "Marie", "Skyttegade 10", "22222222", "marie@gmail.com", LocalDate.of(1995, 7, 9), new MemberShip());

        //Act
        club.addMember(member);


        //Assert
        assertThrows(IllegalArgumentException.class, () -> club.addMember(member1));
    }


}
