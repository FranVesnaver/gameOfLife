package gameoflife;

import gameoflife.controller.Controller;
import gameoflife.model.GameOfLife;
import gameoflife.gamemode.ClassicModeFactory;

public class App {

    public static void main(String[] args) throws InterruptedException {
        GameOfLife gameOfLife = new GameOfLife(10,10, new ClassicModeFactory());
        Controller controller = new Controller(gameOfLife);
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

        controller.startGameLoop();
    }
}
