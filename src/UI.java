import java.nio.channels.MembershipKey;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UI {

    private Club club;

    public UI(Club club) {
        this.club = club;

    }


    public void Run() {
        boolean isRunning = true;
        ShowMenu();

        while (isRunning) {
            int choice = Integer.parseInt(IO.readln("Hvad er dit valg?"));

            switch (choice) {
                case 0 -> isRunning = false;
                case 1 -> ShowKassererMenu();
                case 3 -> ShowChairmanMenu();
                case 2 -> ShowTrainerMenu();
                default -> IO.println("Ugyldigt valg.");
            }
        }
    }

    public void ShowMenu() {
        IO.println();
        IO.println("1. Kasserer");
        IO.println("2. Træner");
        IO.println("3. Formand");
        IO.println("4. Medlem");
        IO.println("0. Afslut");
    }

    public void ShowTrainerMenu() {
        boolean trainerIsRunning = true;
        IO.println();
        IO.println("1. Stævneresultater");
        IO.println("2. Svømmediscipliner");
        IO.println("0. Slut");

        while (trainerIsRunning) {
            int trainerChoice = Integer.parseInt(IO.readln("Vælg en mulighed"));

            switch (trainerChoice) {
                case 0 -> trainerIsRunning = false;
                case 1 -> IO.println("Du ser stævneresultater");
                case 2 -> IO.println("Du ser svømmediscipliner");
                default -> IO.println("Ugyldigt valg.");
            }
        }
    }

    public void ShowChairmanMenu() {
        boolean chairmanIsRunning = true;
        IO.println();
        IO.println("1. Opret medlem");
        IO.println("2. Rediger medlem");
        IO.println("3. Vis medlemmer");
        IO.println("0. Slut");

        while (chairmanIsRunning) {
            int chairmanChoice = Integer.parseInt(IO.readln("Vælg en mulighed"));
            switch (chairmanChoice) {
                case 1 -> registerMember();
                case 2 -> editMember();
                case 3 -> showMembers();
                case 0 -> chairmanIsRunning = false;
                default -> IO.println("Ugyldigt valg.");
            }
        }
    }

    public void ShowKassererMenu() {
        boolean kassererIsRunning = true;

        IO.println();
        IO.println("1. Årlig indtjening");
        IO.println("2. Medlemmer i restance");
        IO.println("0. Slut");

        while (kassererIsRunning) {
            int kassererChoice = Integer.parseInt(IO.readln("Vælg en mulighed: "));

            switch (kassererChoice) {
                case 1 -> showExpectedAnnualRevenue();
                case 2 -> showMembersWithOutstandingPayment();
                case 0 -> kassererIsRunning = false;
                default -> IO.println("Ugyldigt valg.");
            }
        }
    }

    public void showExpectedAnnualRevenue() {
        IO.println();
        IO.println("---------Vis oversigt over forventet indtægt---------");
        IO.println();

        double revenue = club.getExpectedAnnualRevenue();

        IO.println("Forventet indtægt: " + revenue + "kr.");

    }

    public void showMembersWithOutstandingPayment() {
        IO.println();
        IO.println("---------Vis oversigt over medlemmer i restance---------");
        IO.println();

        List<Member> outstanding = club.getMembersWithOutstandingPayment();
        if (outstanding.isEmpty()) {
            IO.println("Ingen medlemmer i restance");
        } else {
            IO.println("Medlemmer i restance: ");
            for (Member member : outstanding) {
                IO.println();
                IO.println(member);

            }
        }

    }

    public void registerMember() {
        IO.println();
        IO.println("--------Registrer nyt medlem---------");
        IO.println();

        int memberId = Integer.parseInt(IO.readln("Indtast medlemsnummer: ").trim());

        try {
            club.doesMemberIdAlreadyExist(memberId);
        } catch (IllegalArgumentException e) {
            IO.println("Medlemsnummeret findes allerede.");
            return;
        }

        String name = IO.readln("Indtast navn: ").trim();
        String address = IO.readln("Indtast adresse: ").trim();
        String phoneNumber = IO.readln("Indtast telefonnummer: ").trim();
        String email = IO.readln("Indtast email: ").trim();
        LocalDate birthday = LocalDate.parse(IO.readln("Indtast fødselsdato (yyyy-mm-dd): ").trim());

        MemberShip memberShip = chooseMemberShip();

        Member member = new Member(memberId, name, address, phoneNumber, email, birthday, memberShip);

        club.addMember(member);

        IO.println();
        IO.println("Medlem registreret.");
        IO.println();
        IO.println(member);

    }

    public void editMember() {
        boolean editIsRunning = true;

        IO.println();
        IO.println("---------Rediger medlem---------");
        IO.println();

        int chosenMember = Integer.parseInt(IO.readln("Indtast medlemsnummer på det medlem, hvis oplysninger du vil redigere: ").trim());

        Member member = club.findMemberByMemberId(chosenMember);

        if (member == null) {
            IO.println("Medlemmet findes ikke.");
            return;
        }

        IO.println("1. Ændre navn");
        IO.println("2. Ændre email");
        IO.println("3. Ændre adresse");
        IO.println("4. Ændre telefonnummer");
        IO.println("0. Gå tilbage");

        while (editIsRunning) {
            int editWhat = Integer.parseInt(IO.readln("Hvad vil du gerne ændre? "));
            switch (editWhat) {
                case 1 -> member.setName(IO.readln("Indtast nyt navn: "));
                case 2 -> member.setEmail(IO.readln("Indtast ny email: "));
                case 3 -> member.setAddress(IO.readln("Indtast ny adresse: "));
                case 4 -> member.setPhoneNumber(IO.readln("Indtast nyt telefonnummer: "));
                case 0 -> editIsRunning = false;
                default -> IO.println("Udgyldigt valg");
            }
            IO.println("\nMedlemmet er opdateret\n" + member);
        }

    }

    public void showMembers() {
        IO.println();
        IO.println("---------Vis oversigt over medlemmer---------");
        IO.println();

        if (club.getMembers().isEmpty()) {
            IO.println("Der er ingen medlemmer i klubben.");
            return;
        }

        club.printMembers();
    }


    private MemberShip chooseMemberShip() {
        MemberShip memberShip = new MemberShip();

        while (memberShip.getStatus() == MemberShipStatus.NONE) {
            IO.println("""
                    Vælg medlemskab:
                    1. Passivt medlemskab
                    2. Aktivt medlemskab
                    2. Aktiv - Motionist
                    3. Aktiv Konkurrencesvømmer""");

            String menuChoice = IO.readln("Vælg (1-2): ").trim();

            switch (menuChoice) {
                case "1" -> memberShip.setPassive();
                case "2" -> {
                    memberShip.setStatus(MemberShipStatus.ACTIVE);
                    chooseSwimmerType(memberShip);
                }
                default -> IO.println("Ugyldigt valg. Prøv igen");
            }
        }
        return memberShip;
    }


    private void chooseSwimmerType(MemberShip memberShip) {
        while (memberShip.getSwimmerType() == SwimmerType.NONE) {
            IO.println("""
                    Vælg svømmertype:
                    1. Motionist
                    2. Konkurrencesvømmer""");

            String typeChoice = IO.readln("Vælg (1-2)").trim();

            try {
                switch (typeChoice) {
                    case "1" -> memberShip.setSwimmerType(SwimmerType.CASUAL);
                    case "2" -> memberShip.setSwimmerType(SwimmerType.COMPETITIVE);
                    default -> IO.println("Ugyldig valg. Vælg 1 for Motionist eller 2 for Konkurrencesvømmer.");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                IO.println("Motionist eller konkurrencesvømmer kræver, at man har et aktivt medlemskab");
            }
        }
    }


    private void printTop5(Team team, Discipline discipline) {
        IO.println(("\n————— Top 5: " + team.getTeamName() + " (" + discipline + ") —————"));
        List<CompetitionSwimmer> top5 = team.getTop5(discipline);

        if (top5.isEmpty()) {
            IO.println("Ingen registrerede tideri denne disciplin endnu.");
        } else {
            int rank = 1;
            for (CompetitionSwimmer swimmer : top5) {
                SwimResult best = swimmer.getBestResult(discipline);
                IO.println(rank + ". " + swimmer.getName() + " - " + best);
                rank++;
            }
        }
    }
}


