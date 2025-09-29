package color;

public class Magenta implements Color {
    @Override
    public String getColor() {
        return "\u001B[35m";
    }
}
