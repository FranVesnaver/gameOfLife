package gameoflife.display.statisticsdisplay;

import gameoflife.Board;
import gameoflife.observer.Observer;
import gameoflife.observer.Subject;

public class RulesAppliedDisplay implements StatisticsDisplay, Observer {
    private Board board;
    private int birthRulesApplied;
    private int surviveRulesApplied;
    private int deathRulesApplied;

    private int birthRulesAppliedInThisIteration;
    private int surviveRulesAppliedInThisIteration;
    private int deathRulesAppliedInThisIteration;

    private int iterationsPerReport;
    private int currentIteration;

    public RulesAppliedDisplay(Subject subject, int iterationsPerReport) {
        subject.registerObserver(this);
        this.iterationsPerReport = iterationsPerReport;
        currentIteration = 0;
        birthRulesApplied = 0;
        surviveRulesApplied = 0;
        deathRulesApplied = 0;
    }

    @Override
    public void displayStatistics() {
        System.out.println("Rules applied in this generation:");
        System.out.println("\tBirth rules: " + birthRulesAppliedInThisIteration);
        System.out.println("\tSurvive rules: " + surviveRulesAppliedInThisIteration);
        System.out.println("\tDeath rules: " + deathRulesAppliedInThisIteration);
        if (currentIteration % iterationsPerReport == 0) {
            System.out.println("Average of the rules applied:");
            System.out.println("\tBirths average: " + (float) birthRulesApplied / (float) currentIteration);
            System.out.println("\tSurvives average: " + (float) surviveRulesApplied / (float) currentIteration);
            System.out.println("\tDeaths average: " + (float) deathRulesApplied / (float) currentIteration);
        }
        birthRulesAppliedInThisIteration = 0;
        surviveRulesAppliedInThisIteration = 0;
        deathRulesAppliedInThisIteration = 0;
    }

    @Override
    public void update(Board board) {
        if (this.board != null) {
            Board oldBoard = this.board;

            for (int row = 0; row < oldBoard.getRows(); row++) {
                for (int col = 0; col < oldBoard.getColumns(); col++) {

                    if (oldBoard.getCellAt(row, col).getState().isAlive()) {
                        if (board.getCellAt(row, col).getState().isAlive())
                            surviveRulesAppliedInThisIteration++;
                        else
                            deathRulesAppliedInThisIteration++;
                    } else {
                        if (board.getCellAt(row, col).getState().isAlive())
                            birthRulesAppliedInThisIteration++;
                    }
                }
            }
            birthRulesApplied += birthRulesAppliedInThisIteration;
            surviveRulesApplied += surviveRulesAppliedInThisIteration;
            deathRulesApplied += deathRulesAppliedInThisIteration;
        }
        this.board = board;
        currentIteration++;
    }
}
