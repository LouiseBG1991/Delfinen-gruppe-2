void main(String[] args) {

    Club club = new Club();
    CsvMapper csvMapper = new CsvMapper(club);
    ClubSaver clubSaver = new ClubSaver(csvMapper);
    ClubLoader clubLoader = new ClubLoader(csvMapper);
    String clubPath = args[0];

    List<Member> members = new ArrayList<>();
    List<TrainingResult> trainingResults = new ArrayList<>();
    List<CompetitionResult> competitionResults = new ArrayList<>();


    try {
        members = clubLoader.loadMembers("members.csv");
        for (Member member : members) {
            club.addMember(member);
        }
        members.sort(null);
    } catch (IOException e) {
        IO.println("Kunne ikke finde members.csv");
    }

    try {
        trainingResults = clubLoader.loadTrainingResults("trainingresults.csv");
        trainingResults.sort(null);
        for (TrainingResult trainingResult : trainingResults) {
            club.addTrainingResults(trainingResult);
        }
    } catch (IOException e) {
        IO.println("Kunne ikke finde trainingResults.csv");
    }

    try {
        competitionResults = clubLoader.loadCompetitionResults("competitionresults.csv");
        competitionResults.sort(null);
        for (CompetitionResult competitionResult : competitionResults) {
            club.addCompetitionResults(competitionResult);
        }
    } catch (IOException e) {
        IO.println("Kunne ikke finde competitionResults.csv");
    }

    UI ui = new UI(club);
    ui.Run();


    try {
        clubSaver.saveMembers(club.getMembers(), "members.csv");
        clubSaver.saveTrainingResults(club.getTrainingResults(), "trainingresults.csv");
        clubSaver.saveCompetitionResults(club.getCompetitionResults(), "competitionresults.csv");
        IO.println("Alle data blev gemt.");
    } catch (IOException e) {
        IO.println("Kunne ikke gemmes. ");

    }







}