package gameoflife.color;

public class Magenta extends Color {
    @Override
    public String getColor() {
        return "\u001B[35m";
    }

    @Override
    public String toString() {
        return "Magenta";
    }
}
