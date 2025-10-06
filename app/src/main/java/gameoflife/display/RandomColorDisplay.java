package display;

import observer.Observer;
import color.*;

import java.util.List;
import java.util.Random;

public class RandomColorDisplay implements Display, Observer {
    private final List<Color> colors = List.of(new White(), new Red(), new Blue(), new Green(), new Yellow(), new Magenta());

    @Override
    public void display() {
        //TODO
    }

    @Override
    public void update() {

    }

    private Color randomColor() {
        Random random = new Random();
        return colors.get(random.nextInt(0, colors.size()));
    }
}
