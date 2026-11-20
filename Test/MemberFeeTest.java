import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class MemberFeeTest {
    MemberShip memberShip;
    MemberFee memberFee;
    Member member;

    @BeforeEach
    void setup(){
        memberShip = new MemberShip();
        member = new Member(111, "Anders", "Hørkær 7F","51931177", "andersgraa@gmail.com", LocalDate.of(2004, 11, 7),memberShip);
        memberFee = new MemberFee(member);
    }
    @Test
    void gettersTest(){
        assertEquals(memberShip,member.getMembership());
        assertEquals(memberFee.getMember(), member);
        assertEquals(PaymentResult.NOT_PAID, memberFee.getPaymentResult());
        assertEquals(1600, memberFee.getAmount());
    }

    @Test
    void CalculateMemberShipFeeTest(){
        var x18 = new Member(0, null, null, null, null, LocalDate.of(2008,11,20),memberShip);
        var m18 = new MemberFee(x18);
        var x17 = new Member(0, null, null, null, null, LocalDate.of(2008,11,21),memberShip);
        var m17 = new MemberFee(x17);
        var x60 = new Member(0, null, null, null, null, LocalDate.of(1966,1,20),memberShip);
        var m60 = new MemberFee(x60);
        var x0 = new Member(0, null, null, null, null, LocalDate.of(2026,11,25),memberShip);
        var m0 = new MemberFee(x0);

        assertEquals(1600, m18.getAmount());
        assertEquals(1000, m17.getAmount());
        assertEquals(1200, m60.getAmount());
        assertEquals(1000, m0.getAmount());
    }
}

