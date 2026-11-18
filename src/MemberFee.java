
public class MemberFee {
    Member member;

    public MemberFee (Member member) {
        this.member = member;
    }

    public double calculateYearlyMemberFee(Member member) {
        MemberShip memberShip = member.getMembership();
        int age = memberShip.calculateAge(member.getBirthday());
        //Member er passiv
        if (memberShip.getStatus() == MemberShipStatus.PASSIVE) {
            return 500;
        }
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

    public double calculateMemberFee(Member member) {
        return Math.round((calculateYearlyMemberFee(member) / 12)* 100.0)/100.0;
    }
}
