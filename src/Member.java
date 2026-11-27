import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Member {

    private int memberId;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private LocalDate birthday;
    private MemberShip membership;
    private List<Discipline> disciplines = new ArrayList<>();

    public Member(int memberId, String name, String address, String phoneNumber, String email, LocalDate birthday, MemberShip memberShip) {
        this.memberId = memberId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthday = birthday;
        this.membership = memberShip;

    }

    //Getters og setters

    public void addDiscipline(Discipline discipline) {
        if(!disciplines.contains(discipline)) {
            disciplines.add(discipline);
        }

    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public MemberShip getMembership() {
        return membership;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isJunior() {return membership.isJunior(this.birthday);}
    public int getAge() {return membership.calculateAge(this.birthday);}


    @Override
    public String toString() {
        return String.format ("""
                Medlemsnummer: %s
                Navn: %s
                Adresse: %s
                Telefonnummer: %s
                Email: %s
                Fødselsdato: %s
                """, memberId, name, address, phoneNumber,email, birthday);
    }


}
