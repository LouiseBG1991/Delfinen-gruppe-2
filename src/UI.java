public class UI {
    public UI() {
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
            int trainerChoice = Integer.parseInt(IO.readln("Vælg"));

            switch (trainerChoice) {
                case 0 -> trainerIsRunning = false;
                case 1 -> IO.println("Du ser stævneresultater");
                case 2 -> IO.println("Du ser svømmediscipliner");
                default -> IO.println("Ugyldigt valg.");            }
        }
    }

    public void ShowChairmanMenu() {
        boolean chairmanIsRunning = true;
        IO.println();
        IO.println("1. Opret medlem");
        IO.println("2. Rediger medlem");
        IO.println("0. Slut");

        while (chairmanIsRunning) {
            int chairmanChoice = Integer.parseInt(IO.readln("Choose one"));
            switch (chairmanChoice) {
                case 1 -> IO.println("Du opretter et medlem.");
                case 2 -> IO.println("Du redigerer et medlem.");
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
        IO.println("0. End");

        while (kassererIsRunning) {
            int kassererChoice = Integer.parseInt(IO.readln("Choose one"));

            switch (kassererChoice) {
                case 1 -> IO.println("test");
                case 0 -> kassererIsRunning = false;
                default -> IO.println("Ugyldigt valg.");


            }
        }
    }
}
