package color;

public class Red implements Color {
    @Override
    public String getColor() {
        return "\u001B[31m";
    }
}
