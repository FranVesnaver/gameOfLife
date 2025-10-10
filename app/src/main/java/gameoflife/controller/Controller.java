package gameoflife.controller;

import gameoflife.model.GameOfLife;
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
        view.startMessages();
        int generations = scanner.nextInt();

        for (int i = 1; i <= generations; i++) {
            boardDisplay.displayBoard();
            for (StatisticsDisplay statisticsDisplay : statisticsDisplays)
                statisticsDisplay.displayStatistics();

            model.computeNextGeneration();

            System.out.println("Generation: " + i);
            Thread.sleep(2000);
        }
    }
}
