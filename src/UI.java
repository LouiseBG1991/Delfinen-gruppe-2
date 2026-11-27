import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class UI {

    private Club club;

    public UI(Club club) {
        this.club = club;
    }

    // ---------- Hjælpemetoder til input ----------

    private int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(IO.readln(prompt).trim());
            } catch (NumberFormatException e) {
                IO.println("Indtast venligst et tal.");
            }
        }
    }

    private double readDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(IO.readln(prompt).trim().replace(",", "."));
            } catch (NumberFormatException e) {
                IO.println("Indtast venligst et tal (f.eks. 62.45).");
            }
        }
    }

    private LocalDate readDate(String prompt) {
        while (true) {
            try {
                return LocalDate.parse(IO.readln(prompt).trim());
            } catch (DateTimeParseException e) {
                IO.println("Ugyldig dato. Brug formatet yyyy-mm-dd.");
            }
        }
    }

    // ---------- Hovedmenu ----------

    public void Run() {
        boolean isRunning = true;

        while (isRunning) {
            ShowMenu();
            int choice = readInt("Hvad er dit valg? ");
            switch (choice) {
                case 0 -> isRunning = false;
                case 1 -> ShowKassererMenu();
                case 2 -> ShowTrainerMenu();
                case 3 -> ShowChairmanMenu();
                default -> IO.println("Ugyldigt valg.");
            }
        }
        IO.println("Farvel!");
    }

    public void ShowMenu() {
        IO.println();
        IO.println("1. Kasserer");
        IO.println("2. Træner");
        IO.println("3. Formand");
        IO.println("0. Afslut");
    }

    // ---------- Træner ----------

    public void ShowTrainerMenu() {
        boolean trainerIsRunning = true;

        while (trainerIsRunning) {
            IO.println();
            IO.println("1. Stævneresultater");
            IO.println("2. Svømmediscipliner");
            IO.println("3. Tilføj svømmeresultat");
            IO.println("4. Top 5 i disciplin");
            IO.println("5. Træningsresultater");
            IO.println("0. Tilbage");

            int trainerChoice = readInt("Vælg en mulighed: ");

            switch (trainerChoice) {
                case 1 -> showCompetitionResults();
                case 2 -> showDisciplines();
                case 3 -> createSwimResult();
                case 4 -> showTop5();
                case 5 -> showTrainingResults();
                case 0 -> trainerIsRunning = false;
                default -> IO.println("Ugyldigt valg.");
            }
        }
    }

    public void createSwimResult() {
        IO.println();
        IO.println("---------Tilføj svømmeresultat---------");
        IO.println();

        int memberId = readInt("Indtast medlemsnummer: ");
        Member member = club.findMemberByMemberId(memberId);

        if (member == null) {
            IO.println("Medlemmet findes ikke.");
            return;
        }

        Discipline discipline = chooseDiscipline();
        double time = readDouble("Tid i sekunder: ");
        LocalDate date = readDate("Dato (yyyy-mm-dd): ");

        String isTraining = IO.readln("Er det et træningsresultat? (y/n): ").trim().toLowerCase();

        if (isTraining.equals("y")) {
            TrainingResult result = new TrainingResult(member, discipline, time, date);
            club.addTrainingResult(result);
        } else {
            String eventName = IO.readln("Navn på stævne: ").trim();
            int placement = readInt("Placering: ");
            String location = IO.readln("Sted: ");
            CompetitionResult result = new CompetitionResult(member, discipline, time, date, eventName, placement,location);
            club.addCompetitionResult(result);
        }

        IO.println();
        IO.println("Resultatet er registreret.");
    }

    private void showCompetitionResults() {
        IO.println();
        IO.println("---------Stævneresultater---------");
        IO.println();

        List<CompetitionResult> results = club.getCompetitionResults();
        if (results.isEmpty()) {
            IO.println("Ingen stævneresultater registreret endnu.");
            return;
        }
        for (CompetitionResult r : results) {
            IO.println(r);
        }
    }

    private void showTrainingResults() {
        IO.println();
        IO.println("---------Træningsresultater---------");
        IO.println();

        List<TrainingResult> results = club.getTrainingResults();
        if (results.isEmpty()) {
            IO.println("Ingen træningsresultater registreret endnu.");
            return;
        }
        for (TrainingResult r : results) {
            IO.println(r);
        }
    }

    private void showTop5() {
        Discipline discipline = chooseDiscipline();

        IO.println();
        IO.println("————— Top 5: " + discipline + " —————");

        List<TrainingResult> top5 = club.getTop5(discipline);
        if (top5.isEmpty()) {
            IO.println("Ingen registrerede tider i denne disciplin endnu.");
            return;
        }

        int rank = 1;
        for (TrainingResult r : top5) {
            IO.println(rank + ". " + r);
            rank++;
        }
    }

    // ---------- Formand ----------

    public void ShowChairmanMenu() {
        boolean chairmanIsRunning = true;

        while (chairmanIsRunning) {
            IO.println();
            IO.println("1. Opret medlem");
            IO.println("2. Rediger medlem");
            IO.println("3. Vis medlemmer");
            IO.println("0. Tilbage");

            int chairmanChoice = readInt("Vælg en mulighed: ");
            switch (chairmanChoice) {
                case 1 -> registerMember();
                case 2 -> editMember();
                case 3 -> showMembers();
                case 0 -> chairmanIsRunning = false;
                default -> IO.println("Ugyldigt valg.");
            }
        }
    }

    public void registerMember() {
        IO.println();
        IO.println("--------Registrer nyt medlem---------");
        IO.println();

       int memberId = -1;

        while (memberId == -1) {
            try {
                int memberIdAsk = Integer.parseInt(IO.readln("Indtast medlemsnummer: ").trim());

                club.doesMemberIdAlreadyExist(memberIdAsk);
                memberId = memberIdAsk;

                } catch (NumberFormatException e) {
                    IO.println("Indtast et gyldigt tal.");
                } catch (IllegalArgumentException e) {
                    IO.println("Medlemsnummeret findes allerede. Prøv igen");
            }
        }

        String name = IO.readln("Indtast navn: ").trim(); // må ikke være tomt
        String address = IO.readln("Indtast adresse: ").trim(); // må ikke være tomt
        String phoneNumber = IO.readln("Indtast telefonnummer: ").trim(); //må ikke være bogstaver

        String email = "";
        while(email.isEmpty()) {

            String emailAsk = IO.readln("Indtast email: ").trim(); // skal være et gyldigt format, f.eks. indeholde @
            if (emailAsk.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
                email = emailAsk;
            } else {
                IO.println("Ugyldig email. Prøv igen med f.eks. navn@mail.dk");
            }

        }
        LocalDate birthday = null;

        while (birthday == null) {
        try {
            birthday = LocalDate.parse(IO.readln("Indtast fødselsdato (yyyy-mm-dd): ").trim());
        } catch (DateTimeParseException e) {
            IO.println("Ugyldig dato. Brug formatet yyyy-mm-dd");
        }
        }

        MemberShip memberShip = chooseMemberShip();

        Member member = new Member(memberId, name, address, phoneNumber, email, birthday, memberShip);
        club.addMember(member);

        IO.println();
        IO.println("Medlem registreret.");
        IO.println();
        IO.println(member);
    }

    public void editMember() {
        IO.println();
        IO.println("---------Rediger medlem---------");
        IO.println();

        int chosenMember = readInt("Indtast medlemsnummer på det medlem, hvis oplysninger du vil redigere: ");
        Member member = club.findMemberByMemberId(chosenMember);

        if (member == null) {
            IO.println("Medlemmet findes ikke.");
            return;
        }

        boolean editIsRunning = true;
        while (editIsRunning) {
            IO.println();
            IO.println("1. Ændre navn");
            IO.println("2. Ændre email");
            IO.println("3. Ændre adresse");
            IO.println("4. Ændre telefonnummer");
            IO.println("0. Gå tilbage");

            int editWhat = readInt("Hvad vil du gerne ændre? ");
            boolean changed = true;

            switch (editWhat) {
                case 1 -> member.setName(IO.readln("Indtast nyt navn: ").trim());
                case 2 -> member.setEmail(IO.readln("Indtast ny email: ").trim());
                case 3 -> member.setAddress(IO.readln("Indtast ny adresse: ").trim());
                case 4 -> member.setPhoneNumber(IO.readln("Indtast nyt telefonnummer: ").trim());
                case 0 -> {
                    editIsRunning = false;
                    changed = false;
                }
                default -> {
                    IO.println("Ugyldigt valg.");
                    changed = false;
                }
            }

            if (changed) {
                IO.println("\nMedlemmet er opdateret\n" + member);
            }
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

        IO.println("Antal medlemmer i klubben: " + club.membersInTotal());
        IO.println();
        for (Member member : club.getMembers()) {
            IO.println(member);
        }
    }

    private MemberShip chooseMemberShip() {
        MemberShip memberShip = new MemberShip();

        while (memberShip.getStatus() == MemberShipStatus.NONE) {
            IO.println("""
                    Vælg medlemskab:
                    1. Passivt medlemskab
                    2. Aktivt medlemskab""");

            String menuChoice = IO.readln("Vælg (1-2): ").trim();

            switch (menuChoice) {
                case "1" -> memberShip.setPassive();
                case "2" -> {
                    memberShip.setStatus(MemberShipStatus.ACTIVE);
                    chooseSwimmerType(memberShip);
                }
                default -> IO.println("Ugyldigt valg. Prøv igen.");
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

            String typeChoice = IO.readln("Vælg (1-2): ").trim();

            try {
                switch (typeChoice) {
                    case "1" -> memberShip.setSwimmerType(SwimmerType.CASUAL);
                    case "2" -> memberShip.setSwimmerType(SwimmerType.COMPETITIVE);
                    default -> IO.println("Ugyldigt valg. Vælg 1 for Motionist eller 2 for Konkurrencesvømmer.");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                IO.println("Motionist eller konkurrencesvømmer kræver, at man har et aktivt medlemskab.");
            }
        }
    }

    // ---------- Kasserer ----------

    public void ShowKassererMenu() {
        boolean kassererIsRunning = true;

        while (kassererIsRunning) {
            IO.println();
            IO.println("1. Årlig indtjening");
            IO.println("2. Medlemmer i restance");
            IO.println("3. Registrer betaling af kontingent");
            IO.println("0. Tilbage");

            int kassererChoice = readInt("Vælg en mulighed: ");

            switch (kassererChoice) {
                case 1 -> showExpectedAnnualRevenue();
                case 2 -> showMembersWithOutstandingPayment();
                case 3 -> registerPayment();
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
        IO.println("Forventet indtægt: " + revenue + " kr.");
    }

    public void showMembersWithOutstandingPayment() {
        IO.println();
        IO.println("---------Vis oversigt over medlemmer i restance---------");
        IO.println();

        List<Member> outstanding = club.getMembersWithOutstandingPayment();
        if (outstanding.isEmpty()) {
            IO.println("Ingen medlemmer i restance.");
        } else {
            IO.println("Medlemmer i restance: ");
            for (Member member : outstanding) {
                IO.println();
                IO.println(member);
            }
        }
    }

    public void registerPayment() {
        IO.println();
        IO.println("-----------Betaling af kontingent----------");
        IO.println();

        int memberId = readInt("Indtast medlemsnummer på det medlem, hvis kontingentbetaling du vil registrere: ");

        if (club.registerPayment(memberId)) {
            IO.println("Betalingen er registreret.");
        } else {
            IO.println("Betalingen kunne ikke registreres.");
        }
    }
    private Discipline chooseDiscipline() {
        Discipline[] disciplines = Discipline.values();

        while (true) {
            IO.println("Vælg disciplin:");
            for (var index = 0; index < disciplines.length; index++) {
                IO.println((index + 1) + ". " + disciplines[index]);
            }
            int choice = readInt("Vælg (1-" + disciplines.length + "): ");
            if (choice >= 1 && choice <= disciplines.length) {
                return disciplines[choice - 1];
            }
            IO.println("Ugyldigt valg. Prøv igen.");
        }
    }

    private void showDisciplines() {
        IO.println();
        IO.println("---------Svømmediscipliner---------");
        for (var disciplines : Discipline.values()) {
            IO.println("- " + disciplines);
        }
    }
}