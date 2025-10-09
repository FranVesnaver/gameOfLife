package gameoflife.view.boarddisplay;

import gameoflife.model.Board;
import gameoflife.color.Black;
import gameoflife.color.White;
import gameoflife.observer.Observer;
import gameoflife.observer.Subject;

public class LivingWhiteDeadBlackBoardDisplay implements BoardDisplay, Observer {
    private Board board;

    public LivingWhiteDeadBlackBoardDisplay(Subject subject) {
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
                    copy.getCellAt(row, col).setColor(new White());
                else
                    copy.getCellAt(row, col).setColor(new Black());
            }
        }

        this.board = copy;
    }
}
