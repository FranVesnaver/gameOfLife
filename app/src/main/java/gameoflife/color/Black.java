package gameoflife.color;

public class Black extends Color {
    @Override
    public String getColor() {
        return "\u001B[30m";
    }

    @Override
    public String toString() {
        return "Black";
    }
}
