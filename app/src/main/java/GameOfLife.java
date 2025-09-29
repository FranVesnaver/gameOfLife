import color.Color;
import rule.ClassicRule;
import colorRule.ColorRule;
import colorRule.NoColorRule;
import rule.Rule;
import stateBehavior.Alive;
import stateBehavior.Dead;

public class GameOfLife {

    private Board board;
    private Rule rule;
    private ColorRule colorRule;

    public GameOfLife(int rows, int columns) {
        board = new Board(rows, columns);
        this.rule = new ClassicRule();
        this.colorRule = new NoColorRule();
    }

    public void computeNextGeneration() {
        Board oldBoard = board;
        board = new Board(oldBoard.getRows(), oldBoard.getColumns());

        for (int i = 0; i < oldBoard.getRows(); i++) {
            for (int j = 0; j < oldBoard.getColumns(); j++) {

                if (oldBoard.getCellAt(i, j).state.isAlive()) {
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
    }

    public void displayGrid() {
        System.out.println(board);
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
}
