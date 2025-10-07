package gameoflife.display.statisticsdisplay;

import gameoflife.Board;
import gameoflife.color.Color;
import gameoflife.observer.Observer;
import gameoflife.observer.Subject;
import gameoflife.statebehavior.StateBehavior;

import java.util.HashMap;
import java.util.Map;

public class PopulationStatisticsDisplay implements StatisticsDisplay, Observer {
    private Board board;
    private Map<StateBehavior, Integer> statesAverage;
    private Map<Color, Integer> colorsAverage;
    private int iterationsPerReport;
    private int currentIteration;

    public PopulationStatisticsDisplay(Subject subject, int iterationsPerAveragesReport) {
        subject.registerObserver(this);
        statesAverage = new HashMap<>();
        colorsAverage = new HashMap<>();
        this.iterationsPerReport = iterationsPerAveragesReport;
        this.currentIteration = 0;
    }

    @Override
    public void displayStatistics() {
        System.out.println("Cells alive/dead: ");
        System.out.println(getStateStatistics());
        System.out.println("Cells by color: ");
        System.out.println(getColorStatistics());
        if (currentIteration % iterationsPerReport == 0) {
            System.out.println("States average:");
            System.out.println(getStatesAverage());
            System.out.println("Colors average:");
            System.out.println(getColorsAverage());
        }
    }

    @Override
    public void update(Board board) {
        this.board = board;
        currentIteration++;
    }

    private String getStateStatistics() {
        StringBuilder result = new StringBuilder();
        Map<StateBehavior, Integer> states = new HashMap<>();

        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col < board.getRows(); col++) {
                StateBehavior currentCellState = board.getCellAt(row, col).getState();
                states.put(currentCellState, states.getOrDefault(currentCellState, 0) + 1);
                statesAverage.put(currentCellState, statesAverage.getOrDefault(currentCellState, 0) + 1);
            }
        }

        for (StateBehavior state : states.keySet()) {
            result.append("\t").append(state).append(": ").append(states.get(state)).append(" cells").append("\n");
        }

        return result.toString();
    }

    private String getColorStatistics() {
        StringBuilder result = new StringBuilder();
        Map<Color, Integer> colors = new HashMap<>();

        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col < board.getRows(); col++) {
                Color currentCellColor = board.getCellAt(row, col).getColor();
                colors.put(currentCellColor, colors.getOrDefault(currentCellColor, 0) + 1);
                colorsAverage.put(currentCellColor, colorsAverage.getOrDefault(currentCellColor, 0) + 1);
            }
        }

        for (Color color : colors.keySet()) {
            result.append("\t").append(color).append(": ").append(colors.get(color)).append(" cells").append("\n");
        }

        return result.toString();
    }

    private String getStatesAverage() {
        StringBuilder result = new StringBuilder();

        for (StateBehavior state : statesAverage.keySet()) {
            result.append("\t").append(state).append(" average").append(": ").append((float) statesAverage.get(state) / (float) currentIteration);
        }

        return result.toString();
    }

    private String getColorsAverage() {
        StringBuilder result = new StringBuilder();

        for (Color color : colorsAverage.keySet()) {
            result.append("\t").append(color).append(" average").append(": ").append((float) colorsAverage.get(color) / (float) currentIteration).append("\n");
        }

        return result.toString();
    }
}
