void main(String[] args) {
    String rootPath = args[0];
    Path path = Path.of(rootPath);
    Club club = new Club();


    ClubLoader loader = new ClubLoader();
    ClubSaver saver = new ClubSaver();

    List<Member> members = null;
    try {
        members = loader.loadMembers(path.resolve("Members.csv"));
        for (Member member : members) {
            club.addMember(member);
        }
        members.sort(null);
    } catch (IOException e) {
        IO.println("Could not find Members.csv");
    }

    List<CompetitionSwimmer> competitionSwimmers = null;
    try {
        competitionSwimmers = loader.loadCompetitionSwimmers(path.resolve("CompetitionSwimmers.csv"));
        for (CompetitionSwimmer competitionSwimmer : competitionSwimmers) {
            club.addCompetitionSwimmer(competitionSwimmer);
        }
        competitionSwimmers.sort(null);
    } catch (Exception e) {
        IO.println("Could not find CompetitionSwimmer.csv");
    }


    List<CompetitionResult> competitionResults = null;
    try {
        competitionResults = loader.loadCompetitionResults(path.resolve("CompetitionResults.csv"));
        competitionResults.sort(null);
    } catch (IOException e) {
        IO.println("Could not find CompetitionResults.csv");
    }
    List<CompititionResult> swimResultsCompetition = null;
    try {
        swimResultsCompetition = loader.loadSwimResultCompetition(path.resolve("SwimResultsCompetition.csv"));
        for (CompititionResult swimResult : swimResultsCompetition) {
            //kan ikke tilføje swimresult til medlem fordi swimresult ikke gemmer et medlem
            //tilføj addmetode til competetionswimmer
        }
        swimResultsCompetition.sort(null);
    } catch (IOException e) {
        IO.println("Could not find SwimResultsCompetiton.csv");
    }

    List<CompititionResult> swimResultsPractice = null;
    try {
        swimResultsPractice = loader.loadSwimResultPractices(path.resolve("SwimResultsPractice.csv"));
        for (CompititionResult swimResultPractice : swimResultsPractice) {
            //Hvad skal tilføjes?
        }
        swimResultsPractice.sort(null);
    } catch (IOException e) {
        IO.println("Could not find SwimResultsPractice.csv");
    }

    List<Team> teams = null;
    try {
        teams = loader.loadTeams(path.resolve("Teams.csv"));
        for (Team team : teams) {
        }
        //Kan ikke tiføjes til club fordi hold ikke kender til klub
        teams.sort(null);
    } catch (IOException e) {
        IO.println("Could not find Teams.csv");
    }


    UI ui = new UI(club);
    ui.Run();

    try {
        saver.saveMembers(club.getMembers(), path.resolve("Members.csv").toString());
    } catch (IOException e) {
        IO.println("Members.csv could not be saved");
    }

    if (competitionSwimmers != null) {
        try {
            saver.saveCompetitionSwimmers(competitionSwimmers, path.resolve("CompetitionSwimmers.csv").toString());
        } catch (IOException e) {
            IO.println("CompetitionSwimmers.csv could not be saved");
        }
    }
}