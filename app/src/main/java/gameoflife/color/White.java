package gameoflife.color;

public class White extends Color {
    @Override
    public String getColor() {
        return "\u001B[37m";
    }
}