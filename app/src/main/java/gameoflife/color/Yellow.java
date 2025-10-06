package gameoflife.color;

public class Yellow extends Color {
    @Override
    public String getColor() {
        return "\u001B[33m";
    }

    @Override
    public String toString() {
        return "Yellow";
    }
}
