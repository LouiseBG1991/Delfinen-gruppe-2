import java.util.ArrayList;
import java.util.List;

public class TrainerAdministration {

    private Team team;
    private List<TrainingResult> trainingResults;
    private List<CompetitionResult> competitionResults;

    public TrainerAdministration(Team team) {
        this.team = team;
        this.trainingResults = new ArrayList<>();
        this.competitionResults = new ArrayList<>();

    }

    public void addTrainingResults(TrainingResult result) {
        trainingResults.add(result);
    }

    public void addCompetitionResults(CompetitionResult result) {
        competitionResults.add(result);
    }

    public List<TrainingResult> getBestResultInEachDiscipline(List<Member> competitionSvimmers) {
        List<TrainingResult> bestResults = new ArrayList<>();

        List<Discipline> disciplines = List.of(
                Discipline.CRAWL,
                Discipline.BACKSTROKE,
                Discipline.BREASTSTROKE,
                Discipline.BUTTERFLY
        );

        for (Discipline discipline : disciplines) {

            TrainingResult bestResult = null;

            for (TrainingResult result : trainingResults) {
                if (competitionSvimmers.contains(result.getMember()) && result.getDiscipline() == discipline) {
                    if (bestResult == null || result.getFinishTime() < bestResult.getFinishTime()) {
                        bestResult = result;
                    }
                }
            }
            if (bestResult != null) {
                bestResults.add(bestResult);

            }
        }

        return bestResults;
    }


//    public List<TrainingResult> getTop5InEachDiscipline() {
//        //færdiggør
//        //    public List<CompetitionSwimmer> getTop5(Discipline discipline) {
////        List<CompetitionSwimmer> qualified = new ArrayList<>();
////
////        for (CompetitionSwimmer swimmer : swimmers) {
////            if (swimmer.getBestResult(discipline) != null) {
////                qualified.add(swimmer);
////            }
////        }
////        // Sorterer fra hurtigste (laveste finishTime) til langsomste
////        qualified.sort(Comparator.comparing(swimmer -> swimmer.getBestResult(discipline).getFinishTime()));
////
////        return qualified.subList(0, Math.min(5, qualified.size()));
////    }
//    }


}
