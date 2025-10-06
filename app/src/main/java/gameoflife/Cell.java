package gameoflife;

import gameoflife.color.Color;
import gameoflife.color.White;
import gameoflife.stateBehavior.StateBehavior;

public class Cell {
    StateBehavior state;
    Color color;

    public Cell(StateBehavior state, Color color) {
        this.state = state;
        this.color = (color != null) ? color : new White();
    }

    public void setState(StateBehavior state) {
        this.state = state;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
