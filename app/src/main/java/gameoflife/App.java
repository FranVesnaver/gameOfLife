package gameoflife;

import gameoflife.model.GameOfLife;
import gameoflife.view.boarddisplay.BoardDisplay;
import gameoflife.view.boarddisplay.LivingWhiteDeadBlackBoardDisplay;
import gameoflife.view.statisticsdisplay.PopulationStatisticsDisplay;
import gameoflife.view.statisticsdisplay.RulesAppliedDisplay;
import gameoflife.view.statisticsdisplay.StatisticsDisplay;
import gameoflife.gamemode.ClassicModeFactory;

import java.util.Scanner;

public class App {

    public static void main(String[] args) throws InterruptedException {
        GameOfLife gameOfLife = new GameOfLife(10,10, new ClassicModeFactory());
        BoardDisplay boardDisplay = new LivingWhiteDeadBlackBoardDisplay(gameOfLife);
        StatisticsDisplay demographicStatisticsDisplay = new PopulationStatisticsDisplay(gameOfLife, 5);
        StatisticsDisplay rulesStatisticsDisplay = new RulesAppliedDisplay(gameOfLife, 5);
        gameOfLife.notifyObservers();

        Scanner scanner = new Scanner(System.in);

        boardDisplay.displayBoard();
        demographicStatisticsDisplay.displayStatistics();
        rulesStatisticsDisplay.displayStatistics();

        // glider
        gameOfLife.setLivingCell(1, 2);
        gameOfLife.setLivingCell(2, 2);
        gameOfLife.setLivingCell(3, 2);
        gameOfLife.setLivingCell(3, 1);
        gameOfLife.setLivingCell(2, 0);

        // helicopter
        gameOfLife.setLivingCell(1,8);
        gameOfLife.setLivingCell(2,8);
        gameOfLife.setLivingCell(3,8);

        gameOfLife.setLivingCell(9, 0);
        gameOfLife.setLivingCell(9, 1);
        gameOfLife.setLivingCell(9, 2);
        gameOfLife.setLivingCell(7, 0);
        gameOfLife.setLivingCell(7, 1);
        gameOfLife.setLivingCell(7, 2);


        System.out.print("Select number of generations to simulate: ");
        int generations = scanner.nextInt();

        for (int i = 1; i <= generations; i++) {
            boardDisplay.displayBoard();
            demographicStatisticsDisplay.displayStatistics();
            rulesStatisticsDisplay.displayStatistics();
            gameOfLife.computeNextGeneration();

            System.out.println("Generation: " + i);
            Thread.sleep(2000);
        }
    }
}
