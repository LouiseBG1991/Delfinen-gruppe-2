import java.time.LocalDate;
import java.time.Period;

public class MemberShip {
    private int seasonYear;
    private MemberShipStatus status;
    private SwimmerType swimmerType;


    //Opretter et medlemskab uden valgt status endnu (NONE)
    public MemberShip(){
        this.seasonYear = LocalDate.now().getYear();
        this.status = MemberShipStatus.NONE;
        this.swimmerType = SwimmerType.NONE;
    }

    //Opretter et aktivt medlemskab
    public MemberShip(SwimmerType swimmerType) {
        setActive(swimmerType);
    }

    //Setters

    public void setStatus(MemberShipStatus status) {
        if (status == null) {
            throw new IllegalArgumentException();
        }
        this.status = status;

        if (status != MemberShipStatus.ACTIVE) {
            this.swimmerType = SwimmerType.NONE;
        }
    }

    public int getSeasonYear() {
        return seasonYear;
    }

    public void setSwimmerType(SwimmerType swimmerType) {
        if (swimmerType == null) {
            throw new IllegalArgumentException();
        }
        if (swimmerType != SwimmerType.NONE && this.status != MemberShipStatus.ACTIVE) {
            throw new IllegalStateException();
        }
        this.swimmerType = swimmerType;
    }



    public void setActive(SwimmerType swimmerType){
        if (swimmerType == null || swimmerType == SwimmerType.NONE) {
            throw new IllegalArgumentException();
        }
        this.status = MemberShipStatus.ACTIVE;
        this.swimmerType = swimmerType;
    }

    public void setPassive() {
        this.status = MemberShipStatus.PASSIVE;
        this.swimmerType = SwimmerType.NONE;
    }

    //Getters
    public MemberShipStatus getStatus() {return status;}
    public SwimmerType getSwimmerType() {return swimmerType;}

    public boolean isActive() {
        return this.status == MemberShipStatus.ACTIVE;
    }


    // Aldersberegning
    public int calculateAge(LocalDate birthday){
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public boolean isJunior(LocalDate birthday) {
        return calculateAge(birthday) < 18;
    }
    public boolean isSenior(LocalDate birthday) {
        return !isJunior(birthday);
    }

}
