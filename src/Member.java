import java.time.LocalDate;

public class Member {

    private int memberId;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private LocalDate birthday;
    private MemberShip membership;

    public Member(int memberId, String name, String address, String phoneNumber, String email, LocalDate birthday) {
        this.memberId = memberId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthday = birthday;

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
