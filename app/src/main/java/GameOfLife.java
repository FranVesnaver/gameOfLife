import colorRule.ColorRule;
import rule.Rule;

public interface GameOfLife {
    void displayGrid();
    void setLivingCell(int row, int column);
    void setDeadCell(int row, int column);
    void computeNextGeneration();
    void setRule(Rule rule);
    void setColorRule(ColorRule colorRule);
}
