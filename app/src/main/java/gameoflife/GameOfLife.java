package gameoflife;

import gameoflife.gamemode.AbstractGameModeFactory;
import gameoflife.observer.Observer;
import gameoflife.observer.Subject;
import gameoflife.color.Color;
import gameoflife.colorRule.ColorRule;
import gameoflife.rule.Rule;
import gameoflife.statebehavior.Alive;
import gameoflife.statebehavior.Dead;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife implements Subject {

    private Board board;
    private Rule rule;
    private ColorRule colorRule;

    private List<Observer> observers;

    public GameOfLife(int rows, int columns, AbstractGameModeFactory factory) {
        board = new Board(rows, columns);
        this.rule = factory.createRule();
        this.colorRule = factory.createColorRule();
        observers = new ArrayList<>();
    }

    public void computeNextGeneration() {
        Board oldBoard = board;
        board = new Board(oldBoard.getRows(), oldBoard.getColumns());

        for (int i = 0; i < oldBoard.getRows(); i++) {
            for (int j = 0; j < oldBoard.getColumns(); j++) {

                if (oldBoard.getCellAt(i, j).getState().isAlive()) {
                    if (!rule.survives(oldBoard.getLivingNeighbours(i, j)))
                        setDeadCell(i, j);
                    else
                        setLivingCell(i, j, oldBoard.getCellAt(i,j).getColor());
                } else {
                    if (rule.born(oldBoard.getLivingNeighbours(i, j)))
                        setLivingCell(i, j, colorRule.colorAtBirth(oldBoard.getNeighboursColors(i,j)));
                    else
                        setDeadCell(i, j);
                }
            }
        }
        notifyObservers();
    }

    public void setLivingCell(int row, int column) {
        board.setCellAt(row, column, new Cell(new Alive(), null));
    }

    public void setLivingCell(int row, int column, Color color) {
        board.setCellAt(row, column, new Cell(new Alive(), color));
    }

    public void setDeadCell(int row, int column) {
        board.setCellAt(row, column, new Cell(new Dead(), null));
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public ColorRule getColorRule() {
        return colorRule;
    }

    public void setColorRule(ColorRule colorRule) {
        this.colorRule = colorRule;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers)
            o.update(board);
    }
}
