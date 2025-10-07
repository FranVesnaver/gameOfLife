package gameoflife;

import gameoflife.display.boarddisplay.BoardDisplay;
import gameoflife.display.boarddisplay.LivingWhiteDeadBlackBoardDisplay;
import gameoflife.display.boarddisplay.RandomColorBoardDisplay;
import gameoflife.display.statisticsdisplay.PopulationStatisticsDisplay;
import gameoflife.display.statisticsdisplay.RulesAppliedDisplay;
import gameoflife.display.statisticsdisplay.StatisticsDisplay;

import java.util.Scanner;

public class App {

    public static void main(String[] args) throws InterruptedException {
        GameOfLife gameOfLife = new GameOfLife(10,10);
        BoardDisplay boardDisplay = new RandomColorBoardDisplay(gameOfLife);
        StatisticsDisplay demographicStatisticsDisplay = new PopulationStatisticsDisplay(gameOfLife, 5);
        StatisticsDisplay rulesStatisticsDisplay = new RulesAppliedDisplay(gameOfLife, 5);
        gameOfLife.notifyObservers();
//        gameOfLife.setRule(new HighLifeRule());
//        gameOfLife.setRule(new BreederRule());
//        gameOfLife.setRule(new DiffusionRule());
//        gameOfLife.setRule(new LifeWithoutDeathRule());

//        gameOfLife.setColorRule(new RandomColorRule());
//        gameOfLife.setColorRule(new ImmigrationColorRule());

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
