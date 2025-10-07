package gameoflife;

import gameoflife.color.Color;
import gameoflife.statebehavior.Dead;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int rows;
    private final int columns;
    private Cell[][] grid;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        grid = new Cell[rows][columns];
        initializeBoardWithDeadCells();
    }

    public Cell getCellAt(int row, int column) {
        return grid[row][column];
    }

    public void setCellAt(int row, int column, Cell cell) {
        grid[row][column] = cell;
    }

    public int getLivingNeighbours(int row, int column) {
        List<Cell> neighbours = getCellNeighbours(row, column);
        int result = 0;
        for (Cell cell : neighbours)
            if (cell.getState().isAlive()) result++;

        return result;
    }

    public List<Color> getNeighboursColors(int row, int column) {
        List<Color> colors = new ArrayList<>();

        for (Cell neighbour : getCellNeighbours(row, column))
            colors.add(neighbour.getColor());

        return colors;
    }

    private List<Cell> getCellNeighbours (int row, int column) {
        List<Cell> neighbours = new ArrayList<>();
        if (isInTheGrid(row-1, column-1)) neighbours.add(getCellAt(row-1, column-1));
        if (isInTheGrid(row-1, column)) neighbours.add(getCellAt(row-1, column));
        if (isInTheGrid(row-1, column+1)) neighbours.add(getCellAt(row-1, column+1));

        if (isInTheGrid(row, column-1)) neighbours.add(getCellAt(row, column-1));
        if (isInTheGrid(row, column+1)) neighbours.add(getCellAt(row, column+1));

        if (isInTheGrid(row+1, column-1)) neighbours.add(getCellAt(row+1, column-1));
        if (isInTheGrid(row+1, column)) neighbours.add(getCellAt(row+1, column));
        if (isInTheGrid(row+1, column+1)) neighbours.add(getCellAt(row+1, column+1));

        return neighbours;
    }

    private void initializeBoardWithDeadCells() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                setCellAt(i, j, new Cell(new Dead(), null));
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void setGrid(Cell[][] grid) {
        this.grid = grid;
    }

    @Override
    public String toString() {
        String defaultColor = "\u001B[37m";
        StringBuilder string = new StringBuilder();

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (getCellAt(i,j).getState().isAlive()) {
                    String color = getCellAt(i,j).getColor().getColor();
                    string.append(color).append(" ☻ ").append(defaultColor);
                }
                else
                    string.append(" ☺ ");
            }
            string.append("\n");
        }

        return string.toString();
    }

    private boolean isInTheGrid(int row, int column) {
        return  row >= 0 &&
                row < rows &&
                column >= 0 &&
                column < columns;
    }
}
