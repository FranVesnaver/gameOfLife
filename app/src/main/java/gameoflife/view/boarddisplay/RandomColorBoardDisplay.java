package gameoflife.view.boarddisplay;

import gameoflife.model.Board;
import gameoflife.color.*;
import gameoflife.observer.Observer;
import gameoflife.observer.Subject;

import java.util.List;
import java.util.Random;

public class RandomColorBoardDisplay implements BoardDisplay, Observer {
    private final List<Color> colors = List.of(new White(), new Red(), new Blue(), new Green(), new Yellow(), new Magenta(), new Black());
    private Board board;

    public RandomColorBoardDisplay(Subject subject) {
        subject.registerObserver(this);
    }

    public void displayBoard() {
        System.out.println(board.toString());
    }

    @Override
    public void update(Board board) {
        // make a copy of the board
        Board copy = new Board(board.getRows(), board.getColumns());
        copy.setGrid(board.getGrid());

        for (int row = 0; row < copy.getRows(); row++) {
            for (int col = 0; col < copy.getColumns(); col++) {
                if (copy.getCellAt(row, col).getState().isAlive())
                    copy.getCellAt(row, col).setColor(randomColor());
                else
                    copy.getCellAt(row, col).setColor(new Black());
            }
        }

        this.board = copy;
    }

    private Color randomColor() {
        Random random = new Random();
        return colors.get(random.nextInt(0, colors.size()));
    }
}
