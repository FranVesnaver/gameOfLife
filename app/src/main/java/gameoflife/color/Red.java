package gameoflife.color;

public class Red extends Color {
    @Override
    public String getColor() {
        return "\u001B[31m";
    }

    @Override
    public String toString() {
        return "Red";
    }
}
