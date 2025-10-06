package gameoflife.color;

public class Blue extends Color {
    @Override
    public String getColor() {
        return "\u001B[34m";
    }

    @Override
    public String toString() {
        return "Blue";
    }
}
