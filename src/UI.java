import java.time.LocalDate;

public class UI {

    private Club club;

    public UI (Club club) {
        this.club = club;
    }

    public void registerMember() {
        IO.println();
        IO.println("Registrer nyt medlem");
        IO.println();

        int memberId = Integer.parseInt(IO.readln("Indtast medlemsnummer: "));

        if (club.findMemberByMemberId(memberId) != null) {
            IO.println("Dette medlemsnummer findes allerede.");
            return;
        }

        String name = IO.readln("Indtast navn: ");
        String address = IO.readln("Indtast adresse: ");
        String phoneNumber = IO.readln("Indtast telefonnummer: ");
        String email = IO.readln("Indtast email: ");
        LocalDate birthday = LocalDate.parse(IO.readln("Indtast fødselsdato (yyyy-mm-dd): "));

        Member member = new Member(memberId, name, address, phoneNumber, email, birthday);

        club.addMember(member);

        IO.println();
        IO.println("Medlem registreret");
        IO.println();
        IO.println(member);


    }
}
