package color;

public class White implements Color {
    @Override
    public String getColor() {
        return "\u001B[37m";
    }
}