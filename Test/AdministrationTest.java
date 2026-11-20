import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

class AdministrationTest {

    Administration administration;
    Member member1;
    Member member2;
    MemberFee fee1;
    MemberFee fee2;

    @BeforeEach
    void setUp() {
        administration = new Administration();

        MemberShip membership1 = new MemberShip();
        MemberShip membership2 = new MemberShip();

        member1 = new Member(1, "Anders", "Copenhagen", "12345678", "anders@gmail.com", LocalDate.of(2000, 1, 1), membership1);

        member2 = new Member(2, "Peter", "Roskilde", "87654321", "peter@gmail.com", LocalDate.of(2005, 1, 1), membership2);

        fee1 = new MemberFee(member1);
        fee2 = new MemberFee(member2);
    }

    @Test
    void testAddMemberFee() {
        administration.addMemberFee(fee1);

        assertEquals(fee1.getAmount(), administration.expectedAnnualRevenue());
    }

    @Test
    void testExpectedAnnualRevenue() {
        administration.addMemberFee(fee1);
        administration.addMemberFee(fee2);

        assertEquals(fee1.getAmount() + fee2.getAmount(), administration.expectedAnnualRevenue());
    }

    @Test
    void testShowMembersWithOutstandingPayment() {
        administration.addMemberFee(fee1);
        administration.addMemberFee(fee2);

        fee1.memberHasPaid();

        assertEquals(1, administration.showMembersWithOutstandingPayment().size());

        assertTrue(administration.showMembersWithOutstandingPayment().contains(member2));
    }
}
