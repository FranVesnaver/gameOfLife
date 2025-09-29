package display;

import color.*;

import java.util.List;
import java.util.Random;

public class RandomColorDisplay implements Display {
    private final List<Color> colors = List.of(new White(), new Red(), new Blue(), new Green(), new Yellow(), new Magenta());

    @Override
    public void display() {
        //TODO
    }

    private Color randomColor() {
        Random random = new Random();
        return colors.get(random.nextInt(0, colors.size()));
    }
}
