import java.util.ArrayList;
import java.util.List;

public class Administration {

    private List<MemberFee> memberFees;

    public Administration() {
        this.memberFees = new ArrayList<>();
    }

    public void addMemberFee(MemberFee memberFee) {
        memberFees.add(memberFee);
    }

    public double expectedAnnualRevenue() {
        double totalRevenue = 0;

        for (MemberFee memberFee : memberFees) {
            totalRevenue += memberFee.getAmount();
        }

        return totalRevenue;
    }

    public List<Member> showMembersWithOutstandingPayment() {
        List<Member> outstanding = new ArrayList<>();
        for (MemberFee memberFee : memberFees) {
            if (memberFee.getPaymentResult() == PaymentResult.NOT_PAID) {
                outstanding.add(memberFee.getMember());
            }
        }

        return outstanding;
    }

}
