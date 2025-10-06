package gameoflife.display.statisticsdisplay;

import gameoflife.Board;
import gameoflife.color.Color;
import gameoflife.observer.Observer;
import gameoflife.observer.Subject;
import gameoflife.stateBehavior.StateBehavior;

import java.util.HashMap;
import java.util.Map;

public class PoblationalStatisticsDisplay implements StatisticsDisplay, Observer {
    private Board board;

    public PoblationalStatisticsDisplay(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void displayStatistics() {
        System.out.println("Cells alive/dead: ");
        System.out.println(getStateStatistics());
        System.out.println("Cells by color: ");
        System.out.println(getColorStatistics());
    }

    @Override
    public void update(Board board) {
        this.board = board;
    }

    private String getStateStatistics() {
        StringBuilder result = new StringBuilder();
        Map<StateBehavior, Integer> states = new HashMap<>();

        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col < board.getRows(); col++) {
                StateBehavior currentCellState = board.getCellAt(row, col).getState();
                states.put(currentCellState, states.getOrDefault(currentCellState, 0) + 1);
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
            }
        }

        for (Color color : colors.keySet()) {
            result.append("\t").append(color).append(": ").append(colors.get(color)).append(" cells").append("\n");
        }

        return result.toString();
    }
}
