package gameoflife.controller;

import gameoflife.model.GameOfLife;
import gameoflife.statebehavior.Alive;
import gameoflife.statebehavior.Dead;
import gameoflife.view.ConsoleView;
import gameoflife.view.View;
import gameoflife.view.boarddisplay.BoardDisplay;
import gameoflife.view.boarddisplay.LivingWhiteDeadBlackBoardDisplay;
import gameoflife.view.statisticsdisplay.PopulationStatisticsDisplay;
import gameoflife.view.statisticsdisplay.RulesAppliedDisplay;
import gameoflife.view.statisticsdisplay.StatisticsDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    GameOfLife model;
    BoardDisplay boardDisplay;
    List<StatisticsDisplay> statisticsDisplays;
    View view;
    Scanner scanner;

    public Controller(GameOfLife model) {
        this.model = model;
        this.boardDisplay = new LivingWhiteDeadBlackBoardDisplay(model);                                // this depends on a concrete class
        this.view = new ConsoleView();
        this.statisticsDisplays = new ArrayList<>();
        this.statisticsDisplays.add(new PopulationStatisticsDisplay(model, 5));        // this depends on a concrete class
        this.statisticsDisplays.add(new RulesAppliedDisplay(model, 5));                // this depends on a concrete class
        model.notifyObservers();
        scanner = new Scanner(System.in);
    }

    public void startGameLoop() throws InterruptedException {
        boolean ready = false;

        view.startMessages();

        while(!ready) {
            try {
                boardDisplay.displayBoard();
                ready = toggleCellsOnOff();
            } catch (IllegalArgumentException e) {
                view.errorMessage(e.getMessage());
            }
        }

        view.generationsMessage();
        Integer generations = null;
        while (generations == null) {
            try {
                generations = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                view.errorMessage("Invalid input: " + e.getMessage());
            }
        }

        for (int i = 1; i <= generations; i++) {
            boardDisplay.displayBoard();
            for (StatisticsDisplay statisticsDisplay : statisticsDisplays)
                statisticsDisplay.displayStatistics();

            model.computeNextGeneration();

            view.generationNumber(i);
            Thread.sleep(2000);
        }
    }

    private boolean toggleCellsOnOff() {
        view.toggleCellOnOffMessages();
        String cell = scanner.nextLine();

        if (cell.equalsIgnoreCase("start".trim())) {
            return true;
        } else if (!cell.matches("\\d+\\s*,\\s*\\d+"))
            throw new IllegalArgumentException("Invalid cell input\n Format: <row>, <column>");

        String[] parts = cell.split("\\s*,\\s*");
        int row = Integer.parseInt(parts[0])-1;
        int col = Integer.parseInt(parts[1])-1;

        if (!model.getBoard().isInTheGrid(row,col))
            throw new IllegalArgumentException("Position out of the board");

        if (model.getBoard().getCellAt(row, col).getState().isAlive())
            model.getBoard().getCellAt(row, col).setState(new Dead());
        else
            model.getBoard().getCellAt(row, col).setState(new Alive());

        return false;
    }

    // test method
    public void setTestFigures() {
        // glider
        model.setLivingCell(1, 2);
        model.setLivingCell(2, 2);
        model.setLivingCell(3, 2);
        model.setLivingCell(3, 1);
        model.setLivingCell(2, 0);

        // helicopter
        model.setLivingCell(1,8);
        model.setLivingCell(2,8);
        model.setLivingCell(3,8);

        model.setLivingCell(9, 0);
        model.setLivingCell(9, 1);
        model.setLivingCell(9, 2);
        model.setLivingCell(7, 0);
        model.setLivingCell(7, 1);
        model.setLivingCell(7, 2);

    }
}
