package gameoflife;

import gameoflife.controller.Controller;
import gameoflife.model.GameOfLife;
import gameoflife.gamemode.ClassicModeFactory;

public class App {

    public static void main(String[] args) throws InterruptedException {
        GameOfLife gameOfLife = new GameOfLife(10,10, new ClassicModeFactory());
        Controller controller = new Controller(gameOfLife);

        controller.setTestFigures();
        controller.startGameLoop();
    }
}
