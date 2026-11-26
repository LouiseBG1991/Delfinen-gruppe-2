import java.time.LocalDate;

public class MemberFee {
//    private Member member;
    private MemberShip memberShip; // medlemsskab, som kontingentet knytter sig til
    private PaymentResult paymentResult; //betalingsstatus
    private double amount; // beløb
    private Member member;
    private LocalDate dueDate; // Betalingsfrist
    private int seasonYear; // sæsonår



    // Bruges når et nyt kontingent oprettes i programmet (sætter frist på 8 dage fra i dag)
    public MemberFee(Member member) {
        this.memberShip = member.getMembership();
        this.paymentResult = PaymentResult.NOT_PAID; // kontingentet er ikke betalt, når medlemmet oprettes
        this.amount = calculateFeeByMemberShip(member);
        this.member = member;
        this.dueDate = LocalDate.now().plusDays(8); // Sat frist til 8 dage fra oprettelse
        this.seasonYear = LocalDate.now().getYear(); // Sætter det nuværende år automatisk
    }


    public MemberShip getMemberShip() {
        return memberShip;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isOverDue() {
        return this.paymentResult == PaymentResult.NOT_PAID && LocalDate.now().isAfter(this.dueDate);
    }

    public int getSeasonYear() {
        return seasonYear;
    }

    public PaymentResult getPaymentResult() {
        return paymentResult;
    }

    public double getAmount() {
        return amount;
    }

    public void memberHasPaid() {
        this.paymentResult = PaymentResult.PAID; // kan bruges til at registere betaling
    }


    public double calculateFeeByMemberShip(Member member) {
        //Passivt medlemskab
        if (memberShip.getStatus() == MemberShipStatus.PASSIVE) {
            return 500;
        }

        //Aktivt medlemskab
        int age = memberShip.calculateAge(member.getBirthday());
        //Member er under 18
        if (age < 18) {
            return 1000;
        }
        //Member over 60
        if (age >= 60) {
            return 1200;
        }
        //Member er mellem 18-60
        else {
            return 1600;
        }
    }
//
//    public double calculateMemberFee(Member member) {
//        return Math.round((calculateYearlyMemberFee(member) / 12)* 100.0)/100.0;
//    }
}
